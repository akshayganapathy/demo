package com.squareshift.eCommerce.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Integer id;
    private String name;
    private String description;
    private String category;
    private String image;
    private Integer quantity;
    private Long discount_percentage;
    private Long weight_in_grams;
    private Double price;
    
	public Integer getId() {
		return id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Long getDiscount_percentage() {
		return discount_percentage;
	}
	public void setDiscount_percentage(Long discount_percentage) {
		this.discount_percentage = discount_percentage;
	}
	public Long getWeight_in_grams() {
		return weight_in_grams;
	}
	public void setWeight_in_grams(Long weight_in_grams) {
		this.weight_in_grams = weight_in_grams;
	}
}