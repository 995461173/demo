package com.example.demo.controller;

import com.example.demo.entity.model.MRegion;
import com.example.demo.entity.response.TResult;
import com.example.demo.service.IRegionService;
import com.example.demo.statconst.C;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/oa/v1/region")
@Api(value = "region", description = "地区相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegionController {

    protected final static Logger logger = LoggerFactory.getLogger(RegionController.class);

    @Autowired
    private IRegionService regionService;

    @GetMapping("/province/list")
    @ApiOperation(value = "获取省份列表", notes = "获取省份列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 0, message = "成功返回"),
            @ApiResponse(code = 403, message = "没有权限访问接口", response = String.class),
            @ApiResponse(code = C.ERROR_CODE_INVALID_PARAM, message = C.ERROR_MSG_INVALID_PARAM)})
    public TResult<List<MRegion>> getProvinceList() {
        return new TResult<>(0, null, regionService.getProvinceList());
    }

    @GetMapping("/city/list")
    @ApiOperation(value = "获取城市列表", notes = "获取城市列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 0, message = "成功返回"),
            @ApiResponse(code = 403, message = "没有权限访问接口", response = String.class),
            @ApiResponse(code = C.ERROR_CODE_INVALID_PARAM, message = C.ERROR_MSG_INVALID_PARAM)})
    public TResult<List<MRegion>> getProvinceList(@ApiParam(name = "parent_id", value = "省份id", required = true) @NotNull int parent_id) {
        return new TResult<>(0, null, regionService.getCityListByParentId(parent_id));
    }

    @GetMapping("/city/all")
    @ApiOperation(value = "获取全部城市列表", notes = "获取全部城市列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 0, message = "成功返回"),
            @ApiResponse(code = 403, message = "没有权限访问接口", response = String.class),
            @ApiResponse(code = C.ERROR_CODE_INVALID_PARAM, message = C.ERROR_MSG_INVALID_PARAM)})
    public TResult<List<MRegion>> getAllCityList() {
        List<MRegion> regions = regionService.getAllCity();
        List<MRegion> regionList = new ArrayList<>();
        for (MRegion region : regions) {
            if (region.getRegion_level() == 1) {
                regionList.add(region);
            }
        }
        for (MRegion region : regionList) {
            for (MRegion regionSub : regions) {
                if (regionSub.getParent_id() == region.getRegion_id()) {
                    region.getSub_regions().add(regionSub);
                }
            }
        }

        return new TResult<>(0, null, regionList);
    }

}
