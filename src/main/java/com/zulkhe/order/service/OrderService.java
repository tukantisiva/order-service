package com.zulkhe.order.service;

import com.zulkhe.order.entity.Order;

import java.util.List;

public interface OrderService {

	List<Order> getAllProduct();

	List<Order> synchronizeCSV(String source);
}
