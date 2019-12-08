package com.warungmakan.service.impl;

import com.warungmakan.entities.OrderDetail;
import com.warungmakan.repositories.OrderDetailRepository;
import com.warungmakan.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepository detailRepo;

    @Override
    public List<OrderDetail> findAll() {
        return detailRepo.findAll();
    }

    @Override
    public OrderDetail findById(Integer id) throws Exception {
        OrderDetail orderDetail = detailRepo.findById(id).get();
        if (orderDetail == null) {
            throw new Exception("List Orderdetail not found");
        }
        return orderDetail;
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) throws Exception {
        return detailRepo.save(orderDetail);
    }

    @Override
    public void delete(Integer id) {
        detailRepo.deleteById(id);
    }

}
