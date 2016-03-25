package org.demo.garage.sale.beans;

import static javax.persistence.PersistenceContextType.EXTENDED;

import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.demo.garage.sale.domain.House;
import org.demo.garage.sale.domain.SaleItem;
import org.demo.garage.sale.services.GarageSaleService;
import org.hamcrest.Factory;

import com.sun.tools.javac.util.Log;

@Stateful
@Name("garageSaleManager")
//@Scope(ScopeType.CONVERSATION)
public class GarageSaleServiceBean implements GarageSaleService {
    
    @Logger
    Log log;
    
    // choose extended so it can go acrosss multiple things
    @PersistenceContext(type=EXTENDED)
    private EntityManager em;
    
    // list of sale items
    @Out(required = false)
    private List<SaleItem> saleItemList;
    
    // list of houses
    @DataModel
    private List<House> garageSaleList;
    
    @DataModelSelection
    @Out(required=false)
    private House house;
    
    @Factory("garageSaleList")
    @SuppressWarnings("unchecked")
    public void findHomes() {
        log.info("find houses");
        garageSaleList = em.createQuery("From House hs order by hs.address, hs.city").getResultList();        
    }
    
    @SuppressWarnings("unchecked")
    public String findSaleItems() {
        log.info("find Sale Item");        
        Query query = em.createQuery("From SaleItem si where si.houseId = :houseId order by si.item");
        query.setParameter("houseId", house.getHouseId());
        saleItemList = query.getResultList();
        
        return "/details.jsp";
    }
    
    public String deleteHouse() {
        log.info("remove garage sale - #{house}");
        em.remove(house);
        
        // re get the list of houses
        findHomes();
        return "/garageSaleList.jsp";
    }
    
    @Remove
    @Destroy
    public void destroy() {
        
    }

}
