package com.kuoniTumlare.manageBookings.service;

import com.kuoniTumlare.manageBookings.repository.ItineraryOptionRepository;
import com.kuoniTumlare.manageBookings.response.ItineraryOptionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItineraryOptionService {

    private final ItineraryOptionRepository repository;

    public Flux<ItineraryOptionDTO> getByCities(List<String> cityCodes) {
        return repository.findByCityCodes(cityCodes)
                .map(o -> ItineraryOptionDTO.builder()
                        .abbreviation(o.getAbbreviation())
                        .pkgText(o.getPackageText())
                        .build());
    }
}
