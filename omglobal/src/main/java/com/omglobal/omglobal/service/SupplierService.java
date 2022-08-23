package com.omglobal.omglobal.service;

import com.omglobal.omglobal.model.request.SupplierRequest;
import com.omglobal.omglobal.model.response.Response;

public interface SupplierService {
    Response addSupplier(SupplierRequest supplierRequest);

    Response getSupplier(Long supplierId);

    Response getAllSupplier();
}
