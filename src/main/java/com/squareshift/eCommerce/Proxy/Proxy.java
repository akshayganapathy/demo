package com.squareshift.eCommerce.Proxy;

import com.squareshift.eCommerce.dto.ProductDto;
import com.squareshift.eCommerce.dto.ProductResponseDto;
import com.squareshift.eCommerce.dto.WarehouseResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "client", url = "https://e-commerce-api-recruitment.herokuapp.com")
public interface Proxy {

    @RequestMapping(value = "/product/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponseDto getProductById(@PathVariable Long id) throws Exception;
    
    @RequestMapping(value = "/cart/items", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponseDto getCartItems() throws Exception;
    
    @RequestMapping(value = "/cart/item", consumes = MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
    public ProductResponseDto addItemsToCart(@RequestBody ProductDto productDto) throws Exception;

    @RequestMapping(value = "/warehouse/distance", consumes = MediaType.APPLICATION_JSON_VALUE)
    public WarehouseResponseDto getWareHouseDistanceByPostalCode(@RequestParam Long postal_code) throws Exception;

	
    
    

	
}