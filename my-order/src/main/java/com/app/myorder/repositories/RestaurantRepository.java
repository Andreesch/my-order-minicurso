package com.app.myorder.repositories;

import com.app.myorder.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends  JpaRepository<Restaurant, Integer> {

}
