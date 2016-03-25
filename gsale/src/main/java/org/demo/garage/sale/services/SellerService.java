package org.demo.garage.sale.services;

public interface SellerService {

    String createGarageSale();
    String addSaleItem();
    void deleteSaleItem();
    
    String finish();
}
