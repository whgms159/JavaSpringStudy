package com.kosta.dto;

import lombok.Data;

@Data
public class ProductDTO {
	private int id, consumerId;
	private String name;
	private int price;
	private String content;
}
