package com.squareshift.eCommerce.Service;

import com.squareshift.eCommerce.dto.WarehouseResponseDto;

public interface WareHouseService {

    WarehouseResponseDto getWareHouseDistanceByPostalCode(Long postalCode) throws Exception;
}