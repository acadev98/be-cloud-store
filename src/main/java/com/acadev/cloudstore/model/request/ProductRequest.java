package com.acadev.cloudstore.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {
	private String title;
	private String description;
	private String type;
	private Double price;
	private String currency;
}
