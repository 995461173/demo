package com.example.dome.entity.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


@ApiModel
public class SFeedback implements Serializable {

    @ApiModelProperty(name = "content", value = "反馈的内容 ", required = true)
    private String content;
    @ApiModelProperty(name = "phone", value = "电话 ", required = true)
    private String phone;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SFeedback sXzlFeedback = (SFeedback) o;
        if (phone != sXzlFeedback.phone) return false;
        return content != null ? content.equals(sXzlFeedback.content) : sXzlFeedback.content == null;
    }

    @Override
    public int hashCode() {

        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SFeedback{" +
                "content='" + content + '\'' +
                "phone='" + phone + '\'' +
                '}';
    }
}
