package com.app.myorder.repositories;

import com.app.myorder.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT o FROM Order o"
            + " JOIN FETCH o.user u"
            + " JOIN FETCH o.restaurant r"
            + " JOIN FETCH o.items i"
            + " WHERE o.id = :userId")
    List<Order> listByUserId(@Param("userId") Integer userId);
}
