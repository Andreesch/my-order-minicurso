package com.app.myorder.api.dtos.user;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserUpdateDto {

    @NotNull
    @ApiModelProperty(value = "${user.update.id}")
    private Integer id;

    @NotEmpty
    @ApiModelProperty(value = "${user.update.name}")
    private String name;

    @NotEmpty
    @ApiModelProperty(value = "${user.update.email}")
    private String email;

    @NotEmpty
    @ApiModelProperty(value = "${user.update.password}")
    private String password;

    @NotEmpty
    @ApiModelProperty(value = "${user.update.matchingPassword}")
    private String matchingPassword;

    @NotEmpty
    @ApiModelProperty(value = "${user.update.address}")
    private String address;

    @NotEmpty
    @ApiModelProperty(value = "${user.update.phone}")
    private String phone;

    public Integer getId() {
        return id;
    }

    public UserUpdateDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserUpdateDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserUpdateDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserUpdateDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public UserUpdateDto setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserUpdateDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserUpdateDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
