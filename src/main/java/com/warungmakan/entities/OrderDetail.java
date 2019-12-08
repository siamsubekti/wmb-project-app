package com.warungmakan.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Table;


@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "sub_total", nullable = true)
    private Integer subTotal;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = true)
    private Order orderDetail;

    public OrderDetail(Integer id,Menu menu, Integer quantity,Integer subTotal, Order orderDetail) {
        this.id = id;
        this.menu = menu;
        this.quantity = quantity;
        this.subTotal = subTotal;
        this.orderDetail = orderDetail;
    }

    public OrderDetail() {
    }

    public OrderDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public OrderDetail setId(Integer id) {
        this.id = id;
        return this;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSubTotal() {
        return subTotal;
    }

    public OrderDetail setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
        return this;
    }

    public Order getOrderDetail() {
        return orderDetail;
    }

    public OrderDetail setOrderDetail(Order orderDetail) {
        this.orderDetail = orderDetail;
        return this;
    }


}
