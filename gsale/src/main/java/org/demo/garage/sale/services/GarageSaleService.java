package org.demo.garage.sale.services;

/**
 * The manager for our lists of grage and sale items.
 * 
 * @author Joseph F Nusairat
 *
 */
public interface GarageSaleService {

    void findHomes();
    String findSaleItems();
    String deleteHouse();
    void destroy();
    
    //House getHouse();
}
