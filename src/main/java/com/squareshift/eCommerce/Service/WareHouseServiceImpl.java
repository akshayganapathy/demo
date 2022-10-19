package com.squareshift.eCommerce.Service;

import com.squareshift.eCommerce.dto.WarehouseResponseDto;
import com.squareshift.eCommerce.Proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WareHouseServiceImpl implements WareHouseService{
    @Autowired
    private Proxy proxy;

    public WarehouseResponseDto getWareHouseDistanceByPostalCode(Long postalCode) throws Exception {
        return proxy.getWareHouseDistanceByPostalCode(postalCode);
    }
}