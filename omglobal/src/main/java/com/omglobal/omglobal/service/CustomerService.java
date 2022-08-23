package com.omglobal.omglobal.service;

import com.omglobal.omglobal.model.request.CustomerPaymentRequest;
import com.omglobal.omglobal.model.request.CustomerRequest;
import com.omglobal.omglobal.model.request.QuotationRequest;
import com.omglobal.omglobal.model.response.Response;

public interface CustomerService {

    Response addCustomer(CustomerRequest customerRequest);

    Response getCustomer(Long customerId);

    Response getAllCustomer(String searchValue, Integer pageNumber, Integer pageSize, String sortBy,String sortDir);

    Response addAdvance(CustomerPaymentRequest customerPaymentRequest);

    Response getAllCustomerAdvancePayment(String searchValue,Integer pageNumber,Integer pageSize,String sortBy,String sortDir);

    Response addQuotation(QuotationRequest quotationRequest);

    Response getAllQuotationList(Long warehouseId,String fromDate,String toDate,Long customerId);
}
