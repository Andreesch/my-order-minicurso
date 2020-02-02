package com.app.myorder.exceptions;

public class RestaurantNotFoundException extends RuntimeException {

    public RestaurantNotFoundException(Integer id) {
        super("Restaurante não encontrado para o id: " + id);
    }
}
