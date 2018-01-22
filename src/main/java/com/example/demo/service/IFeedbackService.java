package com.example.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.demo.entity.model.MFeedback;
import com.example.demo.entity.response.SCount;

import java.util.List;
import java.util.Map;

public interface IFeedbackService extends IService<MFeedback> {

    boolean insert(MFeedback record);

    Integer insertSelective(MFeedback record);

    List<MFeedback> feedbackList(Map<String, Object> map);

    SCount FeedbackListCount();
}
