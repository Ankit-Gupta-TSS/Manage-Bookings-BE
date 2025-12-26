package com.kuoniTumlare.manageBookings.repository;

import com.kuoniTumlare.manageBookings.entities.SupplierService;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SupplierServiceRepository
        extends R2dbcRepository<SupplierService, String> {

    @Query("""
                SELECT service_id, service_name, price
                FROM supplier_services_cacbda9caa8d
                WHERE supplier_code = :supplierCode
                ORDER BY service_id
            """)
    Flux<SupplierService> findBySupplierCode(String supplierCode);
}