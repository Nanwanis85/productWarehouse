package com.product.warehouse.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.warehouse.model.Rack;

@Repository
public interface RackRepository extends JpaRepository<Rack, UUID>  {
	
	List<Rack> findAllByOccupied(boolean occupied);

}
