package com.warungmakan.config;

import com.warungmakan.service.*;
import com.warungmakan.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoSpringConfig {

    @Bean
    public MenuService menuService() {
        return new MenuServiceImpl();
    }

    @Bean
    public TableService mejaService(){
        return new TableServiceImpl();
    }

    @Bean
    public OrderService pesanan(){
        return new OrderServiceImpl();
    }

    @Bean
    public OrderDetailService pesananDetailService() {
        return new OrderDetailServiceImpl();
    }

    @Bean
    public CashierService kasirService(){
        return new CashierServiceImpl();
    }

}
