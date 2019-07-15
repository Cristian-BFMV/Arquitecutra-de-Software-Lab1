/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "bill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b")
    , @NamedQuery(name = "Bill.findByBillNumber", query = "SELECT b FROM Bill b WHERE b.billNumber = :billNumber")
    , @NamedQuery(name = "Bill.findByCustomerDocumentNumber", query = "SELECT b FROM Bill b WHERE b.customerDocumentNumber = :customerDocumentNumber")
    , @NamedQuery(name = "Bill.findByVehiclesLicenses", query = "SELECT b FROM Bill b WHERE b.vehiclesLicenses = :vehiclesLicenses")
    , @NamedQuery(name = "Bill.findByTotal", query = "SELECT b FROM Bill b WHERE b.total = :total")})
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bill_number")
    private Integer billNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "customer_document_number")
    private String customerDocumentNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "vehicles_licenses")
    private String vehiclesLicenses;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;

    public Bill() {
    }

    public Bill(Integer billNumber) {
        this.billNumber = billNumber;
    }

    public Bill(Integer billNumber, String customerDocumentNumber, String vehiclesLicenses, int total) {
        this.billNumber = billNumber;
        this.customerDocumentNumber = customerDocumentNumber;
        this.vehiclesLicenses = vehiclesLicenses;
        this.total = total;
    }

    public Integer getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(Integer billNumber) {
        this.billNumber = billNumber;
    }

    public String getCustomerDocumentNumber() {
        return customerDocumentNumber;
    }

    public void setCustomerDocumentNumber(String customerDocumentNumber) {
        this.customerDocumentNumber = customerDocumentNumber;
    }

    public String getVehiclesLicenses() {
        return vehiclesLicenses;
    }

    public void setVehiclesLicenses(String vehiclesLicenses) {
        this.vehiclesLicenses = vehiclesLicenses;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billNumber != null ? billNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.billNumber == null && other.billNumber != null) || (this.billNumber != null && !this.billNumber.equals(other.billNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.Bill[ billNumber=" + billNumber + " ]";
    }
    
}
