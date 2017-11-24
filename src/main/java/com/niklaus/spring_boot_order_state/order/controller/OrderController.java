/******************************************************************************
 * @File name   :      OrderController.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年11月13日
 *
 * @Copyright Notice: 
 * Copyright (c) 2017 TimorJun, Inc. All  Rights Reserved.
 * This software is published under the terms of TimorJun
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 * 
 * ----------------------------------------------------------------------------
 * Date                   Who         Version        Comments
 * 2017年11月13日 下午2:50:38        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.niklaus.spring_boot_order_state.order.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niklaus.spring_boot_order_state.order.exception.OrderStateChangeException;
import com.niklaus.spring_boot_order_state.order.model.Order;
import com.niklaus.spring_boot_order_state.order.service.IOrderService;
import com.niklaus.spring_boot_order_state.order.state.OrderState;

/**
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private IOrderService orderService ;
	
	/**
	 * @param params
	 * order
	 * orderState
	 * 
	 * 
	 * @Date        :      2017年11月13日
	 * @return
	 * @throws OrderStateChangeException 
	 */
	@GetMapping("/ship")
	public String ship(@RequestParam Map<String, Object> params) throws OrderStateChangeException {
//		Order order = (Order)params.get("order");
//		OrderState orderState = (OrderState)params.get("orderState");
		OrderState orderState = OrderState.PENDING_PAYMENT;
		Order order = new Order(orderState);
		orderService.changeOrderStatus(order, OrderState.PENDING_SHIP);
		return "Success";
	}
	
	/**
	 * @param params
	 * order
	 * orderState
	 * 
	 * 
	 * @Date        :      2017年11月13日
	 * @return
	 */
	@GetMapping("/pay")
	public String pay(@RequestParam Map<String, Object> params) throws OrderStateChangeException {
		Order order = (Order)params.get("order");
		OrderState orderState = (OrderState)params.get("orderState");
		orderService.changeOrderStatus(order, orderState);
		return "Success";
	}
	
	
	/**
	 * @param params
	 * order
	 * orderState
	 * 
	 * 
	 * @Date        :      2017年11月13日
	 * @return
	 */
	@GetMapping("/receive")
	public String receive(@RequestParam Map<String, Object> params) throws OrderStateChangeException {
		Order order = (Order)params.get("order");
		OrderState orderState = (OrderState)params.get("orderState");
		orderService.changeOrderStatus(order, orderState);
		return "Success";
	}
	
	
	

}
