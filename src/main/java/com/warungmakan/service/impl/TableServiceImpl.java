package com.warungmakan.service.impl;

import com.warungmakan.entities.Tables;
import com.warungmakan.repositories.OrderRepository;
import com.warungmakan.repositories.TableRepository;
import com.warungmakan.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TableServiceImpl implements TableService {

    @Autowired
    TableRepository tableRepository;

    @Autowired
    TableService tableService;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Tables> findAll() {
        return tableRepository.findAll();
    }

    @Override
    public Tables findById(Integer id) {
        return tableRepository.findByid(id);
    }

    @Override
    public Tables save(Tables tables) {
        return tableRepository.save(tables);
    }

    @Override
    public void delete(Integer id) {
        tableRepository.deleteById(id);
    }

}



