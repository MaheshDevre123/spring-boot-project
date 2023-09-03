package com.ephase.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "order_info")
	@SequenceGenerator(name = "order_info", sequenceName = "order_id_seq", allocationSize = 1)
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "order_name")
	private String orderName;

	@Column(name = "date_activated")
	private Date dateActivated;

	@Column(name = "autoexpire_date")
	private Date autoExpireDate;

	@Column(name = "date_stopped")
	private Date dateStopped;

	@Column(name = "order_reason")
	private String orderReason;

	@Column(name = "accession_number")
	private String accessionNumber;

	@Column(name = "order_number")
	private String orderNumber;

	@Column(name = "comment_to_fulfiller")
	private String commentToFulfiller;

	@Column(name = "scheduled_date")
	private Date scheduledDate;

	@Column(name = "sort_weight")
	private Double sortWeight;

	@Column(name = "previous_order")
	private Long previousOrder;

	public Order() {
		super();
		
	}

	public Order(Long id, String orderName, Date dateActivated, Date autoExpireDate, Date dateStopped,
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
