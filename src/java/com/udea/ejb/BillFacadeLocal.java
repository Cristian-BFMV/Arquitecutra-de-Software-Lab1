/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.entity.Bill;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author User
 */
@Local
public interface BillFacadeLocal {

    void create(Bill bill);

    void edit(Bill bill);

    void remove(Bill bill);

    Bill find(Object id);

    List<Bill> findAll();

    List<Bill> findRange(int[] range);

    int count();
    
}
