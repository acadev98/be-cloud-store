package com.acadev.cloudstore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acadev.cloudstore.database.entity.Products;
import com.acadev.cloudstore.database.repository.ProductsRepository;
import com.acadev.cloudstore.handler.exception.ApiException;
import com.acadev.cloudstore.service.ProductService;
import com.acadev.cloudstore.utils.enums.ApiMessage;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductsRepository repository;

	public Integer getNextId() {
		Optional<Products> entityMaxId = repository.findTopByOrderByIdDesc();
		if (entityMaxId.isPresent())
			return (entityMaxId.get().getId() + 1);
		return 1;
	}

	public String echo() {
		return "product echo message service";
	}

	public List<Products> getAllProducts() {

		List<Products> goals = repository.findAll();
		if (goals.isEmpty())
			throw new ApiException(ApiMessage.CONTENT_NOT_FOUND);

		return goals;
	}

	public Products getProductById(Integer id) {
		Optional<Products> product = repository.findById(id);
		if (product.isEmpty()) {
			throw new ApiException(ApiMessage.CONTENT_NOT_FOUND);
		} else {
			return product.get();
		}
	}

	public Products createProduct(Products product) {
		return repository.save(product);
	}

	public Products updateProductById(Integer id, Products product) {
		Products productUpdate = getProductById(id);

			productUpdate.setTitle(product.getTitle());
			productUpdate.setDescription(product.getDescription());
			productUpdate.setType(product.getType());
			productUpdate.setCurrency(product.getCurrency());
			productUpdate.setPrice(product.getPrice());

		return repository.save(productUpdate);
	}

	public Products deleteProductById(Integer id) {
		Products product = getProductById(id);
			repository.delete(product);
		
		return product;
	}

}
