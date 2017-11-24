/******************************************************************************
 * @File name   :      OrderStateChangeException.java
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
 * 2017年11月13日 下午7:36:13        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.niklaus.spring_boot_order_state.order.exception;

/**
 *
 */
public class OrderStateChangeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderStateChangeException() {
		super();
	}

	public OrderStateChangeException(String message) {
		super(message);
	}

	public OrderStateChangeException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderStateChangeException(String beforeStatus, String afterStatus) {
		super("订单状态：" + beforeStatus + " 不能转换成 " + afterStatus);
	}

}
