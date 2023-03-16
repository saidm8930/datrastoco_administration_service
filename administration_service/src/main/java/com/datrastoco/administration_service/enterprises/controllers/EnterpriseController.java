package com.datrastoco.administration_service.enterprises.controllers;

import com.datrastoco.administration_service.enterprises.entities.Enterprise;
import com.datrastoco.administration_service.enterprises.services.EnterpriseServiceImpl;
import com.datrastoco.administration_service.users.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class EnterpriseController {


    @Autowired
    private EnterpriseServiceImpl enterpriseServiceImpl;

//  CREATE ENTERPRISE........................................

    @RequestMapping(value="/v1/enterprises", method= RequestMethod.POST)
    public Enterprise createEnterprise(@RequestBody Enterprise enterprise) {
        return enterpriseServiceImpl.createEnterprise(enterprise);
    }

//  GET ENTERPRISES .........................................

    @RequestMapping(value="/v1/enterprises", method=RequestMethod.GET)
    public List<Enterprise> readEnterprises() {
        return enterpriseServiceImpl.getEnterprises();
    }

//  GET ENTERPRISE ..........................................

    @RequestMapping(value = "/v1/enterprises/{enterpriseId}", method = RequestMethod.GET)
    public Enterprise getEnterprise(@PathVariable(value = "enterpriseId") Integer id){
        return enterpriseServiceImpl.getEnterprise(id);
    }

//  UPDATE ENTERPRISE........................................

    @RequestMapping(value="/v1/enterprises/{enterpriseId}", method=RequestMethod.PUT)
    public Enterprise updateEnterprise(@PathVariable(value = "enterpriseId") Integer id, @RequestBody Enterprise enterpriseDetails) {
        return enterpriseServiceImpl.updateEnterprise(id, enterpriseDetails);
    }

//  DELETE ENTERPRISE..............................

    @RequestMapping(value="/v1/deleteEnterprise/{enterpriseId}", method=RequestMethod.PUT)
    public Enterprise deleteEnterprise(@PathVariable(value = "enterpriseId") Integer id, @RequestBody Enterprise enterpriseDetails) {
        return enterpriseServiceImpl.deleteEnterprise(id, enterpriseDetails);
    }

}
