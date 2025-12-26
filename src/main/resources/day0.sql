ALTER SESSION SET CURRENT_SCHEMA = MYBUS_JPMRN_TEST;


CREATE TABLE CITY_cacbda9caa8d
(
    id   VARCHAR2(36)  NOT NULL,
    name VARCHAR2(255) NOT NULL,
    CONSTRAINT PK_CITY_cacbda9caa8d PRIMARY KEY (ID)
);

CREATE TABLE countries_cacbda9caa8d
(
    country_id    VARCHAR2(36) PRIMARY KEY,
    country_name  VARCHAR2(100) NOT NULL,
    country_code  VARCHAR2(2)   NOT NULL UNIQUE,
    region        VARCHAR2(50),
    is_active     CHAR(1)   DEFAULT 'Y',
    created_date  TIMESTAMP DEFAULT SYSTIMESTAMP,
    modified_date TIMESTAMP DEFAULT SYSTIMESTAMP,
    CONSTRAINT chk_country_code_format CHECK (LENGTH(country_code) = 2),
    CONSTRAINT chk_is_active_cacbda9caa8d CHECK (is_active IN ('Y', 'N'))
);

CREATE INDEX idx_countries_code ON countries_cacbda9caa8d (country_code);



CREATE TABLE locations_cacbda9caa8d
(
    location_id   VARCHAR2(36) PRIMARY KEY,
    name          VARCHAR2(100) NOT NULL,
    code          VARCHAR2(10)  NOT NULL UNIQUE,
    country_code  VARCHAR2(2)   NOT NULL,
    created_date  TIMESTAMP DEFAULT SYSTIMESTAMP,
    modified_date TIMESTAMP DEFAULT SYSTIMESTAMP,
    CONSTRAINT chk_loc_code_len_cacbda9caa8d CHECK (LENGTH(code) <= 10)
);

ALTER TABLE locations_cacbda9caa8d
    ADD CONSTRAINT fk_location_country
        FOREIGN KEY (country_code)
            REFERENCES countries_cacbda9caa8d (country_code);



CREATE TABLE tour_requests_cacbda9caa8d
(
    tour_id         VARCHAR2(36) PRIMARY KEY,
    tour_request_no VARCHAR2(20)  NOT NULL UNIQUE,
    tour_name       VARCHAR2(500) NOT NULL,
    status          VARCHAR2(20) DEFAULT 'ACTIVE',
    created_date    TIMESTAMP    DEFAULT SYSTIMESTAMP,
    modified_date   TIMESTAMP    DEFAULT SYSTIMESTAMP,
    CONSTRAINT chk_tour_status_cacbda9caa8d
        CHECK (status IN ('ACTIVE', 'INACTIVE', 'COMPLETED', 'CANCELLED'))
);



CREATE TABLE service_details_cacbda9caa8d
(
    service_id    VARCHAR2(36) PRIMARY KEY,
    sort_order    NUMBER(10)    NOT NULL,
    country_code  VARCHAR2(2)   NOT NULL,
    city_name     VARCHAR2(100) NOT NULL,
    start_time    VARCHAR2(5),
    end_time      VARCHAR2(5),
    supplier_name VARCHAR2(200),
    service_name  VARCHAR2(500),
    supp_type     VARCHAR2(10),
    p_price       NUMBER(10, 2) DEFAULT 0,
    g_price       NUMBER(10, 2) DEFAULT 0,
    currency      VARCHAR2(3)   DEFAULT 'EUR',
    created_date  TIMESTAMP     DEFAULT SYSTIMESTAMP,
    modified_date TIMESTAMP     DEFAULT SYSTIMESTAMP,
    CONSTRAINT chk_prices_cacbda9caa8d CHECK (p_price >= 0 AND g_price >= 0)
);


ALTER TABLE service_details_cacbda9caa8d
    ADD CONSTRAINT fk_service_country
        FOREIGN KEY (country_code)
            REFERENCES countries_cacbda9caa8d (country_code);


CREATE TABLE tour_excursions_cacbda9caa8d
(
    excursion_id    VARCHAR2(36) PRIMARY KEY,
    city_name       VARCHAR2(100) NOT NULL,
    city_code       VARCHAR2(10)  NOT NULL,
    title           VARCHAR2(500) NOT NULL,
    departure_place VARCHAR2(500),
    description     CLOB,
    important_note  CLOB,
    is_selected     CHAR(1)   DEFAULT 'N',
    duration_hours  NUMBER(5, 2),
    created_date    TIMESTAMP DEFAULT SYSTIMESTAMP,
    modified_date   TIMESTAMP DEFAULT SYSTIMESTAMP,
    CONSTRAINT chk_excursion_selected CHECK (is_selected IN ('Y', 'N'))
);



CREATE TABLE suppliers_cacbda9caa8d
(
    supplier_id         VARCHAR2(36) PRIMARY KEY,
    supplier_code       VARCHAR2(20)  NOT NULL UNIQUE,
    supplier_short_name VARCHAR2(200) NOT NULL,
    country_code        VARCHAR2(2)   NOT NULL,
    city_code           VARCHAR2(10)  NOT NULL,
    city_name           VARCHAR2(100) NOT NULL,
    supplier_type       VARCHAR2(10)  NOT NULL,
    address             VARCHAR2(500),
    is_open             CHAR(1)   DEFAULT 'Y',
    contact_person      VARCHAR2(100),
    phone               VARCHAR2(50),
    email               VARCHAR2(100),
    created_date        TIMESTAMP DEFAULT SYSTIMESTAMP,
    modified_date       TIMESTAMP DEFAULT SYSTIMESTAMP,
    CONSTRAINT chk_supplier_open_cacbda9caa8d CHECK (is_open IN ('Y', 'N'))
);

ALTER TABLE suppliers_cacbda9caa8d
    ADD CONSTRAINT fk_supplier_country
        FOREIGN KEY (country_code)
            REFERENCES countries_cacbda9caa8d (country_code);



CREATE TABLE supplier_services_cacbda9caa8d
(
    service_id    VARCHAR2(36) PRIMARY KEY,
    supplier_code VARCHAR2(20)  NOT NULL,
    service_name  VARCHAR2(500) NOT NULL,
    service_code  VARCHAR2(50),
    price         NUMBER(10, 2) DEFAULT 0,
    currency      VARCHAR2(3)   DEFAULT 'EUR',
    description   CLOB,
    is_active     CHAR(1)       DEFAULT 'Y',
    created_date  TIMESTAMP     DEFAULT SYSTIMESTAMP,
    modified_date TIMESTAMP     DEFAULT SYSTIMESTAMP
);

ALTER TABLE supplier_services_cacbda9caa8d
    ADD CONSTRAINT fk_supplier_services_supplier
        FOREIGN KEY (supplier_code)
            REFERENCES suppliers_cacbda9caa8d (supplier_code);



CREATE TABLE itinerary_options_cacbda9caa8d
(
    option_id       VARCHAR2(36) PRIMARY KEY,
    tour_request_no VARCHAR2(20),
    abbreviation    VARCHAR2(50) NOT NULL,
    package_text    CLOB         NOT NULL,
    day_number      NUMBER(3),
    sort_order      NUMBER(5),
    is_selected     CHAR(1)   DEFAULT 'N',
    created_date    TIMESTAMP DEFAULT SYSTIMESTAMP,
    modified_date   TIMESTAMP DEFAULT SYSTIMESTAMP
);

ALTER TABLE itinerary_options_cacbda9caa8d
    ADD CONSTRAINT fk_pkg_option_tour
        FOREIGN KEY (tour_request_no)
            REFERENCES tour_requests_cacbda9caa8d (tour_request_no);


CREATE TABLE itinerary_day_cacbda9caa8d
(
    itinerary_service_id VARCHAR2(36) PRIMARY KEY,
    tour_request_no      VARCHAR2(20),
    option_name          VARCHAR2(50)  NOT NULL,
    day_number           NUMBER(3)     NOT NULL,
    sort_order           NUMBER(10)    NOT NULL,
    country_code         VARCHAR2(2)   NOT NULL,
    city_name            VARCHAR2(100) NOT NULL,
    start_time           VARCHAR2(5),
    end_time             VARCHAR2(5),
    supp_short_name      VARCHAR2(200),
    service_name         VARCHAR2(500) NOT NULL,
    supp_type            VARCHAR2(10),
    p_price              NUMBER(10, 2) DEFAULT 0,
    g_price              NUMBER(10, 2) DEFAULT 0,
    currency             VARCHAR2(3)   DEFAULT 'EUR',
    is_selected          CHAR(1)       DEFAULT 'Y',
    is_open              CHAR(1)       DEFAULT 'N',
    created_date         TIMESTAMP     DEFAULT SYSTIMESTAMP,
    modified_date        TIMESTAMP     DEFAULT SYSTIMESTAMP
);

ALTER TABLE itinerary_day_cacbda9caa8d
    ADD CONSTRAINT fk_itin_tour
        FOREIGN KEY (tour_request_no)
            REFERENCES tour_requests_cacbda9caa8d (tour_request_no);
