package com.noer.salesservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain=true)
@Entity
@Table(name = "sales_details")
public class SalesDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private Long productId;
    private String productName;
    private Double productPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    private Sales sales;

}
