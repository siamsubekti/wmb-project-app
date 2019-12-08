package com.warungmakan.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "cashier")
public class Cashier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cashier_name")
    private  String name;

    @Column(name = "password")
    private Integer password;

    @JsonIgnore
    @OneToMany(mappedBy = "cashier", cascade = CascadeType.ALL)
    private List<Order> listOrderCashier;

    public Cashier(){}

    public Cashier(Integer id, String name, Integer password, List<Order> listOrderCashier) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.listOrderCashier = listOrderCashier;
    }
    public Cashier(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Cashier setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Cashier setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPassword() {
        return password;
    }

    public Cashier setPassword(Integer password) {
        this.password = password;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cashier cashier = (Cashier) o;
        return Objects.equals(id, cashier.id) &&
                Objects.equals(name, cashier.name) &&
                Objects.equals(password, cashier.password) &&
                Objects.equals(listOrderCashier, cashier.listOrderCashier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, listOrderCashier);
    }
}
