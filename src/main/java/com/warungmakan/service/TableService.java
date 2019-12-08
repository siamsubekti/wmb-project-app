package com.warungmakan.service;

import com.warungmakan.entities.Tables;

import java.util.List;

public interface TableService {

    List<Tables> findAll();
    Tables findById(Integer id);
    Tables save(Tables tables);
    void delete(Integer id);

}
