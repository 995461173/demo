package com.example.dome.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.dome.entity.model.MFeedback;
import com.example.dome.entity.model.MUser;
import com.example.dome.entity.response.SCount;
import com.example.dome.mapper.MFeedbackMapper;
import com.example.dome.mapper.MUserMapper;
import com.example.dome.service.IFeedbackService;
import com.example.dome.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<MUserMapper, MUser> implements IUserService {

    protected final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Integer insertSelective(MUser record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    public MUser selectById(Integer user_id) {
        return baseMapper.selectById(user_id);
    }

    @Override
    public MUser selectUser(String username) {
        return baseMapper.selectUser(username);
    }

    @Override
    public MUser login(String username, String password) {
        return baseMapper.login(username,password);
    }


}