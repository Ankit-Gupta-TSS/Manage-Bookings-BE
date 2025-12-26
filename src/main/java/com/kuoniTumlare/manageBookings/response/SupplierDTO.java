package com.kuoniTumlare.manageBookings.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SupplierDTO {
    private String countryCode;
    private String cityCode;
    private String cityName;
    private String suppType;
    private String suppShortName;
    private String supplierId;
    private String address;
    private boolean isOpen;
    private List<SupplierServiceDTO> subitems;
}