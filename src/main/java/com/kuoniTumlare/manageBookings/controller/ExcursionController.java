package com.kuoniTumlare.manageBookings.controller;

import com.kuoniTumlare.manageBookings.response.ApiResponse;
import com.kuoniTumlare.manageBookings.response.ExcursionCityResponse;
import com.kuoniTumlare.manageBookings.service.ExcursionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/excursions")
@RequiredArgsConstructor
public class ExcursionController {

    private final ExcursionService excursionService;

    @GetMapping
    public Mono<ApiResponse<List<ExcursionCityResponse>>> getExcursions(
            @RequestParam List<String> cityCodes) {
        return excursionService.getExcursionsByCityCodes(cityCodes)
                .collectList().map(ApiResponse::success);
    }
}
