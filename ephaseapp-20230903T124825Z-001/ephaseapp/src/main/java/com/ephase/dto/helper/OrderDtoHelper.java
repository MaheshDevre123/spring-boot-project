package com.ephase.dto.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ephase.dto.OrderDto;
import com.ephase.model.Order;

@Component
public class OrderDtoHelper implements DtoHelper<Order, OrderDto> {

	@Override
	public List<OrderDto> buildDtos(Iterable<Order> models) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDto buildDto(Order order) {
		OrderDto orderDto = new OrderDto();
		orderDto.setId(order.getId());
		orderDto.setOrderName(order.getOrderName());
		orderDto.setDateActivated(order.getDateActivated());
		orderDto.setAutoExpireDate(order.getAutoExpireDate());
		orderDto.setDateStopped(order.getDateStopped());
		orderDto.setOrderReason(order.getOrderReason());
		orderDto.setAccessionNumber(order.getAccessionNumber());
		orderDto.setOrderNumber(order.getOrderNumber());
		orderDto.setCommentToFulfiller(order.getCommentToFulfiller());
		orderDto.setScheduledDate(order.getScheduledDate());
		orderDto.setSortWeight(order.getSortWeight());
		orderDto.setPreviousOrder(order.getPreviousOrder());
		return orderDto;
	}

	@Override
	public Order build(OrderDto orderDto) {
		Order order = new Order();
		order.setId(orderDto.getId());
		order.setOrderName(orderDto.getOrderName());
		order.setDateActivated(orderDto.getDateActivated());
		order.setAutoExpireDate(orderDto.getAutoExpireDate());
		order.setDateStopped(orderDto.getDateStopped());
		order.setOrderReason(orderDto.getOrderReason());
		order.setAccessionNumber(orderDto.getAccessionNumber());
		order.setOrderName(orderDto.getOrderName());
		order.setCommentToFulfiller(orderDto.getCommentToFulfiller());
		order.setScheduledDate(orderDto.getScheduledDate());
		order.setSortWeight(orderDto.getSortWeight());
		order.setPreviousOrder(orderDto.getPreviousOrder());
		return order;
	}

	@Override
	public List<Order> buildModels(Iterable<OrderDto> dtos) {
		// TODO Auto-generated method stub
		return null;
	}

}
