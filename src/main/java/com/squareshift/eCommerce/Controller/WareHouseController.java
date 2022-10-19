package com.squareshift.eCommerce.Controller;

import com.squareshift.eCommerce.dto.WarehouseResponseDto;
import com.squareshift.eCommerce.Service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WareHouseController {

    @Autowired
    WareHouseService wareHouseService;

    @RequestMapping(value = "/v1/warehouse/{postalCode}")
    public WarehouseResponseDto getWarehouseDistance(@PathVariable Long postalCode) throws Exception{
      return wareHouseService.getWareHouseDistanceByPostalCode(postalCode);

    }
    
    
    

}