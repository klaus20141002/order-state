package com.niklaus.spring_boot_order_state.order.constant;

public class StateConstants {

	public static final String PENDING_APPLY = "PENDING_APPLY"; // 待付款，用户提交订单但未支付
	public static final String PENDING_PAYMENT = "PENDING_PAYMENT"; // 待付款，用户提交订单但未支付
	public static final String PENDING_SHIP = "PENDING_SHIP"; // 待发货，用户已付款但运营人员未发货
	public static final String PENDING_RECEIPT = "PENDING_RECEIPT"; // 待收货，已发货但用户还未收货
	public static final String RECEIPTED = "RECEIPTED"; // 已收货，用户已经确认收货，或已发货超过7天
	public static final String CLOSED = "CLOSED"; // 已关闭，用户侍付款订单，20分钟内必须完成支付；或者运营人员手动关闭
	public static final String REFUND = "REFUND"; // 退款已审核。
	public static final String REFUND_UNAUDITED = "REFUND_UNAUDITED"; // 申请退款未审核。
	public static final String PENDING_GROUP = "PENDING_GROUP"; // 待成团，拼团订单用户已付款但团还没满员
	public static final String REFUND_FAILURE = "REFUND_FAILURE"; // 退款失败
	public static final String REFUND_SUCCESS = "REFUND_SUCCESS"; // 退款成功

	/** 团订单状态 未发货 */
	public static final String GROUP_ORDER_SHIP = "SHIP";
	/** 团订单状态 部分发货 */
	public static final String GROUP_ORDER_HALF = "HALF";
	/** 团订单状态 已发货 */
	public static final String GROUP_ORDER_RECEIPT = "RECEIPT";

}
