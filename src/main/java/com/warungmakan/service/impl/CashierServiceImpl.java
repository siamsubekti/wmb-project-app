package com.warungmakan.service.impl;

import com.warungmakan.entities.Cashier;
import com.warungmakan.repositories.CashierRepository;
import com.warungmakan.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CashierServiceImpl implements CashierService {

    @Autowired
    CashierRepository cashierRepository;

    @Autowired
    CashierService cashierService;

    @Override
    public List<Cashier> findAll() {
        return cashierRepository.findAll();
    }

    @Override
    public Cashier save(Cashier cashier) {
        return cashierRepository.save(cashier);
    }

    @Override
    public Cashier findById(Integer id) {
        return cashierRepository.getOne(id);
    }

    @Override
    public void deleteByIdCashier(Integer id) {
        cashierRepository.deleteById(id);
    }

}
