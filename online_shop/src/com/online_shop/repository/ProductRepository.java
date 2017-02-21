package com.online_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online_shop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	public Product findByBarcode(String barcode);
	
	public Product findByProductId(Long id);
}
