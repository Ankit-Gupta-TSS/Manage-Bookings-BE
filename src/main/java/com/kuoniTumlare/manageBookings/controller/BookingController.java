//package com.kuoniTumlare.manageBookings.controller;
//
//import com.kuoniTumlare.manageBookings.response.ApiResponse;
//import com.kuoniTumlare.manageBookings.response.CityDTO;
//import com.kuoniTumlare.manageBookings.service.CityService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1")
//public class BookingController {
//
//    private final CityService cityService;
//
//    public BookingController(CityService cityService) {
//        this.cityService = cityService;
//    }
//
//    @GetMapping("/cities")
//    public Mono<ApiResponse<List<CityDTO>>> searchCities(@RequestParam(required = false) String name) {
//        return cityService.searchCity(name)
//                .collectList()
//                .map(ApiResponse::success);
//    }
//}
