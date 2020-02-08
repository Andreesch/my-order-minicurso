package com.app.myorder.api.dtos.user;

import com.app.myorder.api.validations.PasswordValidator;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@PasswordValidator
public class UserCreateDto {

    @NotEmpty
    @ApiModelProperty(value = "${user.create.name}")
    private String name;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.email}")
    private String email;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.password}")
    private String password;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.matchingPassword}")
    private String matchingPassword;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.address}")
    private String address;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.phone}")
    private String phone;

    public String getName() {
        return name;
    }

    public UserCreateDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserCreateDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserCreateDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public UserCreateDto setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserCreateDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserCreateDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
