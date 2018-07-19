package com.airtel.merchant.coupon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.airtel.merchant.coupon.dto.PartnerIdErroCode;
import com.airtel.merchant.coupon.dto.Partner_TextMessage_Mapping;

@Repository
public interface Partner_TextMessage_MappingRepository extends CrudRepository<Partner_TextMessage_Mapping, PartnerIdErroCode> {

}
