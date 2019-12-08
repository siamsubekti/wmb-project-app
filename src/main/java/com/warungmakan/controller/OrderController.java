package com.warungmakan.controller;

import com.warungmakan.entities.*;
import com.warungmakan.repositories.OrderRepository;
import com.warungmakan.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class OrderController {

    @Autowired
    TableService tableService;

    @Autowired
    OrderService orderService;

    @Autowired
    CashierService cashierService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    OrderRepository orderRepository;

    //All Get Mapping
    @GetMapping("/order")
    public List<Order> getAllOrder(){
        return orderService.findAll();
    }

    @GetMapping("order/{id}")
    public Order findByIdOrder(@PathVariable Integer id) throws Exception {
        Order order = orderService.findByIdOrder(id);
        if (order == null) {
            throw new Exception("List order not found");
        } else {
            return order;
        }
    }

    //CRUD Order
    @PostMapping("/order")
    public Order createOrder(@RequestBody Order order) throws Exception {
        return orderService.save(order);
    }

    @PatchMapping("/order")
    public Order update(@RequestBody Order order) throws Exception {
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/order/{id}")
    public void deleteByIdOrder(@PathVariable Integer id){
        orderService.delete(id);
    }

}
