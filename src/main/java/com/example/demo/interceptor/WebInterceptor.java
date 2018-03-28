package com.example.demo.interceptor;


import com.example.demo.entity.model.MUser;
import com.example.demo.service.IUserService;
import com.example.demo.statconst.C;
import com.example.demo.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class WebInterceptor implements HandlerInterceptor {

    protected final static Logger logger = LoggerFactory.getLogger(WebInterceptor.class);
    @Autowired
    private IUserService userService;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();
        String appkey = httpServletRequest.getHeader(C.API_HEADER_PARAM_APPKEY);
        String timestamp = httpServletRequest.getHeader(C.API_HEADER_PARAM_TIMESTAMP);
        String sign = httpServletRequest.getHeader(C.API_HEADER_PARAM_SIGN);
        String session = httpServletRequest.getHeader(C.API_HEADER_PARAM_SESSION);
        String userId = "";
        if (C.DEBUG && C.SUPER_KEY.equals(appkey)) {
            return true;
        }
        if (StringUtil.isEmpty(appkey) || StringUtil.isEmpty(timestamp) || StringUtil.isEmpty(sign)) {
            if (C.DEBUG) {
                httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
            } else {
                httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://nfwechat.jclang.me/#/");
            }
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            httpServletResponse.setHeader("Access-Control-Allow-Headers", "Accept, Accept-Encoding, Accept-Language, Connection, Content-Type, DNT, Host, LC-Appkey, LC-Session, LC-Sign, LC-Timestamp, X-Requested-With, User-Agent");
            httpServletResponse.sendError(403, "forbidden request");
            return false;
        }
        if(C.APP_APPKEY_WEB.equals(appkey)){
             if(StringUtil.checkAdminApiPathPass(url)){
                if(!StringUtil.isEmpty(session)){
                userId = session.substring(32);
                session = session.substring(0, 32);
                MUser user = userService.selectById(userId);
                long session_expire_timetime = user.getSession_expire_time();
                long date = System.currentTimeMillis() / 1000;
                //1522132263
                if (session_expire_timetime < date) {
                    if (C.DEBUG) {
                        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
                    } else {
                        httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://nfwechat.jclang.me/#/");
                    }
                httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
                httpServletResponse.setHeader("Access-Control-Allow-Headers", "Accept, Accept-Encoding, Accept-Language, Connection, Content-Type, DNT, Host, LC-Appkey, LC-Session, LC-Sign, LC-Timestamp, X-Requested-With, User-Agent");
                httpServletResponse.sendError(403, "session已失效");
                return false;
                }
            }
        }
        if (C.APP_APPKEY_WEB.equals(appkey)) {
                if (checkSign(sign, C.APP_APPKEY_WEB, C.APP_SECRET_WEB, timestamp)) {
                    return true;
                } else {
                    httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
                    httpServletResponse.setHeader("Access-Control-Allow-Headers", "Accept, Accept-Encoding, Accept-Language, Connection, Content-Type, DNT, Host, LC-Appkey, LC-Session, LC-Sign, LC-Timestamp, X-Requested-With, User-Agent");
                    httpServletResponse.sendError(403, "invalid sign");
                    return false;
                }
            }
      }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private boolean checkSign(String sign, String appkey,String secret, String timestamp) {
        String content = appkey + timestamp + secret;
         logger.debug(content);
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(content.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            logger.debug(String.valueOf(sb));
            if(C.SUPER_KEY.equals(sign)){
                if (sign != null && "1".equals(sign)) {
                    return true;
                }
            }else {
                if (sign != null && sign.equals(sb.toString())) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
