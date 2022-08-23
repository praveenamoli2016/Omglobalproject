package com.omglobal.omglobal.service.impl;

import com.omglobal.omglobal.model.entities.Supplier;
import com.omglobal.omglobal.model.request.SupplierRequest;
import com.omglobal.omglobal.model.request.dto.SupplierRequestDTO;
import com.omglobal.omglobal.model.response.Response;
import com.omglobal.omglobal.repository.SupplierRepo;
import com.omglobal.omglobal.service.SupplierService;
import com.omglobal.omglobal.utility.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    @Override
    public Response addSupplier(SupplierRequest supplierRequest) {
        Response response = null;
        try {
            List<SupplierRequestDTO> supplierRequestList = supplierRequest.getSupplierRequestDTOS();
            List<Supplier> supplierList = new ArrayList<>();
            supplierRequestList.forEach(supplierRequestDTO -> {
                Optional<Supplier> supplierOptional = Optional.empty();
                Supplier supplier = null;
                //checking id is present or not
                if (supplierRequestDTO.getId() != null)
                    //finding customer using id from DB
                    supplierOptional = supplierRepo.findById(supplierRequestDTO.getId());

                //checking supplier is present or not
                if (supplierOptional.isPresent()) { //updating existing customer
                    supplier = supplierOptional.get();
                    supplier.setUpdatedAt(LocalDateTime.now().toString());
                } else { //creating new customer
                    supplier = new Supplier();
                    supplier.setCreatedAt(LocalDateTime.now().toString());
                }
                //setting all common fields
                supplier.setName(supplierRequestDTO.getName());
                supplier.setAddress(supplierRequestDTO.getAddress());
                supplier.setCity(supplierRequestDTO.getCity());
                supplier.setIsDeleted(supplierRequestDTO.getIsDeleted() != null ? supplierRequestDTO.getIsDeleted() : false);
                supplier.setStatus(supplierRequestDTO.getStatus() != null ? supplierRequestDTO.getStatus() : Status.ACTIVE);
                supplier.setCountry(supplierRequestDTO.getCountry());
                supplier.setEmail(supplierRequestDTO.getEmail());
                supplier.setMobileNumber(supplierRequestDTO.getMobileNumber());
                supplier.setGstNumber(supplierRequestDTO.getGstNumber());
                supplier.setOpeningBalance(supplierRequestDTO.getOpeningBalance());
                supplier.setPostCode(supplierRequestDTO.getPostCode());
                supplier.setState(supplierRequestDTO.getState());
                supplier.setTaxNumber(supplierRequestDTO.getTaxNumber());

                //saving customer in list
                supplierList.add(supplier);
            });
            //saving list of supplier in database
            List<Supplier> savedList = supplierRepo.saveAll(supplierList);
            response = new Response("Success", "200", "Supplier saved successfully", savedList);
        } catch (Exception exception) {
            response = new Response("Failure", "500", exception.getMessage(), null);
        }
        return response;
    }

    @Override
    public Response getSupplier(Long supplierId) {
        Response response=null;
        try {
            Optional<Supplier> supplierOptional=supplierRepo.findById(supplierId);
            if (supplierOptional.isPresent()) {
                Supplier supplier = supplierOptional.get();
                response = new Response("Success", "200", "Get Supplier successfully", supplier);
            }
            else {
                response = new Response("Failure", "404", "Supplier not found ", null);

            }
        }catch (Exception exception){
            response=new Response("Failure","500",exception.getMessage(),null);

        }
        return response;
    }

    @Override
    public Response getAllSupplier() {
        Response response=null;
        try {
            List<Supplier> supplierList=supplierRepo.findAll();
            response=new Response("Success","200","SupplierList fetched Successfully",supplierList);
        }catch (Exception exception){
            response=new Response("Failure","500", exception.getMessage(), null);
        }
        return response;
    }
}
