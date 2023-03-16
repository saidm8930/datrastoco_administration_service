package com.datrastoco.administration_service.enterprises.services;

import com.datrastoco.administration_service.enterprises.entities.Enterprise;
import com.datrastoco.administration_service.enterprises.repositories.EnterpriseRepository;
import com.datrastoco.administration_service.users.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseServiceImpl implements EnterpriseService{

    @Autowired
    EnterpriseRepository enterpriseRepository;

//  CREATE ENTERPRISE
    @Override
    public Enterprise createEnterprise(Enterprise enterprise) {
        return enterpriseRepository.save(enterprise);
    }

//  GET ENTERPRISE LIST
    @Override
    public List<Enterprise> getEnterprises() {
        return enterpriseRepository.findAll();
    }

//  UPDATE ENTERPRISE
    @Override
    public Enterprise updateEnterprise(Integer enterpriseId, Enterprise enterpriseDetails) {

        Enterprise enterprise = enterpriseRepository.findById(enterpriseId).get();
        enterprise.setName(enterpriseDetails.getName());
        enterprise.setRegion(enterpriseDetails.getRegion());
        enterprise.setDistrict(enterpriseDetails.getDistrict());
        enterprise.setWard(enterpriseDetails.getWard());
        enterprise.setStreet(enterpriseDetails.getStreet());
        enterprise.setLocation(enterpriseDetails.getLocation());
        enterprise.setPhone_1(enterpriseDetails.getPhone_1());
        enterprise.setPhone_2(enterpriseDetails.getPhone_2());

        return enterpriseRepository.save(enterprise);
    }

//  DELETE ENTERPRISE
    @Override
    public Enterprise deleteEnterprise(Integer enterpriseId, Enterprise enterpriseDetails) {

        Enterprise enterprise = enterpriseRepository.findById(enterpriseId).get();
        enterprise.setStatus(enterpriseDetails.getStatus());

        return enterpriseRepository.save(enterprise);
    }


//  GET ENTERPRISE
    @Override
    public Enterprise getEnterprise(Integer enterpriseId) {
        Optional<Enterprise> enterprise = enterpriseRepository.findById(enterpriseId);
        if(enterprise.isPresent()){
            return enterprise.get();
        } throw new RuntimeException("User is not found for id:" + enterpriseId);
    }
}
