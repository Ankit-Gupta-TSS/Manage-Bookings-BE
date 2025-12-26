package com.kuoniTumlare.manageBookings.controller;

import com.kuoniTumlare.manageBookings.filter.TourServiceQuery;
import com.kuoniTumlare.manageBookings.response.ApiResponse;
import com.kuoniTumlare.manageBookings.response.TourServiceBaseResponse;
import com.kuoniTumlare.manageBookings.service.ItineraryService;
import com.kuoniTumlare.manageBookings.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tours")
@RequiredArgsConstructor
public class TourServiceController {

    private final TourService service;

    private final ItineraryService itineraryService;

    @GetMapping("/{refNumber}/services")
    public Mono<ApiResponse<List<TourServiceBaseResponse>>> getTourServices(
            @PathVariable String refNumber,
            @ParameterObject TourServiceQuery query) {
        if (query == null || (query.getCityCode() != null && query.getDay() != null)) {
            return itineraryService.getServices(refNumber, query)
                    .collectList()
                    .map(ApiResponse::success);
        }
        return service.getServicesByRefNumber(refNumber)
                .collectList()
                .map(ApiResponse::success);

    }
}