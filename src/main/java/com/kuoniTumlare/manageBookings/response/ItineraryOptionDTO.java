package com.kuoniTumlare.manageBookings.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItineraryOptionDTO {

    private String abbreviation;
    private String pkgText;
}
