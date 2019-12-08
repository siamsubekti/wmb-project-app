package com.warungmakan.controller;

import com.warungmakan.entities.Menu;
import com.warungmakan.repositories.MenuRepository;
import com.warungmakan.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @Autowired
    MenuRepository menuRepository;

    @GetMapping("/menu")
    public List<Menu> getAllMenu() {
        return menuService.findAll();
    }

    @GetMapping("/menu/{id}")
    public Menu findByIdMenu(@PathVariable Integer id){
        return menuService.findById(id);
    }

    @PostMapping("/menu")
    public Menu createMenu(@RequestBody Menu menu) throws Exception {
        return  menuService.save(menu);
    }

    @PatchMapping("/menu")
    public Menu editMenu(@RequestBody Menu menu) throws Exception {
        return menuService.save(menu);
    }

    @DeleteMapping("/menu/{id}")
    public void DeleteMenu(@PathVariable Integer id) {
        menuService.deleteByIdMenu(id);
    }

}
