package com.ephase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ephase.constants.Constant;
import com.ephase.constants.RequestMappingConstants;
import com.ephase.dto.OrderDto;
import com.ephase.service.impl.OrderServiceImpl;

import jakarta.validation.Valid;

@Controller
public class OrderController {
	@Autowired
	OrderServiceImpl orderServiceImpl;

	@RequestMapping(value = RequestMappingConstants.CREATE_ORDER, method = RequestMethod.POST, consumes = Constant.JSON_FORMAT)
	public @ResponseBody ResponseEntity<OrderDto> createOrders(@RequestBody @Valid OrderDto orderDto) {

		OrderDto orderDtos = orderServiceImpl.create(orderDto);
		return new ResponseEntity<OrderDto>(orderDto, HttpStatus.OK);

	}
	
	@RequestMapping(value = RequestMappingConstants.DELETE_ORDER, method = RequestMethod.DELETE, produces = Constant.JSON_FORMAT)
	public @ResponseBody ResponseEntity<HttpStatus> delete(@PathVariable(value = "orderid") Long orderid) {
		orderServiceImpl.delete(orderid);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

	}
	
	@RequestMapping(value = RequestMappingConstants.GET_ORDER_BY_ID, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<OrderDto> getOrderDetailsbyId(@RequestParam("orderid") Long orderid) {
		return new ResponseEntity<OrderDto>(orderServiceImpl.findOne(orderid), HttpStatus.OK);

	}
	
	
	@RequestMapping(value = RequestMappingConstants.GET_ORDER_DETAILS, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<OrderDto>> getOrderInfo() {

		return new ResponseEntity<List<OrderDto>>(orderServiceImpl.findAll(), HttpStatus.OK);

	}
	
	@RequestMapping(value = RequestMappingConstants.UPDATE_ORDER_BY_ID, method = RequestMethod.PUT)
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        OrderDto updatedOrder = orderServiceImpl.updateOrder(id, orderDto);
        return ResponseEntity.ok(updatedOrder);
    }
}
