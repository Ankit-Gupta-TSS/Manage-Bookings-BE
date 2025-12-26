package com.kuoniTumlare.manageBookings.controller;


import com.kuoniTumlare.manageBookings.response.ApiResponse;
import com.kuoniTumlare.manageBookings.response.LocationDTO;
import com.kuoniTumlare.manageBookings.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping()
    public Mono<ApiResponse<List<LocationDTO>>> searchCities() {
        return locationService.getAll()
                .collectList().map(ApiResponse::success);
    }

}
