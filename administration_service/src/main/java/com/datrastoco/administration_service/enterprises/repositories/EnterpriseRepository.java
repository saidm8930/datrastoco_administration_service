package com.datrastoco.administration_service.enterprises.repositories;

import com.datrastoco.administration_service.enterprises.entities.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository <Enterprise, Integer> {
}
