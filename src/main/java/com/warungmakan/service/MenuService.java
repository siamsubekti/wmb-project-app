package com.warungmakan.service;

import com.warungmakan.entities.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> findAll();
    Menu findById(Integer id);
    Menu save(Menu menu) throws Exception;
    void deleteByIdMenu(Integer id);
}
