package com.techupdate.os.api.repository;

import com.techupdate.os.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    /*@Override
   default Optional<Order> findById(Integer integer){
        JpaRepository<Order, Integer>
    }*/

    public default Optional<Order> getOrder(int orderId){
        /*System.out.println("############");
        return Optional.of(new Order(111, "Bat", 15, 100));*/
        return  findById(orderId);
    }


}
