package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.entity.model.MUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/1/9.
 */
public interface MUserMapper extends BaseMapper<MUser> {


    Integer insertSelective(MUser record);

    MUser selectById(@Param("user_id") Integer user_id);

    MUser selectUser(@Param("username") String username);

    MUser login(@Param("username") String username,@Param("password") String password);

    List<MUser>  selectList(@Param("map") Map<String,Object> map, @Param("username") String username);

}