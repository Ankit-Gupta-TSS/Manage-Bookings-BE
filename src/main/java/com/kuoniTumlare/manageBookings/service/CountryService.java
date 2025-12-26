package com.kuoniTumlare.manageBookings.service;

import com.kuoniTumlare.manageBookings.repository.CountryRepository;
import com.kuoniTumlare.manageBookings.response.CountryDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryService {

    private final CountryRepository repository;

    public Flux<CountryDTO> getAll() {
        return repository.findActiveCountries()
                .doOnNext(c -> log.info("Country found: {}", c))
                .map(c -> CountryDTO.builder()
                        .countryName(c.getCountryName())
                        .countryCode(c.getCountryCode())
                        .build());
    }
}
