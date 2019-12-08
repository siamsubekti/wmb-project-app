package com.warungmakan.service;

import com.warungmakan.entities.Cashier;

import java.util.List;

public interface CashierService {

    List<Cashier> findAll();
    Cashier save(Cashier cashier);
    Cashier findById (Integer id);
    void deleteByIdCashier(Integer id);
}
