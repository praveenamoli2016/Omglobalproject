package com.omglobal.omglobal.model.request.dto;

import com.omglobal.omglobal.utility.enums.Status;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
public class SupplierRequestDTO {


    private Long id;

    private String name;
    private String email;

    private String mobileNumber;

    private String gstNumber;

    private String taxNumber;
    private Double openingBalance;

    private String country;

    private String state;
    private String city;

    private Long postCode;

    private String address;
    private Status status;

    private Boolean isDeleted;


}
