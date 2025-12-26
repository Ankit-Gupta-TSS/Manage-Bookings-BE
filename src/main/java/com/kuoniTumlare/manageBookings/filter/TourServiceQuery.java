package com.kuoniTumlare.manageBookings.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TourServiceQuery {

    private String cityCode;

    private Integer day;
}
