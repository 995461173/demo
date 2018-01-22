package com.example.demo.entity.model;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by lenovo on 2018/1/9.
 */
public class MRegion extends Model<MRegion> implements Serializable {

    private Integer region_id;
    private String region_code;
    private String region_name;
    private Integer parent_id;
    private Integer region_level;
    private Integer sort;
    private String short_name;
    private Integer end_flag;
    private Integer update_time;
    private List<MRegion> sub_regions = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    public MRegion() {
    }

    public Integer getRegion_id() {
        return this.region_id;
    }

    public void setRegion_id(Integer region_id) {
        this.region_id = region_id;
    }

    public String getRegion_code() {
        return this.region_code;
    }

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }

    public String getRegion_name() {
        return this.region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public Integer getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getRegion_level() {
        return this.region_level;
    }

    public void setRegion_level(Integer region_level) {
        this.region_level = region_level;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getShort_name() {
        return this.short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public Integer getEnd_flag() {
        return this.end_flag;
    }

    public void setEnd_flag(Integer end_flag) {
        this.end_flag = end_flag;
    }

    public Integer getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(Integer update_time) {
        this.update_time = update_time;
    }

    public List<MRegion> getSub_regions() {
        return sub_regions;
    }

    public void setSub_regions(List<MRegion> sub_regions) {
        this.sub_regions = sub_regions;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MRegion other = (MRegion) that;
        return (this.getRegion_id() == null ? other.getRegion_id() == null : this.getRegion_id().equals(other.getRegion_id()))
                && (this.getRegion_code() == null ? other.getRegion_code() == null : this.getRegion_code().equals(other.getRegion_code()))
                && (this.getRegion_name() == null ? other.getRegion_name() == null : this.getRegion_name().equals(other.getRegion_name()))
                && (this.getParent_id() == null ? other.getParent_id() == null : this.getParent_id().equals(other.getParent_id()))
                && (this.getRegion_level() == null ? other.getRegion_level() == null : this.getRegion_level().equals(other.getRegion_level()))
                && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
                && (this.getShort_name() == null ? other.getShort_name() == null : this.getShort_name().equals(other.getShort_name()))
                && (this.getEnd_flag() == null ? other.getEnd_flag() == null : this.getEnd_flag().equals(other.getEnd_flag()))
                && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRegion_id() == null) ? 0 : getRegion_id().hashCode());
        result = prime * result + ((getRegion_code() == null) ? 0 : getRegion_code().hashCode());
        result = prime * result + ((getRegion_name() == null) ? 0 : getRegion_name().hashCode());
        result = prime * result + ((getParent_id() == null) ? 0 : getParent_id().hashCode());
        result = prime * result + ((getRegion_level() == null) ? 0 : getRegion_level().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getShort_name() == null) ? 0 : getShort_name().hashCode());
        result = prime * result + ((getEnd_flag() == null) ? 0 : getEnd_flag().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", region_id=").append(region_id);
        sb.append(", region_code=").append(region_code);
        sb.append(", region_name=").append(region_name);
        sb.append(", parent_id=").append(parent_id);
        sb.append(", region_level=").append(region_level);
        sb.append(", sort=").append(sort);
        sb.append(", short_name=").append(short_name);
        sb.append(", end_flag=").append(end_flag);
        sb.append(", update_time=").append(update_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    protected Serializable pkVal() {
        return region_id;
    }
}