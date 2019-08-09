package com.product.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="RACK")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rack extends AuditableFields{
	
	@Column(name="slot_number")
	int slotNo;
	
	@Column(name="is_Filled")
	boolean occupied;
	
}
