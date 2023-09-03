package com.ephase.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ephase.model.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
