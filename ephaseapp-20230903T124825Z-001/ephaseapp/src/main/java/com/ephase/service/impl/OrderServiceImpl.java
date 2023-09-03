package com.ephase.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.ephase.dto.OrderDto;
import com.ephase.dto.helper.OrderDtoHelper;
import com.ephase.model.Order;
import com.ephase.repo.OrderRepo;
import com.ephase.service.OrderService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDtoHelper orderDtoHelper;

	@Autowired
	private OrderRepo orderRepo;

	@Override
	public OrderDto create(OrderDto orderDto) {
		Order orders = orderDtoHelper.build(orderDto);
		
		Order save = orderRepo.save(orders);
		OrderDto buildDto = orderDtoHelper.buildDto(save);
		return buildDto;

	}

	@Override
	public void delete(long orderid) {
		Order order = orderRepo.findById(orderid).get();
		orderRepo.delete(order);

	}

	@Override
	public OrderDto findOne(long orderid) {
		OrderDto orderDto = orderDtoHelper.buildDto(orderRepo.findById(orderid).get());
		return orderDto;
	}

	@Override
	public List<OrderDto> findAll() {
		List<Order> orderList = orderRepo.findAll();
		if (!(orderList == null)) {
			List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
			for (Order order : orderList) {
				OrderDto orderdto = orderDtoHelper.buildDto(order);
				orderDtoList.add(orderdto);
			}

			return orderDtoList;

		} else
			return null;
	}

	

	@Override
	public OrderDto updateOrder(Long id, OrderDto orderDto) {

		Optional<Order> optionalOrder = orderRepo.findById(id);

		if (optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
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

			Order updated = orderRepo.save(order);

			OrderDto orderDto2 = new OrderDto();
			orderDto2.setId(updated.getId());
			orderDto2.setOrderName(updated.getOrderName());
			orderDto2.setDateActivated(updated.getDateActivated());
			orderDto2.setAutoExpireDate(updated.getAutoExpireDate());
			orderDto2.setDateStopped(updated.getDateStopped());
			orderDto2.setOrderReason(updated.getOrderReason());
			orderDto2.setAccessionNumber(updated.getAccessionNumber());
			orderDto2.setOrderNumber(updated.getOrderNumber());
			orderDto2.setCommentToFulfiller(updated.getCommentToFulfiller());
			orderDto2.setScheduledDate(updated.getScheduledDate());
			orderDto2.setSortWeight(updated.getSortWeight());
			orderDto2.setPreviousOrder(updated.getPreviousOrder());

		}
		return orderDto;

	}

	@Override
	public String updateStatus(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}
}
