package com.example.dome.entity.model;


import com.baomidou.mybatisplus.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
 * Created by lenovo on 2018/1/9.
 */
@ApiModel
public class MUser extends Model<MUser> implements Serializable {
    @ApiModelProperty(name = "user_id", value = "id ", required = true)
    private Long user_id;
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
    @ApiModelProperty(name = "create_time", value = "创建时间 ", required = true)
    private Long create_time;
    @ApiModelProperty(name = "update_time", value = "更新时间 ", required = true)
    private Long update_time;


    private static final long serialVersionUID = 1L;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

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

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MUser)) return false;

        MUser user = (MUser) o;

        if (getUser_id() != null ? !getUser_id().equals(user.getUser_id()) : user.getUser_id() != null) return false;
        if (getUsername() != null ? !getUsername().equals(user.getUsername()) : user.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        if (getPassswords() != null ? !getPassswords().equals(user.getPassswords()) : user.getPassswords() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(user.getAddress()) : user.getAddress() != null) return false;
        if (getPhone() != null ? !getPhone().equals(user.getPhone()) : user.getPhone() != null) return false;
        if (getEmail() != null ? !getEmail().equals(user.getEmail()) : user.getEmail() != null) return false;
        if (getQQ() != null ? !getQQ().equals(user.getQQ()) : user.getQQ() != null) return false;
        if (getSchool() != null ? !getSchool().equals(user.getSchool()) : user.getSchool() != null) return false;
        if (getAge() != null ? !getAge().equals(user.getAge()) : user.getAge() != null) return false;
        if (getGrade() != null ? !getGrade().equals(user.getGrade()) : user.getGrade() != null) return false;
        if (getProvince() != null ? !getProvince().equals(user.getProvince()) : user.getProvince() != null)
            return false;
        if (getCity() != null ? !getCity().equals(user.getCity()) : user.getCity() != null) return false;
        if (getRegoin() != null ? !getRegoin().equals(user.getRegoin()) : user.getRegoin() != null) return false;
        if (getQuestion_one() != null ? !getQuestion_one().equals(user.getQuestion_one()) : user.getQuestion_one() != null)
            return false;
        if (getAnswer_one() != null ? !getAnswer_one().equals(user.getAnswer_one()) : user.getAnswer_one() != null)
            return false;
        if (getQuestion_two() != null ? !getQuestion_two().equals(user.getQuestion_two()) : user.getQuestion_two() != null)
            return false;
        if (getAnswer_two() != null ? !getAnswer_two().equals(user.getAnswer_two()) : user.getAnswer_two() != null)
            return false;
        if (getCreate_time() != null ? !getCreate_time().equals(user.getCreate_time()) : user.getCreate_time() != null)
            return false;
        return getUpdate_time() != null ? getUpdate_time().equals(user.getUpdate_time()) : user.getUpdate_time() == null;
    }

    @Override
    public int hashCode() {
        int result = getUser_id() != null ? getUser_id().hashCode() : 0;
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getPassswords() != null ? getPassswords().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getQQ() != null ? getQQ().hashCode() : 0);
        result = 31 * result + (getSchool() != null ? getSchool().hashCode() : 0);
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        result = 31 * result + (getGrade() != null ? getGrade().hashCode() : 0);
        result = 31 * result + (getProvince() != null ? getProvince().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getRegoin() != null ? getRegoin().hashCode() : 0);
        result = 31 * result + (getQuestion_one() != null ? getQuestion_one().hashCode() : 0);
        result = 31 * result + (getAnswer_one() != null ? getAnswer_one().hashCode() : 0);
        result = 31 * result + (getQuestion_two() != null ? getQuestion_two().hashCode() : 0);
        result = 31 * result + (getAnswer_two() != null ? getAnswer_two().hashCode() : 0);
        result = 31 * result + (getCreate_time() != null ? getCreate_time().hashCode() : 0);
        result = 31 * result + (getUpdate_time() != null ? getUpdate_time().hashCode() : 0);
        return result;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }



    @Override
    public String toString() {
        return "MUser{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", passswords='" + passswords + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", QQ='" + QQ + '\'' +
                ", school='" + school + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", regoin='" + regoin + '\'' +
                ", question_one=" + question_one +
                ", answer_one='" + answer_one + '\'' +
                ", question_two=" + question_two +
                ", answer_two='" + answer_two + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }






    @Override
    protected Serializable pkVal() {
        return user_id;
    }
}