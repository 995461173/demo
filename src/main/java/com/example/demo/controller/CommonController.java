package com.example.demo.controller;

import com.example.demo.entity.response.TResult;
import com.example.demo.statconst.C;
import com.example.demo.util.StringUtil;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by lenovo on 2018/3/28.
 */
@RestController
@RequestMapping("/oa/v1/common")
@MultipartConfig(fileSizeThreshold = 20971520)
@Api(value = "common", description = "上传和下载", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommonController {

    protected final static Logger logger = LoggerFactory.getLogger(CommonController.class);
    @Autowired
    private org.springframework.core.env.Environment env;

    @PostMapping("/upload")
    @ApiOperation(value = "文件上传", notes = "文件上传", httpMethod = "POST", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 0, message = "成功返回"),
            @ApiResponse(code = 403, message = "没有权限访问接口", response = String.class),
    })
    public TResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (file.getSize() > 1024 * 1024 * 30) {
            return new TResult<>(C.ERROR_CODE_FILE_SIZE, C.ERROR_MSG_FILE_SIZE, null);
        }

        if (file != null && !file.isEmpty()) {
            String uploadFilePath = file.getOriginalFilename();
            long currentTime = System.currentTimeMillis();
            String uploadFileSuffix = uploadFilePath.substring(uploadFilePath.indexOf('.') + 1, uploadFilePath.length());
            BufferedOutputStream bufferedOutputStream = null;
            FileOutputStream fileOutputStream = null;
            if (!StringUtil.checkVoiceFormat(uploadFileSuffix)) {
                return new TResult(C.ERROR_CODE_FILE_FORMAT, C.ERROR_MSG_FILE_FORMAT, null);
            }
            File savePath = new File(C.MEDIA_UPLOAD_LOCATION_ROOT + C.MEDIA_UPLOAD_LOCATION_OTHER + StringUtil.getRandomString(10) + "_" + currentTime + "." + uploadFileSuffix);


            try {
                fileOutputStream = new FileOutputStream(savePath);
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                bufferedOutputStream.write(file.getBytes());
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                if ("loc".equals(env.getProperty("profile"))) {
                    String filePath = "http://localhost:9091/" + savePath;
                    return new TResult(0, "上传成功！", filePath);
                } else if ("dev".equals(env.getProperty("profile"))) {
                   // String filePath = "http://nf.jclang.me/" + savePath;
                 //   return new TResult(0, "上传成功！", filePath);
                }

            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return new TResult<>(C.ERROR_CODE_INVALID_FILE, C.ERROR_MSG_INVALID_FILE, null);

    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    @ApiOperation(value = "文件下载", notes = "文件下载", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    public TResult testDownload(@ApiParam(name = "library_id", value = "文库id", required = true) Long library_id,
                                // @ApiParam(name = "user_id", value = "用户id", required = true) String user_id,
                                HttpServletRequest request, HttpServletResponse res) {

        //获取文件名
//        MLibrary mLibrary = libraryService.selectDetail(library_id);
//        MUser mUser = userService.findByUserId(SpringUtil.getSessionUserId(request));
//        if(mUser.getIntegration() < mLibrary.getScore()){
//            return new TResult(C.ERROR_CODE_USER_SCORE, C.ERROR_MSG_USER_SCORE, null);
//        }
//
//        String[] a = mLibrary.getAccessory_url().split("/");
        //String fileName = a[a.length - 1];
        String fileName = "";
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File("./load/other/" + fileName)));

            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
                break;
            }

            System.out.println("--------下载--------success");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new TResult(0, null, null);
    }
}
