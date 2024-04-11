package com.acadev.cloudstore.service;

import java.util.List;

import com.acadev.cloudstore.database.entity.Products;

public interface ProductService {

	String echo();

	List<Products> getAllProducts();

	Products getProductById(Integer id);

	Products deleteProductById(Integer id);

	Products createProduct(Products product);

	Products updateProductById(Integer id, Products product);

}
