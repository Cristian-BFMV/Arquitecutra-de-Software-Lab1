/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.entity.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author camiloa.mejia
 */
@Stateless
public class VehicleFacade extends AbstractFacade<Vehicle> implements VehicleFacadeLocal {

    @PersistenceContext(unitName = "vehiclesCRUDTestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehicleFacade() {
        super(Vehicle.class);
    }

    @Override
    public List availablesVehicles(String available) {
 
        Query q = em.createQuery("select v from Vehicle v where v.state=:available");
        
        q.setParameter("available", available);
        
        return q.getResultList();
    }
    
    
    
}
