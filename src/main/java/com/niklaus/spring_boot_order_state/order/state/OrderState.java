/******************************************************************************
 * @File name   :      OrderState.java
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
 * 2017年11月13日 上午10:55:01        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.niklaus.spring_boot_order_state.order.state;

import com.niklaus.spring_boot_order_state.order.model.Order;

/**
 *
 */
public enum OrderState implements State {
	PENDING_PAYMENT {
		@Override
		public void process(Order order, String originOrderState) {
			System.out.println(order.getOrderState() + "" + originOrderState);
		}

	},
	PENDING_SHIP {
		@Override
		public void process(Order order, String originOrderState) {
			System.out.println(order.getOrderState() + "" + originOrderState);
			
		}

	},
	PENDING_RECEIPT {
		@Override
		public void process(Order order, String originOrderState) {
			System.out.println(order.getOrderState() + "" + originOrderState);
			
		}

	},
	RECEIPTED {
		@Override
		public void process(Order order, String originOrderState) {
			System.out.println(order.getOrderState() + "" + originOrderState);
			
		}

	},
	CLOSED {
		@Override
		public void process(Order order, String originOrderState) {
			System.out.println(order.getOrderState() + "" + originOrderState);
		}

	},
	REFUND_FAILURE {
		@Override
		public void process(Order order, String originOrderState) {
			System.out.println(order.getOrderState() + "" + originOrderState);
		}

	},
	REFUND_SUCCESS {
		@Override
		public void process(Order order, String originOrderState) {
			System.out.println(order.getOrderState() + "" + originOrderState);
		}

	},
	REFUND_UNAUDITED {
		@Override
		public void process(Order order, String originOrderState) {
			System.out.println(order.getOrderState() + "" + originOrderState);
		}

	},
	REFUND {
		@Override
		public void process(Order order, String originOrderState) {
			System.out.println(order.getOrderState() + "" + originOrderState);
		}

	}

}
