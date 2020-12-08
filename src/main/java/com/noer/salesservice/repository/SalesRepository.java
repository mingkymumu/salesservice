package com.noer.salesservice.repository;

import com.noer.salesservice.domain.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.annotation.Native;
import java.util.List;

public interface SalesRepository extends JpaRepository<Sales,Long> {
    @Query (value = "select s from Sales s join SalesDetails d on s.id = d.sales.id where s.userName like '%?1%' or d.productName like '%?2%'")
    List<Sales> findByUserNameAndDetails(String userName,String productName);
}
