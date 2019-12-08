package com.warungmakan.controller;


import com.warungmakan.entities.OrderDetail;
import com.warungmakan.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("/order/detail")
    public List<OrderDetail> getAllOrderDetail() {
        return orderDetailService.findAll();
    }
}
