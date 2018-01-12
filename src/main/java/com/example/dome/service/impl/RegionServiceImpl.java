package com.example.dome.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.dome.entity.model.MRegion;
import com.example.dome.mapper.MRegionMapper;
import com.example.dome.service.IRegionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl extends ServiceImpl<MRegionMapper, MRegion> implements IRegionService {

    @Override
    public int insertSelective(MRegion record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    public List<MRegion> getProvinceList() {
        return baseMapper.getProvinceList();
    }

    @Override
    public List<MRegion> getCityListByParentId(int parentId) {
        return baseMapper.getCityListByParentId(parentId);
    }

    @Override
    public List<MRegion> getAllCity() {
        return baseMapper.getAllCity();
    }

    @Override
    public MRegion getProviceByName(String area) {
        return baseMapper.getProviceByName(area);
    }

    @Override
    public MRegion getCityByName(String area) {
        return baseMapper.getCityByName(area);
    }

}
