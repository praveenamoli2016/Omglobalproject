package com.omglobal.omglobal.model.request;

import lombok.Data;

import javax.persistence.Column;

@Data
public class QuotationRequest {
    private Long id;
    private Long customerId;
    private Long warehouseId;
    private Long quotationCode;
    private String quotationDate;
    private String expireDate;
    private String referenceNo;
    private int quantity;
    private Double otherCharges;
    private Double discountOnAll;
    private Double subTotal;
    private Double roundOff;
    private String createdBy;
    private Double grandTotal;
    private Double priviousDue;
    private String note;

}
