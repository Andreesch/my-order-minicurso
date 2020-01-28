package com.app.myorder.api.dtos;

import com.app.myorder.api.validations.PasswordValidator;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@PasswordValidator
public class CreateUserDto {

    @NotEmpty
    @ApiModelProperty(value = "${user.create.name}")
    private String name;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.email}")
    private String email;

    @NotEmpty
    @ApiModelProperty(value = "${user.create.federalIdentification}")
    private String federalIdentification;

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

    public CreateUserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateUserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFederalIdentification() {
        return federalIdentification;
    }

    public CreateUserDto setFederalIdentification(String federalIdentification) {
        this.federalIdentification = federalIdentification;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CreateUserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public CreateUserDto setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CreateUserDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CreateUserDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
