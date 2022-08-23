package com.omglobal.omglobal.controller;

import com.omglobal.omglobal.model.entities.Role;
import com.omglobal.omglobal.model.request.QuotationRequest;
import com.omglobal.omglobal.model.response.Response;
import com.omglobal.omglobal.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utility")
public class UtilityController {

    @Autowired
    private UtilityService utilityService;

    @PostMapping("/createRole")
    public Response createRole(@RequestBody String roleName){
        return this.utilityService.createRole(roleName);
    }

}
