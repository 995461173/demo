package com.example.demo.entity.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/1/9.
 */
@ApiModel
public class SUser implements Serializable {

    @ApiModelProperty(name = "username", value = "用户名 ", required = true)
    private String username;
    @ApiModelProperty(name = "password", value = "密码 ", required = true)
    private String password;
    @ApiModelProperty(name = "passswords", value = "确认密码 ", required = true)
    private String passswords;
    @ApiModelProperty(name = "address", value = "地址 ", required = true)
    private String address;
    @ApiModelProperty(name = "phone", value = "电话 ", required = true)
    private String phone;
    @ApiModelProperty(name = "email", value = "邮箱 ", required = true)
    private String email;
    @ApiModelProperty(name = "QQ", value = "QQ ", required = true)
    private String QQ;
    @ApiModelProperty(name = "school", value = "学校 ", required = true)
    private String school;
    @ApiModelProperty(name = "age", value = "年龄 ", required = true)
    private Long age;
    @ApiModelProperty(name = "grade", value = "班级 ", required = true)
    private String grade;
    @ApiModelProperty(name = "province", value = "省 ", required = true)
    private String province;
    @ApiModelProperty(name = "city", value = "市 ", required = true)
    private String city;
    @ApiModelProperty(name = "regoin", value = "区 ", required = true)
    private String regoin;
    @ApiModelProperty(name = "question_one", value = "问题一 ", required = true)
    private Long question_one;
    @ApiModelProperty(name = "answer_one", value = "答案一 ", required = true)
    private String answer_one;
    @ApiModelProperty(name = "question_two", value = "问题二 ", required = true)
    private Long question_two;
    @ApiModelProperty(name = "answer_two", value = "答案二 ", required = true)
    private String answer_two;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassswords() {
        return passswords;
    }

    public void setPassswords(String passswords) {
        this.passswords = passswords;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegoin() {
        return regoin;
    }

    public void setRegoin(String regoin) {
        this.regoin = regoin;
    }

    public Long getQuestion_one() {
        return question_one;
    }

    public void setQuestion_one(Long question_one) {
        this.question_one = question_one;
    }

    public String getAnswer_one() {
        return answer_one;
    }

    public void setAnswer_one(String answer_one) {
        this.answer_one = answer_one;
    }

    public Long getQuestion_two() {
        return question_two;
    }

    public void setQuestion_two(Long question_two) {
        this.question_two = question_two;
    }

    public String getAnswer_two() {
        return answer_two;
    }

    public void setAnswer_two(String answer_two) {
        this.answer_two = answer_two;
    }



}
