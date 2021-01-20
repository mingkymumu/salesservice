package com.noer.salesservice.dto;

import lombok.Data;

/**
 * @author farhan
 */
@Data
public class BaseAolRequest {

    private AolRequestHeader header;
    private AolRequestData data;

}
