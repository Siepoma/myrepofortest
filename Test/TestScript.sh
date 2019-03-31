#!/bin/bash
echo 'START TEST 1'; 
curl -X POST --header 'Content-Type: application/json' --header 'Cache-Control: no-cache'  -d @Test1.json 'http://localhost:12345/shopping-cart/postCart';    
echo '';
echo 'CART POSTED'; 
echo 'ASKING FOR RECEIPTS'; 
curl -X GET --header 'Accept: application/json' 'http://localhost:12345/shopping-cart/getReceipts?cartID=cartTest1';    


echo 'START TEST 2';
curl -X POST --header 'Content-Type: application/json' --header 'Cache-Control: no-cache'  -d @Test2.json 'http://localhost:12345/shopping-cart/postCart';    
echo '';
echo 'CART POSTED'; 
echo 'ASKING FOR RECEIPTS'; 
curl -X GET --header 'Accept: application/json' 'http://localhost:12345/shopping-cart/getReceipts?cartID=cartTest2';    

echo 'START TEST 3';
curl -X POST --header 'Content-Type: application/json' --header 'Cache-Control: no-cache'  -d @Test3.json 'http://localhost:12345/shopping-cart/postCart';    
echo '';
echo 'CART POSTED'; 
echo 'ASKING FOR RECEIPTS'; 
curl -X GET --header 'Accept: application/json' 'http://localhost:12345/shopping-cart/getReceipts?cartID=cartTest3';    
