package com.example.dome.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.dome.entity.model.MUser;

public interface IUserService extends IService<MUser> {

    Integer insertSelective(MUser record);

    MUser selectById(Integer user_id);

    MUser selectUser(String username);

    MUser login( String username, String password);

}
