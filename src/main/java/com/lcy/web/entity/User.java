package com.lcy.web.entity;

import java.util.Objects;

public class User {

    private String uuid;
    private String username;
    private String password;
    private int age;
    private String sex;
    private String address;
    private String phone;
    private String email;
    private String education;
    private String school;
    private String profession;

    public User() {

    }

    public User(String uuid, String username, String password, int age, String sex, String address, String phone, String email, String education, String school, String profession) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.education = education;
        this.school = school;
        this.profession = profession;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(uuid, user.uuid) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(address, user.address) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(email, user.email) &&
                Objects.equals(education, user.education) &&
                Objects.equals(school, user.school) &&
                Objects.equals(profession, user.profession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, username, password, age, sex, address, phone, email, education, school, profession);
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", education='" + education + '\'' +
                ", school='" + school + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
