package com.example.dome.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.dome.entity.model.MRegion;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MRegionMapper extends BaseMapper<MRegion> {

    Integer insert(MRegion record);

    Integer insertSelective(MRegion record);

    List<MRegion> getProvinceList();

    List<MRegion> getCityListByParentId(@Param("parent_id") int parentId);

    List<MRegion> getAllCity();

    MRegion getProviceByName(String area);

    MRegion getCityByName(String area);

}