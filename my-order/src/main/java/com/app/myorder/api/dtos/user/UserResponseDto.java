package com.app.myorder.api.dtos.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("CreateUserResponse")
public class UserResponseDto {

    @ApiModelProperty(value = "${user.create.name}")
    private String name;

    @ApiModelProperty(value = "${user.create.email}")
    private String email;

    @ApiModelProperty(value = "${user.create.federalIdentification}")
    private String federalIdentification;

    @ApiModelProperty(value = "${user.create.address}")
    private String address;

    @ApiModelProperty(value = "${user.create.phone}")
    private String phone;

    public String getName() {
        return name;
    }

    public UserResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResponseDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFederalIdentification() {
        return federalIdentification;
    }

    public UserResponseDto setFederalIdentification(String federalIdentification) {
        this.federalIdentification = federalIdentification;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserResponseDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserResponseDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
