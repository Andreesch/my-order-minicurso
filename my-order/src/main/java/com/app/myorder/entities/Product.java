package com.app.myorder.entities;

import javax.persistence.*;

@Entity
@Table(name = "PRODUTO")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "VALUE")
    private Double value;

    @Column(name = "RESTAURANT")
    private Restaurant restaurant;

    public Integer getId() {
        return id;
    }

    public Product setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Product setValue(Double value) {
        this.value = value;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Product setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }
}
