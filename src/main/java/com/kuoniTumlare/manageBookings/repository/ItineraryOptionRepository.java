package com.kuoniTumlare.manageBookings.repository;

import com.kuoniTumlare.manageBookings.entities.ItineraryOption;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface ItineraryOptionRepository
        extends R2dbcRepository<ItineraryOption, String> {

    @Query("""
                SELECT io.abbreviation, io.package_text
                FROM itinerary_options_cacbda9caa8d io
                WHERE io.tour_request_no IN (
                    SELECT id.tour_request_no
                    FROM itinerary_day_cacbda9caa8d id
                    JOIN locations_cacbda9caa8d l
                        ON l.country_code = id.country_code
                    WHERE l.CODE IN (:cityCodes)
                )
                ORDER BY io.abbreviation
            """)
    Flux<ItineraryOption> findByCityCodes(List<String> cityCodes);



}
