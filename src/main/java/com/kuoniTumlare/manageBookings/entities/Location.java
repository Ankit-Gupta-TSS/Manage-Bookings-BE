package com.kuoniTumlare.manageBookings.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "LOCATIONS_CACBDA9CAA8D")
public class Location {

    @Id
    @Column("LOCATION_ID")
    private String locationId;

    @Column("NAME")
    private String name;

    @Column("CODE")
    private String code;

    @Column("COUNTRY_CODE")
    private String countryCode;

    @Column("CREATED_DATE")
    private LocalDateTime createdDate;

    @Column("MODIFIED_DATE")
    private LocalDateTime modifiedDate;
}