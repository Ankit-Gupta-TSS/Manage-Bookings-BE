package com.kuoniTumlare.manageBookings.response;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class ItineraryServiceDTO {

    private Integer sortOrder;
    private String countryCode;
    private String cityName;
    private String startTime;
    private String endTime;
    private String supplierName;
    private String serviceName;
    private String suppType;
    private BigDecimal pPrice;
    private BigDecimal gPrice;
    private String currency;
}
