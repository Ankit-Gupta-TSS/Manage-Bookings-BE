package com.kuoniTumlare.manageBookings.controller;

import com.kuoniTumlare.manageBookings.response.ApiResponse;
import com.kuoniTumlare.manageBookings.response.ItineraryServiceDTO;
import com.kuoniTumlare.manageBookings.service.ItineraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/itinerary/services")
@RequiredArgsConstructor
public class ItineraryController {

    private final ItineraryService service;

    @GetMapping
    public Mono<ApiResponse<List<ItineraryServiceDTO>>> getServices(@RequestParam String refNumber) {

        return service.getByRefNumber(refNumber)
                .collectList().map(ApiResponse::success);
    }
}
