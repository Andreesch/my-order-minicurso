package com.app.myorder.repositories;

import com.app.myorder.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSearchRepository extends CrudRepository<Product, Integer> {

//    @Query("SELECT p FROM Product p"
//            + " JOIN FETCH o.restaurant r"
//            + " WHERE r.id = :restaurantId")
    List<Product> findByRestaurantId(Integer restaurantId);
}
