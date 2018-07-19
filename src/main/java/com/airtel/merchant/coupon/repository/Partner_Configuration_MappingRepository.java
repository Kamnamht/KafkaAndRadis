package com.airtel.merchant.coupon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.airtel.merchant.coupon.dto.Partner_Configuration_Mapping;

@Repository
public interface Partner_Configuration_MappingRepository extends CrudRepository<Partner_Configuration_Mapping, String> {

}
