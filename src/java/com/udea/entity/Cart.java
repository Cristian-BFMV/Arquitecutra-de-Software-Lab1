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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camiloa.mejia
 */
@Entity
@Table(name = "cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c")
    , @NamedQuery(name = "Cart.findByLicense", query = "SELECT c FROM Cart c WHERE c.license = :license")
    , @NamedQuery(name = "Cart.findByBrand", query = "SELECT c FROM Cart c WHERE c.brand = :brand")
    , @NamedQuery(name = "Cart.findByModel", query = "SELECT c FROM Cart c WHERE c.model = :model")
    , @NamedQuery(name = "Cart.findByPrice", query = "SELECT c FROM Cart c WHERE c.price = :price")
    , @NamedQuery(name = "Cart.findByKm", query = "SELECT c FROM Cart c WHERE c.km = :km")
    , @NamedQuery(name = "Cart.findByState", query = "SELECT c FROM Cart c WHERE c.state = :state")})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "license")
    private String license;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "brand")
    private String brand;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "km")
    private int km;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "state")
    private String state;

    public Cart() {
    }

    public Cart(String license) {
        this.license = license;
    }

    public Cart(String license, String brand, String model, int price, int km, String state) {
        this.license = license;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.km = km;
        this.state = state;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (license != null ? license.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.license == null && other.license != null) || (this.license != null && !this.license.equals(other.license))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.Cart[ license=" + license + " ]";
    }
    
}
