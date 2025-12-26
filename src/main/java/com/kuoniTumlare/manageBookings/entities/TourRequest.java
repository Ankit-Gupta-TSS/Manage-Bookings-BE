package com.kuoniTumlare.manageBookings.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Table("TOUR_REQUESTS_CACBDA9CAA8D")
public class TourRequest {

    @Id
    private String tourId;

    private String tourRequestNo;
    private String tourName;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}