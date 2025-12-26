package com.kuoniTumlare.manageBookings.service;

import com.kuoniTumlare.manageBookings.entities.ExcursionEntity;
import com.kuoniTumlare.manageBookings.repository.ExcursionRepository;
import com.kuoniTumlare.manageBookings.response.ExcursionCityResponse;
import com.kuoniTumlare.manageBookings.response.ExcursionItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcursionService {

    private final ExcursionRepository excursionRepository;

    public Flux<ExcursionCityResponse> getExcursionsByCityCodes(List<String> cityCodes) {
        return excursionRepository
                .findByCityCodeIn(cityCodes)
                .groupBy(ExcursionEntity::getCityName)
                .flatMap(groupedFlux ->
                        groupedFlux
                                .map(this::mapToItem)
                                .collectList()
                                .map(items ->
                                        ExcursionCityResponse.builder()
                                                .cityName(groupedFlux.key())
                                                .subitems(items)
                                                .build()
                                )
                );
    }

    private ExcursionItemResponse mapToItem(ExcursionEntity entity) {
        return ExcursionItemResponse.builder()
                .checkBoxSelected("Y".equalsIgnoreCase(entity.getIsSelected()))
                .cityCode(entity.getCityCode())
                .cityName(entity.getCityName())
                .title(entity.getTitle())
                .departurePlace(entity.getDeparturePlace())
                .description(entity.getDescription())
                .importantNote(entity.getImportantNote())
                .build();
    }

}
