/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.entity.Vehicle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camiloa.mejia
 */
@Local
public interface VehicleFacadeLocal {

    void create(Vehicle vehicle);

    void edit(Vehicle vehicle);

    void remove(Vehicle vehicle);

    Vehicle find(Object id);

    List<Vehicle> findAll();

    List<Vehicle> findRange(int[] range);

    int count();

    List availablesVehicles(String available);
    
}
