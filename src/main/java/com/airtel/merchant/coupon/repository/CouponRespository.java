package com.airtel.merchant.coupon.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.airtel.merchant.coupon.dto.CouponDTO;
import com.airtel.merchant.coupon.dto.CustomerIdRefTxnIfId;


/**
 * Created by A1BRCQQX 29/03/2018
 */
@Repository
public interface CouponRespository extends CrudRepository<CouponDTO, CustomerIdRefTxnIfId>	{
	@Query("select couponDTO from CouponDTO couponDTO where couponDTO.customerIdRefTxnIfId.customerId = ?1")
	List<CouponDTO> findByCustomerId(String customerId);
	
	@Query("select couponDTO from CouponDTO couponDTO where couponDTO.customerIdRefTxnIfId.customerId = ?1 and couponDTO.statusCode = ?2 or couponDTO.statusCode = ?3")
	List<CouponDTO> findByCustomerIdAndStatusCodes(String customerId, String statusCode, String statusCode1);
	
	@Query("select couponDTO from CouponDTO couponDTO where couponDTO.customerIdRefTxnIfId.customerId = ?1 and couponDTO.customerIdRefTxnIfId.refTxnId = ?2 and couponDTO.customerIdRefTxnIfId.createdAt =?3")
	CouponDTO findByCustomerIdAndRefTxnIdAndRequestCreatedAt(String customerId, String refTxnId, Timestamp createdAt);
}
