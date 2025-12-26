package com.kuoniTumlare.manageBookings.repository;

import com.kuoniTumlare.manageBookings.entities.Country;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface CountryRepository extends R2dbcRepository<Country, String> {

    @Query("""
        SELECT *
        FROM COUNTRIES_CACBDA9CAA8D
        WHERE TRIM(is_active) = 'Y'
        ORDER BY country_name
    """)
    Flux<Country> findActiveCountries();
}