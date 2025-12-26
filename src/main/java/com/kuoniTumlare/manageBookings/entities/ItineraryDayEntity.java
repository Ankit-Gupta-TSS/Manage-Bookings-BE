package com.kuoniTumlare.manageBookings.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Getter
@Setter
@Table("ITINERARY_DAY_CACBDA9CAA8D")
public class ItineraryDayEntity {

    @Id
    private String itineraryServiceId;

    private String tourRequestNo;
    private String optionName;
    private Integer dayNumber;
    private Integer sortOrder;
    private String countryCode;
    private String cityName;
    private String startTime;
    private String endTime;
    private String suppShortName;
    private String serviceName;
    private String suppType;
    private BigDecimal pPrice;
    private BigDecimal gPrice;
    private String currency;
    private String isSelected;
    private String isOpen;
}
