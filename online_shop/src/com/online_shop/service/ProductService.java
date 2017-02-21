package com.online_shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_shop.model.Product;
import com.online_shop.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products;

	}

	public Product fetchProduct(String barcode) {
		Product product = productRepository.findByBarcode(barcode);
		return product;
	}

	public Product getProductById(long id) {
		Product product = productRepository.findByProductId(id);
		return product;
	}

	public List<String> generateOrder(List<Product> selections) {
		List<String> orderDetails = new ArrayList<String>();
		double total = 0;
		String sumTotal = "";
		String productPrice = "";
		String quantity = "";
		for (Product object : selections) {
			total += object.getProductPrice();
			productPrice = String.valueOf(object.getProductPrice());
			quantity = String.valueOf(object.getQuantity());
			orderDetails.add("{ "+object.getProductName() + " | " + productPrice + " | " + quantity +" }");
		}
		sumTotal = String.valueOf(total);
		orderDetails.add(sumTotal);

		return orderDetails;
	}

}
