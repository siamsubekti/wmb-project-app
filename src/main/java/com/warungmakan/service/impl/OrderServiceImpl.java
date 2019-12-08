package com.warungmakan.service.impl;

import com.warungmakan.entities.*;
import com.warungmakan.repositories.*;
import com.warungmakan.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    TableService tableService;

    @Autowired
    TableRepository tableRepo;

    @Autowired
    MenuService menuService;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    OrderDetailRepository orderDetailrepository;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    CashierService cashierService;

    @Autowired
    CashierRepository cashierRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findByIdOrder(Integer id) throws NoSuchElementException {
        Order order = orderRepository.findById(id).get();
        if (order == null) {
            throw new NoSuchElementException("List Order Not Found");
        }
        return order;
    }

    public void validCreateOrder(Order orders) throws Exception {
        Tables tables = tableService.findById(orders.getTables().getId());
        if (tables == null) {
            throw new Exception("table not found");
        } else if (tables.getStatusTable().equals("booked")) {
            throw new Exception("table on booked");
        } else if (orders.getQuantityCustomer() > tables.getChairsAmount()) {
            throw new Exception("the number of seats exceeds the capacity");
        }
        tables.setStatusTable("booked");
        tableService.save(tables);
    }

    private void extractOrderDetail(List<OrderDetail> listOrder) {
        for (OrderDetail detail : listOrder) {
            orderDetailrepository.save(detail);
        }
    }

    private Menu extractMenu(OrderDetail order) throws Exception {
        for (Menu menu : menuRepository.findAll()) {
            if (menu.getId().equals(order.getMenu().getId())) {
                order.setMenu(menuRepository.getOne(order.getMenu().getId()));
                if (menu.getStock() < order.getQuantity()) {
                    throw new Exception("stock empty");
                }
                menu.setStock(menu.getStock() - order.getQuantity());
                menu.setPrice(menu.getPrice());
                menuRepository.save(menu);
            }
        }
        return order.getMenu();
    }

    private Cashier extractCashier(Order order) {
        for (Cashier cashier : cashierService.findAll()) {
            if (cashier.getId().equals(order.getCashier().getId())) {
                order.setCashier(order.getCashier());
            }
        }
        return order.getCashier();
    }

    private Tables extractTables(Order order) {
        for (Tables tables : tableService.findAll()) {
            if (tables.getId().equals(order.getTables().getId())) {
                order.setTables(order.getTables());
            }
        }
        return order.getTables();
    }

    public Integer calculationPrice(Order orders, List<OrderDetail> order) throws Exception {
        Integer total = 0;
        for (OrderDetail detail : orders.getOrderDetails()) {
            detail.setOrderDetail(orders);
            detail.setQuantity(detail.getQuantity());
            extractMenu(detail);
            Integer subTotal = (extractMenu(detail).getPrice() * detail.getQuantity());
            detail.setSubTotal(subTotal);
            total += subTotal;
        }
        return total;
    }

    @Override
    public Order save(Order orders) throws Exception {
        List<OrderDetail> listOrder = orders.getOrderDetails();
        orders.setQuantityCustomer(orders.getQuantityCustomer());
        extractTables(orders);
        extractCashier(orders);
        orders.setCustomerName(orders.getCustomerName());
        orders.setOrderDetails(listOrder);
        orders.setPriceTotal(calculationPrice(orders, listOrder));
        orders.setStatusTransaction("unpaid");
        validCreateOrder(orders);
        extractOrderDetail(listOrder);
        return orderRepository.save(orders);
    }

    @Override
    public Order updateOrder(Order order) throws Exception {
        Order oldOrder = orderRepository.findById(order.getId()).get();
        if (order.getPayment() < oldOrder.getPriceTotal()) {
            throw new Exception("payment is not enough");
        } else if (order.getPayment() >= oldOrder.getPriceTotal()) {
            order.setRefund(order.getPayment() - oldOrder.getPriceTotal());
            order.setPriceTotal(oldOrder.getPriceTotal());
            order.setStatusTransaction("paid");
            if (order.getStatusTransaction().equals("paid")) {
                oldOrder.getTables().setStatusTable("available");
            }
        }else if(order.getStatusTransaction().equalsIgnoreCase("unpaid")){
            order.setStatusTransaction("paid");
        }
        return orderRepository.save(order);
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }
}
