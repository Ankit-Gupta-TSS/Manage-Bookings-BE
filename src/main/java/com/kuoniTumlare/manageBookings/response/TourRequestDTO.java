package com.kuoniTumlare.manageBookings.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TourRequestDTO {
    private String tourRequestNo;
    private String tourName;
}