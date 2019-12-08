package com.warungmakan.controller;


import com.warungmakan.entities.Cashier;
import com.warungmakan.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CashierController {

    @Autowired
    CashierService cashierService;

    @GetMapping("/cashier")
    public List<Cashier> getAllCashier() {
        return cashierService.findAll();
    }

    @GetMapping("/cashier/{id}")
    public Cashier findByIdCashier(@PathVariable Integer id) {
        return  cashierService.findById(id);
    }

    @PostMapping("/cashier")
    public Cashier createCashier(@RequestBody Cashier cashier){
        return  cashierService.save(cashier);
    }

    @DeleteMapping("cashier/{id}")
    public void deleteCashier(@PathVariable Integer id) {
        cashierService.deleteByIdCashier(id);
    }
}
