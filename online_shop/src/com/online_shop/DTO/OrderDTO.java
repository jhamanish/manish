package com.online_shop.DTO;

public class OrderDTO {

	private long customerId;

	private long orderNo;

	private String orderType;

	private String productInfo;

	private double totalAmount;

	private String orderStatus;
	
	public OrderDTO(){
		
	}

	public OrderDTO(long customerId, long orderNo, String orderType, String productInfo, double totalAmount,
			String orderStatus) {
		this.customerId = customerId;
		this.orderNo = orderNo;
		this.orderStatus = orderStatus;
		this.orderType = orderType;
		this.productInfo = productInfo;
		this.totalAmount = totalAmount;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "OrderDTO [customerId=" + customerId + ", orderNo=" + orderNo + ", orderType=" + orderType
				+ ", productInfo=" + productInfo + ", totalAmount=" + totalAmount + ", orderStatus=" + orderStatus
				+ "]";
	}

}
