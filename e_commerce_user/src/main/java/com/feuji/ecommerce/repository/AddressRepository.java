package com.feuji.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feuji.ecommerce.dto.UserAddress;



public interface AddressRepository extends JpaRepository<UserAddress, Integer> {

}
