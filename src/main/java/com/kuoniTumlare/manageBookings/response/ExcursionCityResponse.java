package com.kuoniTumlare.manageBookings.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ExcursionCityResponse {

    private String cityName;
    private List<ExcursionItemResponse> subitems;
}