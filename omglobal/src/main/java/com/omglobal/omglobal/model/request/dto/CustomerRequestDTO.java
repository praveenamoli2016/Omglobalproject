package com.omglobal.omglobal.model.request.dto;

import com.omglobal.omglobal.utility.enums.PriceLevelType;
import com.omglobal.omglobal.utility.enums.Status;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
public class CustomerRequestDTO {
    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private String phoneNumber;
    private String gstNumber;
    private String taxNumber;
    private Double creditLimit;
    private String priviousdue;
    private Double openingBalance;
    private String country;
    private String state;
    private String city;
    private Long postCode;
    private String locationLink;
    private String address;
    private String shippingCountry;
    private String shippingState;
    private String shippingCity;
    private Long shippingPostCode;
    private String shippingLocationLink;
    private String shippingAddress;
    private Boolean isDeleted;
    private Status status;
    private Double priceLevel;

}
