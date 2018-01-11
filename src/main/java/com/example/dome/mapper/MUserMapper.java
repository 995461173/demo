package com.example.dome.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.dome.entity.model.MUser;
import org.apache.ibatis.annotations.Param;
/**
 * Created by lenovo on 2018/1/9.
 */
public interface MUserMapper extends BaseMapper<MUser> {


    Integer insertSelective(MUser record);

    MUser selectById(@Param("user_id") Integer user_id);

    MUser selectUser(@Param("username") String username);

    MUser login(@Param("username") String username,@Param("password") String password);

}