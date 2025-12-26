package com.kuoniTumlare.manageBookings.repository;

import com.kuoniTumlare.manageBookings.entities.City;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CityRepository extends R2dbcRepository<City, String> {


    @Query("""
                SELECT *
                FROM CITY_cacbda9caa8d
                WHERE LOWER(NAME) LIKE '%' || LOWER(:name) || '%'
            """)
    Flux<City> searchByName(String name);
}