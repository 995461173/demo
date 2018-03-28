package com.example.demo.statconst;

import java.util.HashMap;

/**
 * Created by lenovo on 2018/1/9.
 */
public class C {
    public static boolean isInit = false;
    public static boolean DEBUG = false;

    // API请求头鉴权信息
    public static final String SUPER_KEY = "1";
    public static final String APP_APPKEY_WEB = "b0b1a56c6fa5a13dfb0ee6523127f829";
    public static final String APP_SECRET_WEB = "e8c410df2f43336044081fd7d372e58a";

    // API请求头字段
    public static final String API_HEADER_PARAM_APPKEY = "LC-Appkey";
    public static final String API_HEADER_PARAM_TIMESTAMP = "LC-Timestamp";
    public static final String API_HEADER_PARAM_SIGN = "LC-Sign";
    public static final String API_HEADER_PARAM_SESSION = "LC-Session";;
    public static final String MEDIA_UPLOAD_LOCATION_ROOT = "./load/";
    public static final String MEDIA_UPLOAD_LOCATION_PIC = "pic/";
    public static final String MEDIA_UPLOAD_LOCATION_OTHER = "other/";


    public static final int ERROR_CODE_INVALID_FILE = 2014;
    public static final String ERROR_MSG_INVALID_FILE = "无效文件";
    public static final int ERROR_CODE_FILE_SIZE = 2015;
    public static final String ERROR_MSG_FILE_SIZE = "文件大小超出限制";
    public static final int ERROR_CODE_FILE_FORMAT = 2016;
    public static final String ERROR_MSG_FILE_FORMAT = "文件格式错误";
    public static final int ERROR_CODE_FILE_DECODE = 2017;
    public static final String ERROR_MSG_FILE_DECODE = "解码文件失败";
    public static final int ERROR_CODE_FILE_UNEXIST = 2018;
    public static final String ERROR_MSG_FILE_UNEXIST = "文件不存在";
    public static final int ERROR_CODE_ORGANIZATION_EXIST = 2019;

    // web可访问接口
    public static final String[] API_PASS_WEB = new String[]{
            "/nf/v1/notice/list",


    };

    // web访问接口时需要检查登录态的接口
    public static final String[] AUTH_ADMIN_API_PATH = new String[]{

    };

    // 错误码
    public static final int ERROR_CODE_INVALID_PARAM = 1001;
    public static final String ERROR_MSG_INVALID_PARAM = "无效的请求参数";
    public static final int ERROR_CODE_REQUEST_FAIL = 1002;
    public static final String ERROR_MSG_REQUEST_FAIL = "操作失败";
    public static final int ERROR_CODE_SERVER_ERROR = 1003;
    public static final String ERROR_MSG_SERVER_ERROR = "程序异常";
    public static final int ERROR_CODE_INVALID_USER = 1004;
    public static final String ERROR_MSG_INVALID_USER = "无效的用户";

    public static HashMap<String, String[]> API_RULE_GROUP = new HashMap<String, String[]>();

}