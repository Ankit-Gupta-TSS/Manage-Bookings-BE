package com.kuoniTumlare.manageBookings.controller;

import com.kuoniTumlare.manageBookings.response.ApiResponse;
import com.kuoniTumlare.manageBookings.response.TourRequestDTO;
import com.kuoniTumlare.manageBookings.service.TourRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tour-requests")
@RequiredArgsConstructor
public class TourRequestController {

    private final TourRequestService service;

    @GetMapping
    public Mono<ApiResponse<List<TourRequestDTO>>> getAll() {
        return service.getAll()
                .collectList().map(ApiResponse::success);
    }
}
