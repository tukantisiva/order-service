package com.zulkhe.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "store_order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long oId;
	private String orderId;
	private Date orderDate;
	private Date shipDate;
	private String shipMode;
	private int quantity;
	private BigDecimal discount;
	private BigDecimal profit;
	private String productId;
	private String customerName;
	private String category;
	private String customerId;
	private String productName;

}
