package com.app.myorder.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.app.myorder.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT o FROM Order o"
            + " JOIN FETCH o.user u"
            + " JOIN FETCH o.restaurant r"
            + " JOIN FETCH o.items i"
            + " WHERE o.id = :userId")
    List<Order> listByUserId(@Param("userId") Integer userId);
}
