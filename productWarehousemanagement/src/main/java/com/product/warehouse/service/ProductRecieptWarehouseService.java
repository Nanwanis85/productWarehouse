package com.product.warehouse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.product.warehouse.exception.ProductWarehouseException;
import com.product.warehouse.model.ProductWareHouseReciept;
import com.product.warehouse.model.Rack;
import com.product.warehouse.repository.ProductWareHouseRecieptRepository;
import com.product.warehouse.repository.RackRepository;

@Service
public class ProductRecieptWarehouseService {
	@Autowired
	ProductWareHouseRecieptRepository productWareHouseRecieptRepository;
	
	@Autowired
	RackWarehouseService rackWareHouseService;
	
	public ProductWareHouseReciept generateReciept(ProductWareHouseReciept productReciept) throws ProductWarehouseException {
		List<Rack> rackList = rackWareHouseService.getEmptyRacks();
		ProductWareHouseReciept productWareHouseReciept;
		if(!CollectionUtils.isEmpty(rackList)) {
			Rack rack = rackList.get(0);
			rack.setOccupied(true);
			rackWareHouseService.addRack(rack);
			productReciept.setRack(rack);
			productWareHouseReciept = productWareHouseRecieptRepository.save(productReciept);
		}else {
			throw new ProductWarehouseException("WareHouse is full");
		}
		return productWareHouseReciept;
	}
	
	public Integer searchProductByCode(String productCodeId) {
		ProductWareHouseReciept wareHouseReciept = productWareHouseRecieptRepository.findByProductProductCode(productCodeId);
		return wareHouseReciept.getRack().getSlotNo();
	}
	
	public List<Integer> searchProductsSlotNoByColor(String colorName) {
		List<Integer> productSlotNoList = new ArrayList<>();
		List<ProductWareHouseReciept> wareHouseReciept = productWareHouseRecieptRepository.findAllByProductProductColor(colorName);
		for (ProductWareHouseReciept productWareHouseReciept : wareHouseReciept) {
			productSlotNoList.add(productWareHouseReciept.getRack().getSlotNo());
		}
		return productSlotNoList;
	}
	
	public List<ProductWareHouseReciept> getAllReciepts(){
		return productWareHouseRecieptRepository.findAllBySold(false);
	}
	
	public void emptyRack(int slotNo) {
		ProductWareHouseReciept reciept = productWareHouseRecieptRepository.findByRackSlotNo(slotNo);
		reciept.getRack().setOccupied(false);
		rackWareHouseService.addRack(reciept.getRack());
		reciept.setSold(true);
		productWareHouseRecieptRepository.save(reciept);
	}
	
}
