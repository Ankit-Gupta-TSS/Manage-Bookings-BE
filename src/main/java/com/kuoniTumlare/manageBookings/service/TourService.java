package com.kuoniTumlare.manageBookings.service;

import com.kuoniTumlare.manageBookings.entities.TourServiceEntity;
import com.kuoniTumlare.manageBookings.repository.TourServiceRepository;
import com.kuoniTumlare.manageBookings.response.TourServiceBaseResponse;
import com.kuoniTumlare.manageBookings.response.TourServiceItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class TourService {

    private final TourServiceRepository repository;

    public Flux<TourServiceBaseResponse> getServicesByRefNumber(String refNumber) {
        return repository.findByRefNumberOrderBySortOrder(refNumber)
                .map(this::mapToResponse);
    }

    private TourServiceItemResponse mapToResponse(TourServiceEntity e) {
        return TourServiceItemResponse.builder()
                .sortOrder(e.getSortOrder())
                .countryCode(e.getCountryCode())
                .cityName(e.getCityName())
                .startTime(e.getStartTime())
                .endTime(e.getEndTime())
                .supplierName(e.getSupplierName())
                .serviceName(e.getServiceName())
                .suppType(e.getSuppType())
                .pPrice(e.getPPrice())
                .gPrice(e.getGPrice())
                .currency(e.getCurrency())
                .build();
    }
}
