package com.example.dome.entity.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by huangxiaoliang on 2017/7/12.
 */
@ApiModel
public class SCount implements Serializable {

    @ApiModelProperty(name = "count", value = "数量", required = true)
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SCount count1 = (SCount) o;

        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return count;
    }

    @Override
    public String toString() {
        return "SCount{" +
                "count=" + count +
                '}';
    }
}
