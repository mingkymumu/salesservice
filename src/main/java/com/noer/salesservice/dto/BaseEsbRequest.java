package com.noer.salesservice.dto;

import lombok.Data;

/**
 * @author farhan
 */
@Data
public class BaseEsbRequest {

    private QpcRequestHeader header;
    private QpcRequestData data;

}
