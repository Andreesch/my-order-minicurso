package com.app.myorder.entities;

import com.app.myorder.enums.OrderStatusEnum;

import javax.persistence.*;

@Entity
@Table(name = "ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TOTAL_VALUE", nullable = false)
    private Double totalValue;

    @Column(name = "STATUS", nullable = false)
    private OrderStatusEnum orderStatus;

    @Column(name = "USER", nullable = false)
    private User user;

    @Column(name = "RESTAURANT", nullable = false)
    private Restaurant restaurant;

    public Integer getId() {
        return id;
    }

    public Order setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public Order setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public Order setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Order setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }
}
