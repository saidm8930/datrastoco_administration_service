package com.datrastoco.administration_service.enterprises.services;

import com.datrastoco.administration_service.enterprises.entities.Enterprise;

import java.util.List;

public interface EnterpriseService {

    //  CREATE ENTERPRISE......................................
    Enterprise createEnterprise(Enterprise enterprise);

    //  GET LIST ENTERPRISES...................................
    List<Enterprise> getEnterprises();

    //  UPDATE ENTERPRISE.......................................
    Enterprise updateEnterprise(Integer enterpriseId, Enterprise enterpriseDetails);

    //  DELETE ENTERPRISE
    Enterprise deleteEnterprise(Integer enterpriseId, Enterprise enterpriseDetails);

    //  GET ENTERPRISE
    Enterprise getEnterprise(Integer enterpriseId);
}
