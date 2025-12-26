package com.kuoniTumlare.manageBookings.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("ITINERARY_OPTIONS_CACBDA9CAA8D")
public class ItineraryOption {

    @Id
    private String optionId;

    private String tourRequestNo;
    private String abbreviation;
    private String packageText;
}
