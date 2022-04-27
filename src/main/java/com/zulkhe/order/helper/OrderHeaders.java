package com.zulkhe.order.helper;

public final class OrderHeaders {
	public static final String ID = "Row ID";
	public static final String ORDER_ID = "Order ID";
	public static final String ORDER_DATE = "Order Date";
	public static final String SHIP_DATE = "Ship Date";
	public static final String SHIP_MODE = "Ship Mode";
	public static final String CUSTOMER_ID = "Customer ID";
	public static final String CUSTOMER_NAME = "Customer Name";
	public static final String SEGMENT = "Segment";
	public static final String COUNTRY = "Country";
	public static final String CITY = "City";
	public static final String STATE = "State";
	public static final String PRODUCT_ID = "Product ID";
	public static final String SUB_CATEGORY = "Sub-Category";
	public static final String CATEGORY = "Category";
	public static final String PRODUCT_NAME = "Product Name";
	public static final String SALES = "Sales";
	public static final String QUANTITY = "Quantity";
	public static final String DISCOUNT = "Discount";
	public static final String PROFIT = "Profit";
	public static final String FAIL_TO_PARSE_CSV_FILE = "fail to parse CSV file: ";

	private OrderHeaders() {
		throw new IllegalStateException("Utility class");
	}
}
