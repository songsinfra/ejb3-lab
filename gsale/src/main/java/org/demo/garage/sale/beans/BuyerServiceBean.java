package org.demo.garage.sale.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.demo.garage.sale.domain.House;
import org.demo.garage.sale.services.BuyerService;

@Stateless
@Named("buyerService")
public class BuyerServiceBean implements BuyerService {

    @PersistenceContext
    EntityManager em;
    
    @Inject
    String city;
    
    @Inject
    String address;
    
    @Inject
    String state;
    
    public List<House> searchGarageSales() {
        em.find(House.class, "From House h where h");
        return null;
    }
}
