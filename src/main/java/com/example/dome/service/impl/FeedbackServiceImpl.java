package com.example.dome.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.dome.entity.model.MFeedback;
import com.example.dome.entity.response.SCount;
import com.example.dome.mapper.MFeedbackMapper;
import com.example.dome.service.IFeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FeedbackServiceImpl extends ServiceImpl<MFeedbackMapper, MFeedback> implements IFeedbackService {

    protected final static Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);


    @Override
    public Integer insertSelective(MFeedback record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    public List<MFeedback> feedbackList(Map<String, Object> map) {
        return baseMapper.feedbackList(map);
    }

    @Override
    public SCount FeedbackListCount() {
        return baseMapper.FeedbackListCount();
    }
}
