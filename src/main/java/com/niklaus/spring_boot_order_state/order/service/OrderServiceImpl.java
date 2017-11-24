/******************************************************************************
 * @File name   :      OrderServiceImpl.java
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
 * 2017年11月13日 下午2:23:20        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.niklaus.spring_boot_order_state.order.service;

import org.springframework.stereotype.Service;

import com.niklaus.spring_boot_order_state.order.exception.OrderStateChangeException;
import com.niklaus.spring_boot_order_state.order.model.Order;
import com.niklaus.spring_boot_order_state.order.state.OrderState;

/**
 *
 */

@Service("orderService")
public class OrderServiceImpl implements IOrderService{
	
	public void changeOrderStatus(Order order, OrderState orderState) throws OrderStateChangeException {
        // 改变订单状态，并触发相应事件
        order.setOrderState( orderState );
	}

}
