package com.example.demo.controller;


import com.example.demo.entity.model.MFeedback;
import com.example.demo.entity.response.SCount;
import com.example.demo.entity.response.SFeedback;
import com.example.demo.entity.response.TResult;
import com.example.demo.service.IFeedbackService;
import com.example.demo.statconst.C;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo/feedback")
@Api(value = "feedback", description = "写字楼反馈接口", produces = MediaType.APPLICATION_JSON_VALUE)
public class FeedbackController {

    @Autowired
    private IFeedbackService xzlFeedbackService;

    @PostMapping(value = "/add")
    @ApiOperation(value = "用户反馈", notes = "用户反馈", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 0, message = "成功返回"),
            @ApiResponse(code = 403, message = "没有权限访问接口", response = String.class),
            @ApiResponse(code = C.ERROR_CODE_INVALID_PARAM, message = C.ERROR_MSG_INVALID_PARAM),
            @ApiResponse(code = C.ERROR_CODE_REQUEST_FAIL, message = C.ERROR_MSG_REQUEST_FAIL)})
    public TResult<String> addOfficeFeedback(@Valid @RequestBody SFeedback sXzlFeedback) {
        MFeedback mXzlFeedback = new MFeedback();
        mXzlFeedback.setContent(sXzlFeedback.getContent());
        mXzlFeedback.setPhone(sXzlFeedback.getPhone());
        mXzlFeedback.setCreate_time(System.currentTimeMillis() / 1000);
        if (xzlFeedbackService.insertSelective(mXzlFeedback) > 0) {
            return new TResult(0, null, mXzlFeedback);
        } else {
            return new TResult(C.ERROR_CODE_REQUEST_FAIL, C.ERROR_MSG_REQUEST_FAIL, null);
        }
    }

    @GetMapping(value = "/list")
    @ApiOperation(value = "用户反馈列表", notes = "用户反馈列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 0, message = "成功返回"),
            @ApiResponse(code = 403, message = "没有权限访问接口", response = String.class),
            @ApiResponse(code = C.ERROR_CODE_INVALID_PARAM, message = C.ERROR_MSG_INVALID_PARAM),
            @ApiResponse(code = C.ERROR_CODE_REQUEST_FAIL, message = C.ERROR_MSG_REQUEST_FAIL)})
    public TResult<List<MFeedback>> getFeedbackList(@ApiParam(name = "page", value = "当前页码", required = true) int page, @ApiParam(name = "page_limit", value = "每页条数", required = true) int page_limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", (page - 1) * (page_limit));
        map.put("page_limit", page_limit);
        List<MFeedback> mOfficeFeedback = xzlFeedbackService.feedbackList(map);
        return new TResult(0, null, mOfficeFeedback);
    }

    @GetMapping(value = "/count")
    @ApiOperation(value = "反馈总数", notes = "反馈总数", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 0, message = "成功返回"),
            @ApiResponse(code = 403, message = "没有权限访问接口", response = String.class),
            @ApiResponse(code = C.ERROR_CODE_INVALID_PARAM, message = C.ERROR_MSG_INVALID_PARAM),
            @ApiResponse(code = C.ERROR_CODE_REQUEST_FAIL, message = C.ERROR_MSG_REQUEST_FAIL)})
    public TResult<SCount> getListCount() {
        SCount count = xzlFeedbackService.FeedbackListCount();
        return new TResult<>(0, count.getCount() + "", count);
    }

}
