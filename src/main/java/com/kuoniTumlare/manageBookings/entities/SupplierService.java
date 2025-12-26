package com.kuoniTumlare.manageBookings.entities;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@Table(name = "supplier_services_cacbda9caa8d")
public class SupplierService {
    @Id
    @Column("SERVICE_ID")
    private String serviceId;

    @Column("SUPPLIER_CODE")
    private String supplierCode;

    @Column("SERVICE_NAME")
    private String serviceName;

    @Column("SERVICE_CODE")
    private String serviceCode;

    @Column("PRICE")
    private BigDecimal price;

    @Column("CURRENCY")
    private String currency;

    @Column("DESCRIPTION")
    private String description;

    @Column("IS_ACTIVE")
    private String isActive;

    @Column("CREATED_DATE")
    private LocalDateTime createdDate;

    @Column("MODIFIED_DATE")
    private LocalDateTime modifiedDate;
}