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
@Table(name = "vehicle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v")
    , @NamedQuery(name = "Vehicle.findByLicense", query = "SELECT v FROM Vehicle v WHERE v.license = :license")
    , @NamedQuery(name = "Vehicle.findByBrand", query = "SELECT v FROM Vehicle v WHERE v.brand = :brand")
    , @NamedQuery(name = "Vehicle.findByModel", query = "SELECT v FROM Vehicle v WHERE v.model = :model")
    , @NamedQuery(name = "Vehicle.findByPrice", query = "SELECT v FROM Vehicle v WHERE v.price = :price")
    , @NamedQuery(name = "Vehicle.findByKm", query = "SELECT v FROM Vehicle v WHERE v.km = :km")
    , @NamedQuery(name = "Vehicle.findByState", query = "SELECT v FROM Vehicle v WHERE v.state = :state")
    , @NamedQuery(name = "Vehicle.findByImage", query = "SELECT v FROM Vehicle v WHERE v.image = :image")})
public class Vehicle implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "image")
    private String image;

    public Vehicle() {
    }

    public Vehicle(String license) {
        this.license = license;
    }

    public Vehicle(String license, String brand, String model, int price, int km, String state, String image) {
        this.license = license;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.km = km;
        this.state = state;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.license == null && other.license != null) || (this.license != null && !this.license.equals(other.license))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.Vehicle[ license=" + license + " ]";
    }
    
}
