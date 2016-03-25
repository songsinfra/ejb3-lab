package org.demo.garage.sale.services;

import java.util.List;

import org.demo.garage.sale.domain.House;

public interface BuyerService {
    public List<House> searchGarageSales();
}
