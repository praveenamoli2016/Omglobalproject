package com.omglobal.omglobal.model.request;

import com.omglobal.omglobal.utility.enums.PaymentType;
import com.omglobal.omglobal.utility.enums.Status;
import lombok.Data;

@Data
public class CustomerPaymentRequest {

    private Long id;
    private Long customerId;
    private Double amount;
    private PaymentType paymentType;
    private String date;
    private String note;
    private Status status;

}
