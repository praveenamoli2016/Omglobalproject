package com.omglobal.omglobal.controller;

import com.omglobal.omglobal.model.request.CustomerRequest;
import com.omglobal.omglobal.model.request.SupplierRequest;
import com.omglobal.omglobal.model.response.Response;
import com.omglobal.omglobal.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/addSupplier")
    public Response addSupplier(@RequestBody SupplierRequest supplierRequest){
        return this.supplierService.addSupplier(supplierRequest);
    }

    @GetMapping("/getSupplier")
    public Response getSupplier(@RequestParam Long supplierId){

        return this.supplierService.getSupplier(supplierId);
    }

    @GetMapping("/getAllSupplier")
    public Response getAllSupplier(){
        return this.supplierService.getAllSupplier();
    }
}
