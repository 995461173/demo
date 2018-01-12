package com.example.dome.service;


import com.baomidou.mybatisplus.service.IService;
import com.example.dome.entity.model.MRegion;

import java.util.List;

public interface IRegionService extends IService<MRegion> {

    boolean insert(MRegion record);

    int insertSelective(MRegion record);

    List<MRegion> getProvinceList();

    List<MRegion> getCityListByParentId(int parentId);

    List<MRegion> getAllCity();

    MRegion getProviceByName(String area);

    MRegion getCityByName(String area);
}
