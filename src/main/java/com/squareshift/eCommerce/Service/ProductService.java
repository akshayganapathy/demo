package com.squareshift.eCommerce.Service;

import com.squareshift.eCommerce.dto.ProductDto;

public interface ProductService {

    ProductDto getProductById(Long id) throws Exception;
    
    ProductDto getItemsInCart() throws Exception;

    ProductDto addItemsTocart(ProductDto productDto);
}