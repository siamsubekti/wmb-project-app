package com.warungmakan.service;

import com.warungmakan.entities.Order;

import java.util.List;
import java.util.NoSuchElementException;

public interface OrderService {

    List<Order> findAll();
    Order findByIdOrder(Integer id) throws Exception;
    Order save(Order order) throws Exception;
    void delete (Integer id);
    Order updateOrder(Order order) throws Exception;

}
