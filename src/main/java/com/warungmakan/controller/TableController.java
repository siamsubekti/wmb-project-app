package com.warungmakan.controller;


import com.warungmakan.entities.Tables;
import com.warungmakan.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TableController {

    @Autowired
    TableService tableService;

    @GetMapping("/Alltable")
    public List<Tables> getAllTable(){
        return tableService.findAll();
    }
}
