package com.warungmakan.service;

import com.warungmakan.entities.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> findAll();
    OrderDetail findById(Integer id) throws Exception;
    OrderDetail save(OrderDetail orderDetail) throws Exception;
    void delete (Integer id);
}
