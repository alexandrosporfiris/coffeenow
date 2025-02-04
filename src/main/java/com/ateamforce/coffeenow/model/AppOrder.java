/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateamforce.coffeenow.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author alexa
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppOrder.findAll", query = "SELECT o FROM AppOrder o")
    , @NamedQuery(name = "AppOrder.findById", query = "SELECT o FROM AppOrder o WHERE o.id = :id")
    , @NamedQuery(name = "AppOrder.findByStore", query = "SELECT o FROM AppOrder o WHERE o.store.id = :storeid")
    , @NamedQuery(name = "AppOrder.findByClient", query = "SELECT o FROM AppOrder o WHERE o.client.id = :clientid")
    , @NamedQuery(name = "AppOrder.findByMode", query = "SELECT o FROM AppOrder o WHERE o.mode = :mode")
    , @NamedQuery(name = "AppOrder.findByTotal", query = "SELECT o FROM AppOrder o WHERE o.total = :total")
    , @NamedQuery(name = "AppOrder.findByDate", query = "SELECT o FROM AppOrder o WHERE o.date = :date")})
public class AppOrder implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "mode")
    private String mode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private float total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Transient
    private List<OrderProduct> ordersProductsList;
    @JoinColumn(name = "clientid", referencedColumnName = "id")
    @ManyToOne
    private Client client;
    @JoinColumn(name = "storeid", referencedColumnName = "id")
    @ManyToOne
    private Store store;

    public AppOrder() {
    }

    public AppOrder(Integer id) {
        this.id = id;
    }

    public AppOrder(Integer id, String mode, float total, Date date) {
        this.id = id;
        this.mode = mode;
        this.total = total;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @XmlTransient
    @JsonIgnore
    public List<OrderProduct> getOrdersProductsList() {
        return ordersProductsList;
    }

    public void setOrdersProductsList(List<OrderProduct> ordersProductsList) {
        this.ordersProductsList = ordersProductsList;
    }

    public Client getClientid() {
        return client;
    }

    public void setClientid(Client clientid) {
        this.client = clientid;
    }

    public Store getStoreid() {
        return store;
    }

    public void setStoreid(Store store) {
        this.store = store;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
}
