package com.squareshift.eCommerce.Controller;

import com.squareshift.eCommerce.dto.ProductDto;
import com.squareshift.eCommerce.dto.WarehouseResponseDto;
import com.squareshift.eCommerce.Service.ProductService;
import com.squareshift.eCommerce.Service.WareHouseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
    WareHouseService wareHouseService;

	HashMap<Integer, Integer> mapproduct = new HashMap<Integer, Integer>();

	@RequestMapping(value = "/v1/product/{id}")
	public ProductDto getProductById(@PathVariable Long id) throws Exception {
		return productService.getProductById(id);
	}

	@RequestMapping(value = "/cart/item/", method = RequestMethod.POST)
	public HashMap<String, String> addItemsToCart(@RequestBody ProductDto productDto) {
		HashMap<String, String> map = new HashMap<>();
		try {
			map.put("status", "success");
			map.put("message", "Item has been added to cart");

			mapproduct.put(productDto.getId(), productDto.getQuantity());
			return map;
		} catch (Exception e) {
			HashMap<String, String> ERRmap = new HashMap<>();

			ERRmap.put("status", "error");
			ERRmap.put("message", "Invalid product id");
			return ERRmap;
		}
	}

	@RequestMapping(value = "/cart/items/")
	public List<Object> getAllItems() {
		HashMap<String, String> map = new HashMap<>();
		List<Object> object = new ArrayList<Object>();
		List<Object> object1 = new ArrayList<Object>();

		try {
			map.put("status", "success");
			map.put("message", "Items available in cart");
			if (mapproduct.size() > 0)
				object.add(map);
			object.add(mapproduct);
			return object;
		} catch (Exception e) {
			HashMap<String, String> ERRmap = new HashMap<>();

			ERRmap.put("action", "emptyCart");
			object1.add(ERRmap);
			return object1;
		}

	}

	@RequestMapping(value = "/cart/items/", method = RequestMethod.POST)
	public HashMap<String, String> deleteAllItems() {
		HashMap<String, String> map = new HashMap<>();

		try {
			map.put("status", "success");
			map.put("message", "All items have been removed from the cart");
			if (mapproduct.size() > 0)
				mapproduct = null;
		} catch (Exception e) {
			System.out.println(e);
		}
		return map;

	}

	@RequestMapping(value = "/cart/checkout-value/{id}")
	public HashMap<String, String> getCheckoutValue(@PathVariable Long id) {
		HashMap<String, String> map = new HashMap<>();
		double totalvalue = 0;
		double totalWeight = 0;
		double shippingValue = 0;
		try {
			WarehouseResponseDto wareHouseDto = wareHouseService.getWareHouseDistanceByPostalCode(id);
			long distance=wareHouseDto.getDistance_in_kilometers();

			Iterator<Integer> it = mapproduct.keySet().iterator();
			while (it.hasNext()) {
				int productId = (int) it.next();
				int quantity = mapproduct.get(productId);
				ProductDto pojoobject = productService.getProductById(id);
				double value = quantity * pojoobject.getPrice();
				double discountValue = value * (pojoobject.getDiscount_percentage() / 100);
				value = value - discountValue;
				totalvalue = totalvalue + value;
				totalWeight = totalWeight + pojoobject.getWeight_in_grams();
			}

			double kilograms = totalWeight / 1000;

			if (kilograms < 2) {

				if (distance < 5)
					shippingValue = 12;
				else if (distance >= 5 && distance < 20)
					shippingValue = 15;
				else if (distance >= 20 && distance < 50)
					shippingValue = 20;
				else if (distance >= 50 && distance < 500)
					shippingValue = 50;
				else if (distance >= 500 && distance < 800)
					shippingValue = 100;
				else if (distance >= 800)
					shippingValue = 220;

			}

			if (kilograms >= 2.01 && kilograms < 5) {

				if (distance < 5)
					shippingValue = 14;
				else if (distance >= 5 && distance < 20)
					shippingValue = 18;
				else if (distance >= 20 && distance < 50)
					shippingValue = 24;
				else if (distance >= 50 && distance < 500)
					shippingValue = 55;
				else if (distance >= 500 && distance < 800)
					shippingValue = 110;
				else if (distance >= 800)
					shippingValue = 250;

			}

			if (kilograms >= 5.01 && kilograms < 20) {

				if (distance < 5)
					shippingValue = 16;
				else if (distance >= 5 && distance < 20)
					shippingValue = 25;
				else if (distance >= 20 && distance < 50)
					shippingValue = 30;
				else if (distance >= 50 && distance < 500)
					shippingValue = 80;
				else if (distance >= 500 && distance < 800)
					shippingValue = 130;
				else if (distance >= 800)
					shippingValue = 270;

			}

			if (kilograms > 20.01) {

				if (distance < 5)
					shippingValue = 21;
				else if (distance >= 5 && distance < 20)
					shippingValue = 35;
				else if (distance >= 20 && distance < 50)
					shippingValue = 50;
				else if (distance >= 50 && distance < 500)
					shippingValue = 90;
				else if (distance >= 500 && distance < 800)
					shippingValue = 150;
				else if (distance >= 800)
					shippingValue = 300;

			}

			map.put("status", "success");
			map.put("message", "Total value of your shopping cart is " + totalvalue);
			map.put("shippingCart", "Total value of your shipping cart is " + shippingValue);

		} catch (Exception e) {
			System.out.println(e);
		}
		return map;

	}

}