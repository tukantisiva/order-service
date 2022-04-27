package com.zulkhe.order.helper;

import com.zulkhe.order.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class OrderCSVHelper {


	public List<Order> csvToProduct(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
			 CSVParser csvParser = new CSVParser(fileReader,
				 CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			List<Order> orders = new ArrayList<>();
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for (CSVRecord csvRecord : csvRecords) {
				Order order = new Order();
				order.setOId(Long.parseLong(csvRecord.get(OrderHeaders.ID)));
				order.setCategory(csvRecord.get(OrderHeaders.CATEGORY));
				order.setCustomerId(csvRecord.get(OrderHeaders.CUSTOMER_ID));
				order.setCustomerName(csvRecord.get(OrderHeaders.CUSTOMER_NAME));
				order.setProductName(csvRecord.get(OrderHeaders.PRODUCT_NAME));
				order.setShipMode(csvRecord.get(OrderHeaders.SHIP_MODE));
				order.setOrderId(csvRecord.get(OrderHeaders.ORDER_ID));
				order.setOrderDate(convertStringToDate(csvRecord.get(OrderHeaders.ORDER_DATE)));
				order.setShipDate(convertStringToDate(csvRecord.get(OrderHeaders.SHIP_DATE)));
				order.setProductId(csvRecord.get(OrderHeaders.PRODUCT_ID));
				order.setProfit(new BigDecimal(csvRecord.get(OrderHeaders.PROFIT)));
				order.setDiscount(new BigDecimal(csvRecord.get(OrderHeaders.DISCOUNT)));
				order.setQuantity((int) Long.parseLong(csvRecord.get(OrderHeaders.QUANTITY)));
				log.info(":{}", order);
				orders.add(order);
			}
			return orders;
		} catch (IOException | ParseException e) {
			throw new RuntimeException(OrderHeaders.FAIL_TO_PARSE_CSV_FILE + e.getMessage());
		}
	}

	static Date convertStringToDate(String date) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		return simpleDateFormat.parse(date);
	}
}
