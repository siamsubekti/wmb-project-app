package com.warungmakan.entities;



import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_customer")
    private String customerName;

    @ManyToOne()
    @JoinColumn(name = "table_id", nullable = false)
    private Tables tables;

    @Column(name = "quantity_customer")
    private Integer quantityCustomer;

    @Column(name = "total_price", nullable = true)
    private Integer priceTotal;

    @Column(name = "payment")
    private Integer payment;

    @Column(name = "refund")
    private Integer refund;

    @Column(name = "transaction_status")
    private String statusTransaction;

    @ManyToOne()
    @JoinColumn(name = "cashier_id", nullable = false)
    private Cashier cashier;

    @OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetails;

    public Order(){}

    public Integer getId() {
        return id;
    }

    public Order setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Order setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public Tables getTables() {
        return tables;
    }

    public Order setTables(Tables tables) {
        this.tables = tables;
        return this;
    }

    public Integer getQuantityCustomer() {
        return quantityCustomer;
    }

    public Order setQuantityCustomer(Integer quantityCustomer) {
        this.quantityCustomer = quantityCustomer;
        return this;
    }

    public Integer getPriceTotal() {
        return priceTotal;
    }

    public Order setPriceTotal(Integer priceTotal) {
        this.priceTotal = priceTotal;
        return this;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getRefund() {
        return refund;
    }

    public void setRefund(Integer refund) {
        this.refund = refund;
    }

    public String getStatusTransaction() {
        return statusTransaction;
    }

    public Order setStatusTransaction(String statusTransaction) {
        this.statusTransaction = statusTransaction;
        return this;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public Order setCashier(Cashier cashier) {
        this.cashier = cashier;
        return this;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public Order setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
        return this;
    }
}
