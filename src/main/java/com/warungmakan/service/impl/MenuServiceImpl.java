package com.warungmakan.service.impl;

import com.warungmakan.entities.Menu;
import com.warungmakan.repositories.MenuRepository;
import com.warungmakan.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    MenuService menuService;


    @Override
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu findById(Integer id) {
        return menuRepository.findById(id).get();
    }

    @Override
    public Menu save(Menu menu) throws Exception {
        return menuRepository.save(menu);
    }
    @Override
    public void deleteByIdMenu (Integer id){
        menuRepository.deleteById(id);
    }
}
