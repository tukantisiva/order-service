# product-service
1. POST : /Order/order-synchronizer?source=CSV
   -  Created Rest Api to read the CSV file from the resource folder and parse and save the orders in to H2 DB table -STORE_ORDER  .
   -  Used in-memory database H2 DB 
   -  Spring
   -  java 
   -  CSV parser : user Apache Common CSV 
2. GET   : /Order/all
  - Fetch all orders 
