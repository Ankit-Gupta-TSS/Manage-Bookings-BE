package com.kuoniTumlare.manageBookings.repository;

import com.kuoniTumlare.manageBookings.entities.Supplier;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface SupplierRepository extends R2dbcRepository<Supplier, String> {

    @Query("""
                SELECT *
                FROM suppliers_cacbda9caa8d
                WHERE city_code IN (:cityCodes)
                ORDER BY supplier_short_name
            """)
    Flux<Supplier> findByCityCodes(List<String> cityCodes);
}