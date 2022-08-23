package com.omglobal.omglobal.model.entities;

import com.omglobal.omglobal.utility.enums.PriceLevelType;
import com.omglobal.omglobal.utility.enums.Status;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "supplier_table")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "supplier_name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "gst_number")
    private String gstNumber;

    @Column(name = "tax_number")
    private String taxNumber;

    @Column(name = "opening_balance")
    private Double openingBalance;

    @Column(name = "country_name")
    private String country;

    @Column(name = "state_name")
    private String state;

    @Column(name = "city_name")
    private String city;

    @Column(name = "post_code")
    private Long postCode;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status=Status.ACTIVE;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;


}
