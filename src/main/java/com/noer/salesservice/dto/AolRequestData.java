package com.noer.salesservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author farhan
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AolRequestData {

    private String oid;
    private String noKontrak;
    private String branchId;
    private String oidNo;

}
