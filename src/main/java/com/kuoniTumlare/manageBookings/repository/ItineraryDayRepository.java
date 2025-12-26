package com.kuoniTumlare.manageBookings.repository;

import com.kuoniTumlare.manageBookings.entities.ItineraryDayEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ItineraryDayRepository
        extends R2dbcRepository<ItineraryDayEntity, String> {

    @Query("""
                SELECT
                    sort_order,
                    country_code,
                    city_name,
                    start_time,
                    end_time,
                    supp_short_name,
                    service_name,
                    supp_type,
                    p_price,
                    g_price,
                    currency
                FROM itinerary_day_cacbda9caa8d
                WHERE tour_request_no = :refNumber
                ORDER BY sort_order
            """)
    Flux<ItineraryDayEntity> findByTourRequestNo(String refNumber);


    Flux<ItineraryDayEntity> findByTourRequestNoAndCityNameAndDayNumber(String tourRequestNo, String cityName,
                                                                        Integer dayNumber);
}
