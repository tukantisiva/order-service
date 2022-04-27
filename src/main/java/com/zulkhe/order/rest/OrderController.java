package com.zulkhe.order.rest;

import com.zulkhe.order.entity.Order;
import com.zulkhe.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@Validated
@RestController
@RequestMapping("/Order")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/all")
	public List<Order> getAllProducts() {
		return orderService.getAllProduct();
	}

	@PostMapping("/order-synchronizer")
	public ResponseEntity<List<Order>> synchronize(@RequestParam(value = "source", defaultValue = "CSV") String source) {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.synchronizeCSV(source));
	}
}
