package com.warungmakan.repositories;

import com.warungmakan.entities.Tables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Tables,Integer> {
//    List<Table> findByIdandStatusMeja (String statusMeja);
    Tables findByid (Integer id);
}
