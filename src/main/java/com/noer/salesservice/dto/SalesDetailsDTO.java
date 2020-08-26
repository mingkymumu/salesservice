package com.noer.salesservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)

public class SalesDetailsDTO {
    private Long id;
    private Integer quantity;
    private Long productId;
    private String productName;
    private Double productPrice;
    private Double subTotal;

    public Double getSubTotal(){
        return quantity * productPrice;
    }
}
