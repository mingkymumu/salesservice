package com.noer.salesservice.repository;

import com.noer.salesservice.domain.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales,Long> {

}
