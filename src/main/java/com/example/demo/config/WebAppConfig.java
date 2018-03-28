package com.example.demo.config;

import com.example.demo.interceptor.WebInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    protected final static Logger logger = LoggerFactory.getLogger(WebAppConfig.class);
    @Value("${cbs.imagesPath}")
    private String mImagesPath;
    @Autowired
    private org.springframework.core.env.Environment env;

//    @Bean
//    public WebInterceptor myInterceptor(){
//        return new WebInterceptor();
//    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 配置请求拦截器
//        registry.addInterceptor(myInterceptor()).addPathPatterns("/oa/**");
//        super.addInterceptors(registry);
//    }
    //win系统下的路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if ("loc".equals(env.getProperty("profile"))) {
            registry.addResourceHandler("/load/**").addResourceLocations("file:/F:/sql/OA/load/other");
        }else if("dev".equals(env.getProperty("profile"))){
            registry.addResourceHandler("/load/**").addResourceLocations("file:////home/lc/work_publish/api/load/other");
        }
       // registry.addResourceHandler("/load/**").addResourceLocations("file:/D:/southern_powergrid/code/api/powergrid/load/pic");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        if(mImagesPath.equals("") || mImagesPath.equals("${cbs.imagesPath}")){
//            String imagesPath = WebAppConfig.class.getClassLoader().getResource("").getPath();
//            if(imagesPath.indexOf(".jar")>0){
//                imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
//            }else if(imagesPath.indexOf("classes")>0){
//                imagesPath = "file:"+imagesPath.substring(0, imagesPath.indexOf("classes"));
//            }
//            imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/"));
//            mImagesPath = imagesPath;
//        }
//        LoggerFactory.getLogger(WebAppConfig.class).info("imagesPath="+mImagesPath);
//        registry.addResourceHandler("/load/**").addResourceLocations(mImagesPath);
//        // TODO Auto-generated method stub
//        super.addResourceHandlers(registry);
//    }

}
