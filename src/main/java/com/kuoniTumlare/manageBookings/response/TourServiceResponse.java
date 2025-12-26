package com.kuoniTumlare.manageBookings.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TourServiceResponse  implements TourServiceBaseResponse  {

    private String option;
    private String day;
    private Boolean isOpen;
    private List<TourServiceItemResponse> subitems;
}
