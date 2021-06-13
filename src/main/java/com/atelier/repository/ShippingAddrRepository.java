package com.atelier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atelier.entity.ShippingAddrEntity;

@Repository
public interface ShippingAddrRepository extends JpaRepository<ShippingAddrEntity, Long>{

}
