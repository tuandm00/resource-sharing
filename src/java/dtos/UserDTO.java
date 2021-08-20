/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class UserDTO {

    private String userID;
    private String password;
    private String name;
    private String roleID;
    private String phone;
    private String address;
    private Date createDate;
    private String status;
    private String captcha;
    private String email;

    public UserDTO() {
    }

    public UserDTO(String name, String roleID) {
        this.name = name;
        this.roleID = roleID;
    }

    public UserDTO(String userID, String name, String roleID) {
        this.userID = userID;
        this.name = name;
        this.roleID = roleID;
    }

    public UserDTO(String userID, String password, String name, String roleID, String phone, String address, Date createDate) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.roleID = roleID;
        this.phone = phone;
        this.address = address;
        this.createDate = createDate;

    }

    public UserDTO(String userID, String password, String name, String roleID, String phone, String address, Date createDate, String status, String captcha, String email) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.roleID = roleID;
        this.phone = phone;
        this.address = address;
        this.createDate = createDate;
        this.status = status;
        this.captcha = captcha;
        this.email = email;

    }

    public UserDTO(String userID, String name, String roleID, String status, String captcha, String email) {
        this.userID = userID;

        this.name = name;
        this.roleID = roleID;

        this.status = status;
        this.captcha = captcha;
        this.email = email;

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", password=" + password + ", name=" + name + ", roleID=" + roleID + ", phone=" + phone + ", address=" + address + ", createDate=" + createDate + ", status=" + status + ", captcha=" + captcha + ", email=" + email + '}';
    }

}
