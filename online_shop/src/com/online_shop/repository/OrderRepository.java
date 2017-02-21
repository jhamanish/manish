package com.online_shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_shop.model.Customer;
import com.online_shop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	public List<Order> findByCustomer(Customer customer);
}
