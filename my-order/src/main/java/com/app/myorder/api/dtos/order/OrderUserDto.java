package com.app.myorder.api.dtos.order;

public class OrderUserDto {

    private Integer id;

    private String name;

    private String email;

    private String phone;

    private String address;

    public Integer getId() {
        return id;
    }

    public OrderUserDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderUserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public OrderUserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public OrderUserDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderUserDto setAddress(String address) {
        this.address = address;
        return this;
    }
}
