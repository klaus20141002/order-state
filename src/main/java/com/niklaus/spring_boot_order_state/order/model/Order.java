/******************************************************************************
 * @File name   :      Order.java
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
 * 2017年11月13日 上午10:52:33        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.niklaus.spring_boot_order_state.order.model;

import java.io.Serializable;
import java.util.Date;

import com.niklaus.spring_boot_order_state.order.constant.StateConstants;
import com.niklaus.spring_boot_order_state.order.exception.OrderStateChangeException;
import com.niklaus.spring_boot_order_state.order.state.OrderState;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private OrderState orderState;
	private Date updateTime;
	public Order(OrderState orderState) {
		this.orderState = orderState;
	}
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) throws OrderStateChangeException {
		String originOrderState = this.orderState.toString();
		// 对Order的原始状态的几种情况进行分析
		switch (originOrderState) {
		case StateConstants.CLOSED: // CLOSED只能转换成PENDING_SHIP
			if (!StateConstants.PENDING_SHIP.equals(orderState.toString())) {
				 throw new OrderStateChangeException(this.orderState.toString(), orderState.toString());
			};
			break;

		case StateConstants.PENDING_PAYMENT: // PENDING_PAYMENT只能转换成PENDING_SHIP或者CLOSED
			if (!StateConstants.PENDING_SHIP.equals(orderState.toString())
					&& !StateConstants.CLOSED.equals(orderState.toString())) {

				 throw new OrderStateChangeException(this.orderState.toString(), orderState.toString());
			}
			;
			break;

		case StateConstants.PENDING_SHIP: // PENDING_SHIP只能转换成PENDING_RECEIPT或者REFUND_UNAUDITED
			if (!StateConstants.PENDING_RECEIPT.equals(orderState.toString())
					&& !StateConstants.REFUND_UNAUDITED.equals(orderState.toString())
					&& !StateConstants.REFUND.equals(orderState.toString())) {

				 throw new OrderStateChangeException(this.orderState.toString(), orderState.toString());
			}
			;
			break;

		case StateConstants.PENDING_RECEIPT: // PENDING_RECEIPT只能转换成RECEIPTED或者REFUND
			if (!StateConstants.RECEIPTED.equals(orderState.toString())
					&& !StateConstants.REFUND.equals(orderState.toString())) {

				 throw new OrderStateChangeException(this.orderState.toString(), orderState.toString());
			}
			;
			break;

		case StateConstants.REFUND: // REFUND只能转换成REFUND_FAILURE或者REFUND_SUCCESS
			if (!StateConstants.REFUND_FAILURE.equals(orderState.toString())
					&& !StateConstants.REFUND_SUCCESS.equals(orderState.toString())) {

				 throw new OrderStateChangeException(this.orderState.toString(), orderState.toString());
			}
			;
			break;

		case StateConstants.REFUND_FAILURE:
			if (!StateConstants.REFUND.equals(orderState.toString())) {

				 throw new OrderStateChangeException(this.orderState.toString(), orderState.toString());
			}
			;
			break;

		case StateConstants.RECEIPTED: // 确认收货后，消费者联系客服要求退款
			if (!StateConstants.REFUND.equals(orderState.toString())) {

				 throw new OrderStateChangeException(this.orderState.toString(), orderState.toString());
			}
			;
			break;

		case StateConstants.REFUND_UNAUDITED: // REFUND_FAILURE只能转换成待发货，或者退款已审核
			if (!StateConstants.REFUND.equals(orderState.toString())
					&& !StateConstants.PENDING_SHIP.equals(orderState.toString())) {

				 throw new OrderStateChangeException(this.orderState.toString(), orderState.toString());
			}
			;
			break;

		default:
			 throw new OrderStateChangeException(this.orderState.toString(), orderState.toString());

		}
		this.orderState = orderState;
		// 状态改变触发一些事件
		orderState.process(this, originOrderState);
	}

}
