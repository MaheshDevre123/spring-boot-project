package com.ephase.dto;

import java.sql.Date;

public class OrderDto {

	private Long id;

	private String orderName;

	private Date dateActivated;

	private Date autoExpireDate;

	private Date dateStopped;

	private String orderReason;

	private String accessionNumber;

	private String orderNumber;

	private String commentToFulfiller;

	private Date scheduledDate;

	private Double sortWeight;

	private Long previousOrder;

	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDto(Long id, String orderName, Date dateActivated, Date autoExpireDate, Date dateStopped,
			String orderReason, String accessionNumber, String orderNumber, String commentToFulfiller,
			Date scheduledDate, Double sortWeight, Long previousOrder) {
		super();
		this.id = id;
		this.orderName = orderName;
		this.dateActivated = dateActivated;
		this.autoExpireDate = autoExpireDate;
		this.dateStopped = dateStopped;
		this.orderReason = orderReason;
		this.accessionNumber = accessionNumber;
		this.orderNumber = orderNumber;
		this.commentToFulfiller = commentToFulfiller;
		this.scheduledDate = scheduledDate;
		this.sortWeight = sortWeight;
		this.previousOrder = previousOrder;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Date getDateActivated() {
		return dateActivated;
	}

	public void setDateActivated(Date dateActivated) {
		this.dateActivated = dateActivated;
	}

	public Date getAutoExpireDate() {
		return autoExpireDate;
	}

	public void setAutoExpireDate(Date autoExpireDate) {
		this.autoExpireDate = autoExpireDate;
	}

	public Date getDateStopped() {
		return dateStopped;
	}

	public void setDateStopped(Date dateStopped) {
		this.dateStopped = dateStopped;
	}

	public String getOrderReason() {
		return orderReason;
	}

	public void setOrderReason(String orderReason) {
		this.orderReason = orderReason;
	}

	public String getAccessionNumber() {
		return accessionNumber;
	}

	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCommentToFulfiller() {
		return commentToFulfiller;
	}

	public void setCommentToFulfiller(String commentToFulfiller) {
		this.commentToFulfiller = commentToFulfiller;
	}

	public Date getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public Double getSortWeight() {
		return sortWeight;
	}

	public void setSortWeight(Double sortWeight) {
		this.sortWeight = sortWeight;
	}

	public Long getPreviousOrder() {
		return previousOrder;
	}

	public void setPreviousOrder(Long previousOrder) {
		this.previousOrder = previousOrder;
	}

}
