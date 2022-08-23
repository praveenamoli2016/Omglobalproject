package com.omglobal.omglobal.model.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "quotation")
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JsonIdentityReference(alwaysAsId=true)
    @ManyToOne
    @JoinColumn (name = "customer_id")
    private Customer customer;

    @JsonIdentityReference(alwaysAsId=true)
    @ManyToOne
    @JoinColumn (name = "warehouse_id")
    private Warehouse warehouse;

    @Column(name = "quotation_code")
    private Long quotationCode;

    @Column(name = "quotation_date")
    private String quotationDate;

    @Column(name = "expire_date")
    private String expireDate;

    @Column(name = "reference_no")
    private String referenceNo;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "other_charges")
    private Double otherCharges;

    @Column(name = "discount_on_all")
    private Double discountOnAll;

    @Column(name = "sub_total")
    private Double subTotal;

    @Column(name = "round_off")
    private Double roundOff;

    @Column(name = "grand_total")
    private Double grandTotal;

    @Column(name = "privious_due")
    private Double priviousDue;

    @Column(name = "note")
    private String note;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;




}
