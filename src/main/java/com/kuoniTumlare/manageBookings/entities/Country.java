package com.kuoniTumlare.manageBookings.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "COUNTRIES_CACBDA9CAA8D")
public class Country {
    @Id
    @Column("COUNTRY_ID")
    private String countryId;

    @Column("COUNTRY_NAME")
    private String countryName;

    @Column("COUNTRY_CODE")
    private String countryCode;

    @Column("REGION")
    private String region;

    @Column("IS_ACTIVE")
    private String isActive;

    @Column("CREATED_DATE")
    private LocalDateTime createdDate;

    @Column("MODIFIED_DATE")
    private LocalDateTime modifiedDate;
}