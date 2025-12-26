package com.kuoniTumlare.manageBookings.service;

import com.kuoniTumlare.manageBookings.entities.ItineraryDayEntity;
import com.kuoniTumlare.manageBookings.filter.TourServiceQuery;
import com.kuoniTumlare.manageBookings.repository.ItineraryDayRepository;
import com.kuoniTumlare.manageBookings.response.ItineraryServiceDTO;
import com.kuoniTumlare.manageBookings.response.TourServiceBaseResponse;
import com.kuoniTumlare.manageBookings.response.TourServiceItemResponse;
import com.kuoniTumlare.manageBookings.response.TourServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class ItineraryService {

    private final ItineraryDayRepository repository;

    public Flux<ItineraryServiceDTO> getByRefNumber(String refNumber) {
        return repository.findByTourRequestNo(refNumber)
                .map(i -> ItineraryServiceDTO.builder()
                        .sortOrder(i.getSortOrder())
                        .countryCode(i.getCountryCode())
                        .cityName(i.getCityName())
                        .startTime(i.getStartTime())
                        .endTime(i.getEndTime())
                        .supplierName(i.getSuppShortName())
                        .serviceName(i.getServiceName())
                        .suppType(i.getSuppType())
                        .pPrice(i.getPPrice())
                        .gPrice(i.getGPrice())
                        .currency(i.getCurrency())
                        .build());
    }



    public Flux<TourServiceBaseResponse> getServices(String tourRequestNo, TourServiceQuery query) {
        return repository
                .findByTourRequestNoAndCityNameAndDayNumber(
                        tourRequestNo,
                        query.getCityCode(),
                        query.getDay()
                )
                .sort(Comparator.comparing(ItineraryDayEntity::getSortOrder))
                .groupBy(ItineraryDayEntity::getOptionName)
                .flatMap(groupedFlux ->
                        groupedFlux
                                .map(this::toSubItem)
                                .collectList()
                                .map(subItems ->
                                        TourServiceResponse.builder()
                                                .option(groupedFlux.key())
                                                .day(query.getDay().toString())
                                                .isOpen(false)
                                                .subitems(subItems)
                                                .build()
                                )
                );
    }

    private TourServiceItemResponse toSubItem(ItineraryDayEntity e) {
        return TourServiceItemResponse.builder()
                .checkBoxSelected("Y".equals(e.getIsSelected()))
                .sortOrder(String.valueOf(e.getSortOrder()))
                .countryCode(e.getCountryCode())
                .cityName(e.getCityName())
                .startTime(e.getStartTime())
                .endTime(e.getEndTime())
                .suppShortName(e.getSuppShortName())
                .serviceName(e.getServiceName())
                .suppType(e.getSuppType())
                .pPrice(String.valueOf(e.getPPrice()))
                .gPrice(String.valueOf(e.getGPrice()))
                .currency(e.getCurrency())
                .build();
    }
}
