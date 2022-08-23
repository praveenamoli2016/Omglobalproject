package com.omglobal.omglobal.service.impl;

import com.omglobal.omglobal.model.entities.Role;
import com.omglobal.omglobal.model.entities.User;
import com.omglobal.omglobal.model.response.Response;
import com.omglobal.omglobal.repository.RoleRepo;
import com.omglobal.omglobal.repository.UserRepo;
import com.omglobal.omglobal.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UtilityServiceImpl implements UtilityService {

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRepo userRepo;


//    public Response createRoles() {
//        Response response=null;
//        try {
//
//            Role role1 = new Role();
//            role1.setRoleName("ADMIN");
//            Role role2 = new Role();
//            role2.setRoleName("CUSTOMER");
//            Role role3 = new Role();
//            role3.setRoleName("SUPPLIER");
//            Set<Role> roleSet = new HashSet<>();
//            roleSet.add(role1);
//            roleSet.add(role2);
//            roleSet.add(role3);
//            User user = new User();
//            user.setRoleSet(roleSet);
//            User userRole = userRepo.save(user);
//       response=new Response("Success","200","UserRole set successfully",userRole);
//        } catch (Exception exception) {
//            response = new Response("Failure", "500", exception.getMessage(), null);
//
//        }
//        return response;
//    }

    @Override
    public Response createRole(String roleName) {
        Response response=null;
        try {
            Role userRole=new Role();
            userRole.setRoleName(roleName);
            Role setRole=roleRepo.save(userRole);
//            Role role1 = new Role();
//            role1.setRoleName("ADMIN");
//            Role role2 = new Role();
//            role2.setRoleName("CUSTOMER");
//            Role role3 = new Role();
//            role3.setRoleName("SUPPLIER");
//            Set<Role> roleSet = new HashSet<>();
//            roleSet.add(role1);
//            roleSet.add(role2);
//            roleSet.add(role3);
//            User user = new User();
//            user.setRoleSet(roleSet);
//            User userRole = userRepo.save(user);
            response=new Response("Success","200","UserRole set successfully",setRole);

        }catch (Exception exception){
            response = new Response("Failure", "500", exception.getMessage(), null);

        }
        return response;
    }
}