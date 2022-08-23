package com.omglobal.omglobal.service;

import com.omglobal.omglobal.model.entities.Role;
import com.omglobal.omglobal.model.response.Response;

public interface UtilityService {
    Response createRole(String roleName);
}
