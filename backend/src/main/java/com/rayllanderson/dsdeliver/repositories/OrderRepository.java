package com.rayllanderson.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rayllanderson.dsdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
