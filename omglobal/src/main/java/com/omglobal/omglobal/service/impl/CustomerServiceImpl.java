package com.omglobal.omglobal.service.impl;

import com.omglobal.omglobal.model.entities.Customer;
import com.omglobal.omglobal.model.entities.CustomerPayment;
import com.omglobal.omglobal.model.entities.Quotation;
import com.omglobal.omglobal.model.entities.Warehouse;
import com.omglobal.omglobal.model.request.CustomerPaymentRequest;
import com.omglobal.omglobal.model.request.CustomerRequest;
import com.omglobal.omglobal.model.request.QuotationRequest;
import com.omglobal.omglobal.model.request.dto.CustomerRequestDTO;
import com.omglobal.omglobal.model.response.Response;
import com.omglobal.omglobal.repository.CustomerPaymentRepo;
import com.omglobal.omglobal.repository.CustomerRepo;
import com.omglobal.omglobal.repository.QuotationRepo;
import com.omglobal.omglobal.repository.WarehouseRepo;
import com.omglobal.omglobal.service.CustomerService;
import com.omglobal.omglobal.utility.enums.Status;
import org.hibernate.boot.model.relational.QualifiedTableName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerPaymentRepo customerPaymentRepo;

    @Autowired
    private QuotationRepo quotationRepo;

    @Autowired
    private WarehouseRepo warehouseRepo;

    @Override
    public Response addCustomer(CustomerRequest customerRequest) {
        Response response = null;
        try {
            List<CustomerRequestDTO> customerRequestList = customerRequest.getCustomerRequestDTOS();
            List<Customer> customerList = new ArrayList<>();
            /*for(CustomerRequestDTO customerRequestDTO : customerRequestList){

            }*/
            customerRequestList.forEach(customerRequestDTO -> {
                Optional<Customer> customerOptional = Optional.empty();
                Customer customer = null;
                //checking id is present or not
                if (customerRequestDTO.getId() != null)
                    //finding customer using id from DB
                    customerOptional = customerRepo.findById(customerRequestDTO.getId());

                //checking customer is present or not
                if (customerOptional.isPresent()) { //updating existing customer
                    customer = customerOptional.get();
                    customer.setUpdatedAt(LocalDateTime.now().toString());
                } else { //creating new customer
                    customer = new Customer();
                    customer.setCreatedAt(LocalDateTime.now().toString());
                }
                //setting all common fields
                customer.setName(customerRequestDTO.getName());
                customer.setAddress(customerRequestDTO.getAddress());
                customer.setCity(customerRequestDTO.getCity());
                customer.setIsDeleted(customerRequestDTO.getIsDeleted() != null ? customerRequestDTO.getIsDeleted() : false);
                customer.setStatus(customerRequestDTO.getStatus() != null ? customerRequestDTO.getStatus() : Status.ACTIVE);
                customer.setCountry(customerRequestDTO.getCountry());
                customer.setCreditLimit(customerRequestDTO.getCreditLimit());
                customer.setEmail(customerRequestDTO.getEmail());
                customer.setMobileNumber(customerRequestDTO.getMobileNumber());
                customer.setPhoneNumber(customerRequestDTO.getPhoneNumber());
                customer.setGstNumber(customerRequestDTO.getTaxNumber());
                customer.setPriviousdue(customerRequestDTO.getPriviousdue());
                customer.setLocationLink(customerRequestDTO.getLocationLink());
                customer.setOpeningBalance(customerRequestDTO.getOpeningBalance());
                customer.setPostCode(customerRequestDTO.getPostCode());
                customer.setShippingAddress(customerRequestDTO.getShippingAddress());
                customer.setShippingCountry(customerRequestDTO.getShippingCountry());
                customer.setShippingCity(customerRequestDTO.getShippingCity());
                customer.setShippingLocationLink(customerRequestDTO.getShippingLocationLink());
                customer.setShippingPostCode(customerRequestDTO.getShippingPostCode());
                customer.setShippingState(customerRequestDTO.getShippingState());
                customer.setState(customerRequestDTO.getState());
                customer.setTaxNumber(customerRequestDTO.getTaxNumber());
                customer.setPriceLevel(customerRequestDTO.getPriceLevel());

                //saving customer in list
                customerList.add(customer);
            });
            //saving list of customer in database
            List<Customer> savedList = customerRepo.saveAll(customerList);
            response = new Response("Success", "200", "Customer saved successfully", savedList);
        } catch (Exception exception) {
            response = new Response("Failure", "500", exception.getMessage(), null);
        }
        return response;
    }

    @Override
    public Response getCustomer(Long customerId) {
        Response response = null;
        try {
            Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
            if (optionalCustomer.isPresent()) {
                Customer customer = optionalCustomer.get();
                response = new Response("Success", "200", "Get Customer successfully", customer);

            } else {
                response = new Response("Failure", "404", "Customer not found ", null);

            }

        } catch (Exception exception) {
            response = new Response("Failure", "500", exception.getMessage(), null);

        }
        return response;

    }

    @Override
    public Response getAllCustomer(String searchValue, Integer pageNumber, Integer pageSize, String sortBy,String sortDir) {
        Response response = null;
        try {
            Pageable pageable = PageRequest.of(pageNumber,pageSize, sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending(): Sort.by(sortBy).descending());
            Page<Customer> customerData = customerRepo.searchCustomer(searchValue, pageable);
            List<Customer> customerList = customerData.getContent();
            response = new Response("Success", "200", "CustomerList fetched successfully", customerList);
        } catch (Exception exception) {
            response = new Response("Failure", "500", exception.getMessage(), null);
        }
        return response;
    }

    @Override
    public Response addAdvance(CustomerPaymentRequest customerPaymentRequest) {
        Response response=null;
        try {

            // fetching customer details
            Optional<CustomerPayment> optionalCustomerPayment = Optional.empty();

//            Optional<CustomerPayment> optionalCustomerPayment = Optional.empty();
//            Customer customer = null;
//            Optional<Customer> optionalCustomer=customerRepo.findById(customerPaymentRequest.getCustomerId());
            CustomerPayment customerPayment=null;
            if (customerPaymentRequest.getId() != null)
                //finding customer using id from DB
                optionalCustomerPayment = customerPaymentRepo.findById(customerPaymentRequest.getId());

            //checking customer is present or not
            if (optionalCustomerPayment.isPresent()) {
                //updating existing customer
                customerPayment = optionalCustomerPayment.get();
                customerPayment.setUpdatedAt(LocalDateTime.now().toString());
            } else {
                //creating new customer
                customerPayment = new CustomerPayment();
                customerPayment.setCreatedAt(LocalDateTime.now().toString());
            }
                //setting customer payment data
//                CustomerPayment customerPayment=new CustomerPayment();
            Optional<Customer> customerOptional = customerRepo.findById(customerPaymentRequest.getCustomerId());
            if (customerOptional.isPresent()) {
                customerPayment.setCustomer(customerOptional.get());
            } else
                throw new Exception("Customer not found");
            //setting all fields
            customerPayment.setAmount(customerPaymentRequest.getAmount());
            customerPayment.setDate(customerPaymentRequest.getDate());
            customerPayment.setNote(customerPaymentRequest.getNote());
            customerPayment.setPaymentType(customerPaymentRequest.getPaymentType());
            customerPayment.setStatus(customerPaymentRequest.getStatus());

            //saving data in database
            CustomerPayment savedCustomerPayment = customerPaymentRepo.save(customerPayment);
            response = new Response("Success", "200", "CustomerPayment saved successfully", savedCustomerPayment);
        } catch (Exception exception){
            response = new Response("Failure", "500", exception.getMessage(), null);
        }
        return response;
    }

    @Override
    public Response getAllCustomerAdvancePayment(String searchValue, Integer pageNumber,Integer pageSize,String sortBy,String sortDir) {
        Response response=null;
        try {
//            int pageSize=5;
//            int pageNumber=1;
            Sort sort=sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
//            Sort sort=null;
//            if (sortDir.equalsIgnoreCase("asc")){
//                sort=Sort.by(sortBy).ascending();
//            }
//            else {
//                sort=Sort.by(sortBy).ascending();
//            }
            //Sort sort = Sort.by(sortBy);
            Pageable p= PageRequest.of(pageNumber,pageSize,sort);
            Page<CustomerPayment> paymentPage=this.customerPaymentRepo.findAll(p);
            List<CustomerPayment> customerPaymentList=paymentPage.getContent();
           // List<CustomerPayment> customerPaymentList=customerPaymentRepo.findAll();
            response=new Response("Success","200","Customer paymentlist fetched successfully",customerPaymentList);
        } catch (Exception exception){
            response = new Response("Failure", "500", exception.getMessage(), null);
        }
        return response;
    }

    @Override
    public Response addQuotation(QuotationRequest quotationRequest) {
        Response response=null;
            try {
                Optional<Quotation> optionalQuotation=Optional.empty();
                Quotation quotation=null;
                if (quotationRequest.getId()!=null){
                    //finding customer using id from DB
                    optionalQuotation=quotationRepo.findById(quotation.getId());
                }
                //checking customer is present or not
                if (optionalQuotation.isPresent()) {
                    //updating existing customer
                    quotation = optionalQuotation.get();
                    quotation.setUpdatedAt(LocalDateTime.now().toString());
                } else {
                    //creating new customer
                    quotation = new Quotation();
                    quotation.setCreatedAt(LocalDateTime.now().toString());
                }
                //  fetching customer details
                Optional<Customer> optionalCustomer=customerRepo.findById(quotationRequest.getCustomerId());
                        if(optionalCustomer.isPresent()){
                         quotation.setCustomer(optionalCustomer.get());
                        }
                        else {

                            throw new Exception("Customer not found");
                        }
                        Optional<Warehouse> optionalWarehouse=warehouseRepo.findById(quotationRequest.getWarehouseId());
                        if (optionalCustomer.isPresent()){
                            quotation.setWarehouse(optionalWarehouse.get());
                        }
                        else {
                            throw new Exception("Warehouse not found");
                        }
                //setting all fields

                        quotation.setQuotationCode(quotationRequest.getQuotationCode());
                        quotation.setQuotationDate(quotationRequest.getQuotationDate());
                        quotation.setNote(quotationRequest.getNote());
                        quotation.setCreatedBy(quotationRequest.getCreatedBy());
                        quotation.setExpireDate(quotationRequest.getExpireDate());
                        quotation.setDiscountOnAll(quotationRequest.getDiscountOnAll());
                        quotation.setRoundOff(quotationRequest.getRoundOff());
                        quotation.setQuantity(quotationRequest.getQuantity());
                        quotation.setOtherCharges(quotationRequest.getOtherCharges());
                        quotation.setPriviousDue(quotationRequest.getPriviousDue());
                        quotation.setSubTotal(quotationRequest.getSubTotal());
                        quotation.setReferenceNo(quotationRequest.getReferenceNo());
                        quotation.setGrandTotal(quotationRequest.getGrandTotal());

                        Quotation savedQuotation=quotationRepo.save(quotation);

                        response=new Response("Success","200","Quotation saved successfully",savedQuotation);

        }catch (Exception exception){
                response = new Response("Failure", "500", exception.getMessage(), null);

            }
        return response;
    }

    @Override
    public Response getAllQuotationList(Long warehouseId,String fromDate,String toDate,Long customerId) {
        Response response=null;
        try {
            String query = "Select q from quotation q where ";

            if (warehouseId!=null && warehouseId>0){
                String warehouseQuery =  "warehouse_id = " + warehouseId;
                query = query + warehouseQuery;
            }

            if (customerId!=null && customerId>0){
                String customerQuery = "customer_id = "+customerId;
                if (query.length()>32)
                    query = query+ " and " + customerQuery;
                else
                    query = query+ customerQuery;
            }
            if (fromDate!=null){
                String fromDateQuery = "created_at >= '"+fromDate+"'";
                if (query.length()>32)
                    query = query+ " and " + fromDateQuery+"";
                else
                    query = query+ fromDateQuery;
            }
            if (toDate != null) {

                String toDateQuery = "created_at <= '" + toDate+"'";
                if (query.length()>32)
                    query = query+ " and " + toDateQuery;
                else
                    query = query + toDateQuery;
            }
            if (query.length()<=32){
                query = "select q from quotation q";
            }
            System.out.println(query);
            List<Quotation> quotationList = quotationRepo.findCustomNativeQuery(query);
            response = new Response("Success", "200", "Get QuotationList successfully", quotationList);
        }catch (Exception exception){
            response = new Response("Failure", "500", exception.getMessage(), null);
        }
        return response;
    }
}