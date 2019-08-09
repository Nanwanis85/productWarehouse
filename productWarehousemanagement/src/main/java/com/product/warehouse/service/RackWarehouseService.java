package com.product.warehouse.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.warehouse.model.ProductWareHouseReciept;
import com.product.warehouse.model.Rack;
import com.product.warehouse.repository.RackRepository;

@Service
public class RackWarehouseService {
	
	@Autowired
	RackRepository rackRepository;
	
	public Long addRack(Rack rack) {
		return rackRepository.save(rack).getId();
	}

	public void addRacks(List<Rack> rackList) {
		rackRepository.saveAll(rackList);
	}
	
	public List<Rack> getEmptyRacks() {
		List<Rack> rackList = rackRepository.findAllByOccupied(false);
		rackList.sort(new Comparator<Rack>() {
		  public int compare(Rack r1, Rack r2) {
			  return r1.getSlotNo()-r2.getSlotNo();
		  }
		});
		return rackList;
	}
	
	public List<Rack> getAllRack(){
		return rackRepository.findAll();
	}
	
}
