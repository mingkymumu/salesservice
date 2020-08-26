package com.noer.salesservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class SalesDTO {
    private Long id;
    private Long userId;
    private String userName;
    private Double total;
    private Date transactionDate;
    private List<SalesDetailsDTO> salesDetails;

}
