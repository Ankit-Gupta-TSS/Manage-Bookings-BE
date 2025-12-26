package com.kuoniTumlare.manageBookings.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TourServiceItemResponse  implements TourServiceBaseResponse  {

    private Boolean checkBoxSelected;
    private String sortOrder;
    private String countryCode;
    private String cityName;
    private String startTime;
    private String endTime;
    private String suppShortName;
    private String supplierName;
    private String serviceName;
    private String suppType;
    private String pPrice;
    private String gPrice;
    private String currency;
}

