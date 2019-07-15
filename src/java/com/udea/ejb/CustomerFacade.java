/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.entity.Customer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author camiloa.mejia
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {

    @PersistenceContext(unitName = "vehiclesCRUDTestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    @Override
    public boolean checkLogin(String id, String p) {
       Query q = em.createQuery("select c from Customer c" +
               " where c.documentNumber=:id and c.password=:p");
       
       q.setParameter("id", id);
       q.setParameter("p", p);
       
       return q.getResultList().size()>0;
       
    }
    
    
    
    
    
}
