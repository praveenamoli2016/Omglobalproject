package com.omglobal.omglobal.controller;

import com.omglobal.omglobal.model.request.CustomerPaymentRequest;
import com.omglobal.omglobal.model.request.CustomerRequest;
import com.omglobal.omglobal.model.request.QuotationRequest;
import com.omglobal.omglobal.model.response.Response;
import com.omglobal.omglobal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    public Response addCustomer(@RequestBody CustomerRequest customerRequest){
        return this.customerService.addCustomer(customerRequest);
    }

    @GetMapping("/getCustomer")
    public Response getCustomer(@RequestParam Long customerId){
        return this.customerService.getCustomer(customerId);
    }

    @GetMapping("/getAllCustomer")
    public Response getAllCustomer(@RequestParam(defaultValue = "") String searchValue, @RequestParam(defaultValue = "0") Integer pageNumber ,
                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                   @RequestParam(defaultValue = "customer_name") String sortBy,
                                   @RequestParam(value = "sortDtr",defaultValue = "asc",required = false)String sortDir) {
        return this.customerService.getAllCustomer(searchValue, pageNumber, pageSize, sortBy,sortDir);
    }

    @PostMapping("/addAdvance")
    public Response addAdvance(@RequestBody CustomerPaymentRequest customerPaymentRequest){
        return this.customerService.addAdvance(customerPaymentRequest);
    }

    @GetMapping("/getAllCustomerAdvancePayment")
    public Response getAllCustomerAdvancePayment(@RequestParam(value = "searchValue",defaultValue = "",required = false)String searchValue,
                                                 @RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
                                                 @RequestParam(value="pageSize",defaultValue="10",required = false) Integer pageSize,
                                                 @RequestParam(value ="sortBy",defaultValue = "",required = false) String sortBy,
                                                 @RequestParam(value = "sortDtr",defaultValue = "asc",required = false)String sortDir){
        return this.customerService.getAllCustomerAdvancePayment(searchValue,pageNumber,pageSize,sortBy,sortDir);
    }


    @PostMapping("/addQuatation")
    public Response addQuotation(@RequestBody QuotationRequest quotationRequest){
        return this.customerService.addQuotation(quotationRequest);
    }

    @GetMapping("/getAllQuotationList")
    public Response getAllQuotationList(Long warehouseId,String fromDate,String toDate,Long customerId) {
        return this.customerService.getAllQuotationList(warehouseId, fromDate,toDate,customerId);
    }


}
