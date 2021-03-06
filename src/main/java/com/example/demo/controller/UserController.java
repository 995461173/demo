package com.example.demo.controller;

import com.example.demo.entity.model.MUser;
import com.example.demo.entity.response.SUser;
import com.example.demo.entity.response.TResult;
import com.example.demo.service.IUserService;
import com.example.demo.statconst.C;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/1/9.
 */
@RestController
@RequestMapping("/oa/v1/user")
@Api(value = "user", description = "用户相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/add")
    @ApiOperation(value = "添加用户", notes = "添加用户", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 0, message = "成功返回"),
            @ApiResponse(code = 403, message = "没有权限访问接口", response = String.class),
            @ApiResponse(code = C.ERROR_CODE_INVALID_PARAM, message = C.ERROR_MSG_INVALID_PARAM),
            @ApiResponse(code = C.ERROR_CODE_REQUEST_FAIL, message = C.ERROR_MSG_REQUEST_FAIL)})
    public TResult<MUser> addOfficeFeedback(@Valid @RequestBody SUser sUser) {

        MUser mUser = new MUser();
        mUser.setUsername(sUser.getUsername());
        mUser.setPassword(sUser.getPassword());
        mUser.setPassswords(sUser.getPassswords());
        mUser.setAddress(sUser.getAddress());
        mUser.setPhone(sUser.getPhone());
        mUser.setEmail(sUser.getEmail());
        mUser.setQQ(sUser.getQQ());
        mUser.setSchool(sUser.getSchool());
        mUser.setAge(sUser.getAge());
        mUser.setGrade(sUser.getGrade());
        mUser.setProvince(sUser.getProvince());
        mUser.setCity(sUser.getCity());
        mUser.setRegoin(sUser.getRegoin());
        mUser.setQuestion_one(sUser.getQuestion_one());
        mUser.setAnswer_one(sUser.getAnswer_one());
        mUser.setQuestion_two(sUser.getQuestion_two());
        mUser.setAnswer_two(sUser.getAnswer_two());
        mUser.setCreate_time(System.currentTimeMillis() / 1000);
        mUser.setUpdate_time(System.currentTimeMillis() / 1000);

        if (userService.insertSelective(mUser) > 0) {
            return new TResult(0, null, mUser);
        }
        return new TResult(C.ERROR_CODE_REQUEST_FAIL, C.ERROR_MSG_REQUEST_FAIL, null);
    }

    @GetMapping(value = "/details")
    @ApiOperation(value = "用户详情", notes = "用户详情", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 0, message = "成功返回"),
            @ApiResponse(code = 403, message = "没有权限访问接口", response = String.class),
            @ApiResponse(code = C.ERROR_CODE_INVALID_PARAM, message = C.ERROR_MSG_INVALID_PARAM),
            @ApiResponse(code = C.ERROR_CODE_REQUEST_FAIL, message = C.ERROR_MSG_REQUEST_FAIL)})
    public TResult<MUser> getUserById(@ApiParam(name = "user_id", value = "用户id", required = true) Integer user_id) {
        MUser mUser = userService.selectById(user_id);
        return new TResult(0, null, mUser);
    }

    @GetMapping(value = "/login")
    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 0, message = "成功返回"),
            @ApiResponse(code = 403, message = "没有权限访问接口", response = String.class),
            @ApiResponse(code = C.ERROR_CODE_INVALID_PARAM, message = C.ERROR_MSG_INVALID_PARAM),
            @ApiResponse(code = C.ERROR_CODE_REQUEST_FAIL, message = C.ERROR_MSG_REQUEST_FAIL)})
    public TResult<MUser> login(@ApiParam(name = "username", value = "用户名", required = true) String username,
                                @ApiParam(name = "password", value = "密码", required = true) String password) {
        MUser mUser = userService.login(username, password);
        if (mUser != null) {
            return new TResult(0, null, mUser);
        }
        return new TResult(C.ERROR_CODE_REQUEST_FAIL, C.ERROR_MSG_REQUEST_FAIL, null);
    }

    @GetMapping(value = "/list")
    @ApiOperation(value = "用户列表", notes = "用户列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 0, message = "成功返回"),
            @ApiResponse(code = 403, message = "没有权限访问接口", response = String.class),
            @ApiResponse(code = C.ERROR_CODE_INVALID_PARAM, message = C.ERROR_MSG_INVALID_PARAM),
            @ApiResponse(code = C.ERROR_CODE_REQUEST_FAIL, message = C.ERROR_MSG_REQUEST_FAIL)})
    public TResult<MUser> selectList(
            @ApiParam(name = "page", value = "当前页码", required = true) int page,
            @ApiParam(name = "page_limit", value = "每页条数", required = true) int page_limit,
            @ApiParam(name = "username", value = "用户名", required = true) String username) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", (page - 1) * (page_limit));
        map.put("page_limit", page_limit);

        List<MUser> mUserList = userService.selectList(map,username);

        return new TResult(0, null, mUserList);
    }

}
