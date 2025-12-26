package com.kuoniTumlare.manageBookings.service;

import com.kuoniTumlare.manageBookings.repository.SupplierRepository;
import com.kuoniTumlare.manageBookings.repository.SupplierServiceRepository;
import com.kuoniTumlare.manageBookings.response.SupplierDTO;
import com.kuoniTumlare.manageBookings.response.SupplierServiceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierQueryService {

    private final SupplierRepository supplierRepo;
    private final SupplierServiceRepository serviceRepo;

    public Flux<SupplierDTO> getByCities(List<String> cityCodes) {
        return supplierRepo.findByCityCodes(cityCodes)
                .flatMap(supplier ->
                        serviceRepo.findBySupplierCode(supplier.getSupplierCode())
                                .map(ss -> SupplierServiceDTO.builder()
                                        .serviceId(Integer.valueOf(ss.getServiceId()))
                                        .serviceName(ss.getServiceName())
                                        .price(ss.getPrice())
                                        .build())
                                .collectList()
                                .map(services -> SupplierDTO.builder()
                                        .countryCode(supplier.getCountryCode())
                                        .cityCode(supplier.getCityCode())
                                        .cityName(supplier.getCityName())
                                        .suppType(supplier.getSupplierType())
                                        .suppShortName(supplier.getSupplierShortName())
                                        .supplierId(supplier.getSupplierCode())
                                        .address(supplier.getAddress())
                                        .isOpen("Y".equals(supplier.getIsOpen()))
                                        .subitems(services)
                                        .build())
                );
    }
}

