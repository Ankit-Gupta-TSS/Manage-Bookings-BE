package com.kuoniTumlare.manageBookings.repository;

import com.kuoniTumlare.manageBookings.entities.TourRequest;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRequestRepository
        extends R2dbcRepository<TourRequest, String> {
}