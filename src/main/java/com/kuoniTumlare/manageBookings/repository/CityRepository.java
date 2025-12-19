package com.kuoniTumlare.manageBookings.repository;

import com.kuoniTumlare.manageBookings.entities.City;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface CityRepository extends R2dbcRepository<City, String> {


    @Query("""
        SELECT *
        FROM city
        WHERE LOWER(name) ILIKE LOWER(CONCAT('%', :name, '%'))
    """)
    Flux<City> searchByName(String name);
}