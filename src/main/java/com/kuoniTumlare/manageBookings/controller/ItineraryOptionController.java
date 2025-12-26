package com.kuoniTumlare.manageBookings.controller;

import com.kuoniTumlare.manageBookings.response.ApiResponse;
import com.kuoniTumlare.manageBookings.response.ItineraryOptionDTO;
import com.kuoniTumlare.manageBookings.service.ItineraryOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/itinerary/options")
@RequiredArgsConstructor
public class ItineraryOptionController {

    private final ItineraryOptionService service;

    @GetMapping
    public Mono<ApiResponse<List<ItineraryOptionDTO>>> getOptions(@RequestParam List<String> cityCodes) {
        return service.getByCities(cityCodes)
                .collectList().map(ApiResponse::success);
    }
}
