package com.online_shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_shop.DTO.OrderDTO;
import com.online_shop.model.Customer;
import com.online_shop.model.Order;
import com.online_shop.repository.CustomerRepository;
import com.online_shop.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderRepository orderRepository;

	public Order makeOrder(OrderDTO orderDTO,Customer customer) {
		Order takeOrder = new Order();
		takeOrder.setCustomer(customer);
		takeOrder.setOrderNo(orderDTO.getOrderNo());
		takeOrder.setOrderStatus(orderDTO.getOrderStatus());
		takeOrder.setOrderType(orderDTO.getOrderType());
		takeOrder.setProductInfo(orderDTO.getProductInfo());
		takeOrder.setTotalAmount(orderDTO.getTotalAmount());
		return orderRepository.save(takeOrder);
	}

	public List<Order> getAllOrders() {
		List<Order> allOrders = orderRepository.findAll();
		return allOrders;
	}
	
	public List<Order> getOneOrder(Customer customer){
		List<Order> order = orderRepository.findByCustomer(customer);
		return order;
	}
}
