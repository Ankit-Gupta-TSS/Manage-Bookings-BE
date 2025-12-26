package com.kuoniTumlare.manageBookings.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExcursionItemResponse {

    private boolean checkBoxSelected;
    private String cityCode;
    private String cityName;
    private String title;
    private String departurePlace;
    private String description;
    private String importantNote;
}