package com.example.dome.entity.response;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/1/9.
 */
public class SUser implements Serializable {

    private String username;
    private String password;
    private String passswords;
    private String address;
    private String phone;
    private String email;
    private String QQ;
    private String school;
    private Long age;
    private String grade;
    private String province;
    private String city;
    private String regoin;
    private Long question_one;
    private String answer_one;
    private Long question_two;
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
