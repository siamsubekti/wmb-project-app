package com.warungmakan.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "`table`")
public class Tables {

    @Id
    private Integer id;

    @Column(name = "table_name")
    private String name;

    @Column(name = "chairs_amount")
    private Integer chairsAmount;

    @Column(name = "table_status")
    private String statusTable;

    @OneToMany(mappedBy = "tables", cascade = CascadeType.ALL)
    private List<Order> tableOrderList;

    public Tables(){}

    public Tables(Integer id, String name, Integer chairsAmount, String statusTable, List<Order> tableOrderList) {
        this.id = id;
        this.name = name;
        this.chairsAmount = chairsAmount;
        this.statusTable = statusTable;
        this.tableOrderList = tableOrderList;
    }

    public Tables(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Tables setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Tables setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getChairsAmount() {
        return chairsAmount;
    }

    public Tables setChairsAmount(Integer chairsAmount) {
        this.chairsAmount = chairsAmount;
        return this;
    }

    public String getStatusTable() {
        return statusTable;
    }

    public Tables setStatusTable(String meja) {
        this.statusTable = meja;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tables tables = (Tables) o;
        return Objects.equals(id, tables.id) &&
                Objects.equals(name, tables.name) &&
                Objects.equals(chairsAmount, tables.chairsAmount) &&
                Objects.equals(statusTable, tables.statusTable) &&
                Objects.equals(tableOrderList, tables.tableOrderList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, chairsAmount, statusTable, tableOrderList);
    }
}
