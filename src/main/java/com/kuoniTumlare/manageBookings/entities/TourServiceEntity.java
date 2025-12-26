package com.kuoniTumlare.manageBookings.entities;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("tour_services_cacbda9caa8d")
@Getter @Setter
public class TourServiceEntity {

    @Id
    private String id;

    @Column("ref_number")
    private String refNumber;

    @Column("sort_order")
    private String sortOrder;

    @Column("country_code")
    private String countryCode;

    @Column("city_name")
    private String cityName;

    @Column("start_time")
    private String startTime;

    @Column("end_time")
    private String endTime;

    @Column("supplier_name")
    private String supplierName;

    @Column("service_name")
    private String serviceName;

    @Column("supp_type")
    private String suppType;

    @Column("p_price")
    private String pPrice;

    @Column("g_price")
    private String gPrice;

    private String currency;
}

