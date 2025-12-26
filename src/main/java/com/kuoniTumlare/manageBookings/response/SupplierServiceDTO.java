package com.kuoniTumlare.manageBookings.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class SupplierServiceDTO {
    private String serviceName;
    private Integer serviceId;
    private BigDecimal price;
}