package com.noer.salesservice.dto;

import lombok.Data;

/**
 * @author farhan
 */
@Data
public class QpcRequestHeader {

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
