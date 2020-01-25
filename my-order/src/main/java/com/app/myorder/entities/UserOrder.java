package com.app.myorder.entities;

import com.app.myorder.enums.OrderStatusEnum;

import javax.persistence.*;

@Entity
@Table(name = "USER_ORDER")
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TOTAL_VALUE", nullable = false)
    private Double totalValue;

    @Column(name = "STATUS", nullable = false)
    private OrderStatusEnum orderStatus;

    @ManyToOne
    @JoinColumn(name="USER", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="RESTAURANT", nullable = false)
    private Restaurant restaurant;

    public Integer getId() {
        return id;
    }

    public UserOrder setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public UserOrder setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public UserOrder setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserOrder setUser(User user) {
        this.user = user;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public UserOrder setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }
}
