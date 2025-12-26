package com.kuoniTumlare.manageBookings.service;

import com.kuoniTumlare.manageBookings.repository.TourRequestRepository;
import com.kuoniTumlare.manageBookings.response.TourRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class TourRequestService {

    private final TourRequestRepository repository;

    public Flux<TourRequestDTO> getAll() {
        return repository.findAll()
                .map(tr -> TourRequestDTO.builder()
                        .tourRequestNo(tr.getTourRequestNo().trim())
                        .tourName(tr.getTourName())
                        .build());
    }
}
