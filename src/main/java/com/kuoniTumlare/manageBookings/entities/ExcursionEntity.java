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
@Table(name = "tour_excursions_cacbda9caa8d")
public class ExcursionEntity {
    @Id
    @Column("EXCURSION_ID")
    private String excursionId;

    @Column("CITY_NAME")
    private String cityName;

    @Column("CITY_CODE")
    private String cityCode;

    @Column("TITLE")
    private String title;

    @Column("DEPARTURE_PLACE")
    private String departurePlace;

    @Column("DESCRIPTION")
    private String description;

    @Column("IMPORTANT_NOTE")
    private String importantNote;

    @Column("IS_SELECTED")
    private String isSelected;

    @Column("DURATION_HOURS")
    private BigDecimal durationHours;

    @Column("CREATED_DATE")
    private LocalDateTime createdDate;

    @Column("MODIFIED_DATE")
    private LocalDateTime modifiedDate;
}