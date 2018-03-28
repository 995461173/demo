package com.example.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.demo.entity.model.MUser;

import java.util.List;
import java.util.Map;

public interface IUserService extends IService<MUser> {

    Integer insertSelective(MUser record);

    MUser selectById(Integer user_id);

    MUser selectUser(String username);

    MUser login( String username, String password);

    List<MUser> selectList(Map<String,Object> map, String username);

}
