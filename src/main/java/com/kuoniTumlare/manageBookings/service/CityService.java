package com.kuoniTumlare.manageBookings.service;

import com.kuoniTumlare.manageBookings.entities.City;
import com.kuoniTumlare.manageBookings.repository.CityRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Flux<City> searchCity(String name) {
        return cityRepository.searchByName(name);
    }
}