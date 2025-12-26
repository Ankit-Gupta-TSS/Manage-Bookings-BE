package com.kuoniTumlare.manageBookings.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CountryDTO {
    private String countryName;
    private String countryCode;
}