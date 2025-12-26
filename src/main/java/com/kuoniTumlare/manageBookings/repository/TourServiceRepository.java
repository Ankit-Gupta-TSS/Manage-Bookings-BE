package com.kuoniTumlare.manageBookings.repository;

import com.kuoniTumlare.manageBookings.entities.TourServiceEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TourServiceRepository
        extends ReactiveCrudRepository<TourServiceEntity, String> {

    Flux<TourServiceEntity> findByRefNumberOrderBySortOrder(String refNumber);
}