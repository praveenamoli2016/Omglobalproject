package com.omglobal.omglobal.model.request;

import com.omglobal.omglobal.utility.enums.Status;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class WarehouseRequest {

    private String name;
    private String email;
    private String mobileNumber;
    private Status status=Status.ACTIVE;
    private Boolean isDeleted;

}
