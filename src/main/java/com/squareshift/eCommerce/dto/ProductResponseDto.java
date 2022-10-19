package com.squareshift.eCommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductResponseDto {
    private String status;
    @JsonProperty(value = "product")
    private ProductDto productDto;
	public ProductDto getProductDto() {
		return productDto;
	}
}