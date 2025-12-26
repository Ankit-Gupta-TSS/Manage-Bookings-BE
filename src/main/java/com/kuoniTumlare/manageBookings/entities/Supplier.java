package com.kuoniTumlare.manageBookings.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "SUPPLIERS_CACBDA9CAA8D")
public class Supplier {
    @Id
    @Column("SUPPLIER_ID")
    private String supplierId;

    @Column("SUPPLIER_CODE")
    private String supplierCode;

    @Column("SUPPLIER_SHORT_NAME")
    private String supplierShortName;

    @Column("COUNTRY_CODE")
    private String countryCode;

    @Column("CITY_CODE")
    private String cityCode;

    @Column("CITY_NAME")
    private String cityName;

    @Column("SUPPLIER_TYPE")
    private String supplierType;

    @Column("ADDRESS")
    private String address;

    @Column("IS_OPEN")
    private String isOpen;

    @Column("CONTACT_PERSON")
    private String contactPerson;

    @Column("PHONE")
    private String phone;

    @Column("EMAIL")
    private String email;

    @Column("CREATED_DATE")
    private LocalDateTime createdDate;

    @Column("MODIFIED_DATE")
    private LocalDateTime modifiedDate;
}