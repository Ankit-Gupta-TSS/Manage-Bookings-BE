package com.kuoniTumlare.manageBookings.service;


import com.kuoniTumlare.manageBookings.repository.LocationRepository;
import com.kuoniTumlare.manageBookings.response.LocationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public Flux<LocationDTO> getAll() {
        return locationRepository.findAll()
                .map(location -> LocationDTO.builder()
                        .code(location.getCode())
                        .name(location.getName())
                        .countryCode(location.getCountryCode())
                        .build());
    }
}
