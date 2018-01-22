package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.model.MFeedback;
import com.example.demo.entity.response.SCount;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MFeedbackMapper extends BaseMapper<MFeedback> {

    Integer insert(MFeedback record);

    Integer insertSelective(MFeedback record);

    List<MFeedback> feedbackList(@Param("map") Map<String, Object> map);

    SCount FeedbackListCount();
}