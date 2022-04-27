package com.zulkhe.order.service.impl;

import com.zulkhe.order.entity.Order;
import com.zulkhe.order.helper.OrderCSVHelper;
import com.zulkhe.order.repository.OrderRepository;
import com.zulkhe.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	private final OrderCSVHelper orderCSVHelper;

	public OrderServiceImpl(OrderRepository orderRepository, OrderCSVHelper orderCSVHelper) {
		this.orderRepository = orderRepository;
		this.orderCSVHelper = orderCSVHelper;
	}

	@Override
	public List<Order> getAllProduct() {
		return orderRepository.findAll();
	}

	@Override
	public List<Order> synchronizeCSV(String source) {
		ClassLoader classLoader = this.getClass().getClassLoader();
		List<Order> orders = null;

		if (source.equalsIgnoreCase("CSV")) {
			final String SOURCE_FILE = "sales.csv";
			InputStream is = classLoader.getResourceAsStream(SOURCE_FILE);
			try {
				orders = orderCSVHelper.csvToProduct(is);
				orderRepository.saveAll(orders);

			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		return orders;
	}


}
