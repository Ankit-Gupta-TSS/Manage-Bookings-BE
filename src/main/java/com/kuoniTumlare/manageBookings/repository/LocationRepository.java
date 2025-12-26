package com.kuoniTumlare.manageBookings.repository;

import com.kuoniTumlare.manageBookings.entities.Location;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends R2dbcRepository<Location, String> {


}