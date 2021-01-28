package com.noer.salesservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author farhan
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AolRequestHeader {

    private String requestId;
    private String requestTimestamp;
    private String userId;
    private String userType;
    private String branch;
    private String costGrp;
    private String appNo;
    private String channelId;
    private String callbackUrl;

}
