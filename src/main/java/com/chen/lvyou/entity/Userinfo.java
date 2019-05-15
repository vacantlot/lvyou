package com.chen.lvyou.entity;
import org.json.JSONException;
import org.json.JSONObject;

public class Userinfo {
    private String userId;

    private String password;

    private String name;

    private String telephone;

    private String sex;

    private String userPhoto;

    private String birthday;

    private String address;

    private String role;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto == null ? null : userPhoto.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    @Override public String toString() {
        return "Userinfo{" + "userId='" + userId + '\'' + ", password='" + password + '\'' + ", name='" + name + '\''
               + ", telephone='" + telephone + '\'' + ", sex='" + sex + '\'' + ", userPhoto='" + userPhoto + '\''
               + ", birthday='" + birthday + '\'' + ", address='" + address + '\'' + ", role='" + role + '\'' + '}';
    }
}