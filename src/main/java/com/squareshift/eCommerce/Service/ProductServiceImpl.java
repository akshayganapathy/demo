package com.squareshift.eCommerce.Service;

import com.squareshift.eCommerce.dto.ProductDto;
import com.squareshift.eCommerce.dto.ProductResponseDto;
import com.squareshift.eCommerce.Proxy.Proxy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    Proxy proxy;

    public ProductDto getProductById(Long id) throws Exception{
        ProductResponseDto productById = proxy.getProductById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productById.getProductDto(), productDto);
        return productDto;
    }
    
	public ProductDto addItemsTocart(ProductDto productDto) {
		try {
		proxy.addItemsToCart(productDto);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return productDto;
	
	}

	@Override
	public ProductDto getItemsInCart() throws Exception {
		ProductResponseDto productById = proxy.getCartItems();
		return null;
	}
    
    
}