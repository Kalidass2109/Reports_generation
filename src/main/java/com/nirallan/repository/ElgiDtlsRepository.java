package com.nirallan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nirallan.entity.EligibilityDtlsEntity;

public interface ElgiDtlsRepository extends JpaRepository<EligibilityDtlsEntity, Integer>{
	
	@Query(value="select distinct(PLAN_NAME) from ELIGIBILITY_DTLS",nativeQuery = true)
	public List<String> getUniquePlans();
	
	@Query(value="select distinct(PLAN_STATUS) from ELIGIBILITY_DTLS",nativeQuery = true)
	public List<String> getUniqueStatus();

}
