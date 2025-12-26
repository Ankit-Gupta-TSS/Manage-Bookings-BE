package com.kuoniTumlare.manageBookings.controller;

import com.kuoniTumlare.manageBookings.response.ApiResponse;
import com.kuoniTumlare.manageBookings.response.SupplierDTO;
import com.kuoniTumlare.manageBookings.service.SupplierQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierQueryService service;

    @GetMapping
    public Mono<ApiResponse<List<SupplierDTO>>> getByCities(@RequestParam List<String> cityCodes) {
        return service.getByCities(cityCodes)
                .collectList().map(ApiResponse::success);
    }
}
