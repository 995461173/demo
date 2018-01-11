package com.example.dome.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.dome.entity.model.MFeedback;
import com.example.dome.entity.response.SCount;

import java.util.List;
import java.util.Map;

public interface IFeedbackService extends IService<MFeedback> {

    boolean insert(MFeedback record);

    Integer insertSelective(MFeedback record);

    List<MFeedback> feedbackList(Map<String, Object> map);

    SCount FeedbackListCount();
}
