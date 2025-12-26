package com.kuoniTumlare.manageBookings.repository;

import com.kuoniTumlare.manageBookings.entities.ExcursionEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface ExcursionRepository extends ReactiveCrudRepository<ExcursionEntity, Long> {

    Flux<ExcursionEntity> findByCityCodeIn(List<String> cityCodes);
}
