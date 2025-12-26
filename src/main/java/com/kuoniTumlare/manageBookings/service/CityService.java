package com.kuoniTumlare.manageBookings.service;

import com.kuoniTumlare.manageBookings.repository.CityRepository;
import com.kuoniTumlare.manageBookings.response.CityDTO;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Flux<CityDTO> searchCity(String name) {
        if (ObjectUtils.isEmpty(name)) {
            return cityRepository.findAll()
                    .map(city -> CityDTO.builder()
                            .id(city.getId())
                            .name(city.getName())
                            .build());
        }
        return cityRepository.searchByName(name)
                .map(city -> CityDTO.builder()
                        .id(city.getId())
                        .name(city.getName())
                        .build());
    }
}