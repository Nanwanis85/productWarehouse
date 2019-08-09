package com.product.warehouse.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.warehouse.model.ProductWareHouseReciept;

@Repository
public interface ProductWareHouseRecieptRepository extends JpaRepository<ProductWareHouseReciept, UUID> {
      
	List<ProductWareHouseReciept> findAllByProductProductColor(String productColor);
	
	ProductWareHouseReciept findByProductProductCode(String productCode);
	
	List<ProductWareHouseReciept> findAllBySold(boolean sold);
	
	ProductWareHouseReciept findByRackSlotNo(int slotNo);
	
}
