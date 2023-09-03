package com.ephase.service;

import java.util.List;

import com.ephase.dto.OrderDto;

public interface OrderService {
	
	public OrderDto create(OrderDto orderDto);
	
	public void delete(long orderid);
	
	public OrderDto findOne(long orderid);
	
	public List<OrderDto> findAll();
	
	public String updateStatus(Long orderId);

	public OrderDto updateOrder(Long id, OrderDto orderDto);
	
	
	
}
