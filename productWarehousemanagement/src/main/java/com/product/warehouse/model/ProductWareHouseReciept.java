package com.product.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PRODUCT_WAREHOUSE_RECIEPT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductWareHouseReciept extends AuditableFields {
	
	@OneToOne
	@JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "WAREHOUSE_RECIEPT_PRODUCT_FK"))
	private Product product;

	@OneToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "rack_id", foreignKey = @ForeignKey(name = "WAREHOUSE_RECIEPT_RACK_FK"))
	private Rack rack;
	
	@Column(name="sold")
	private boolean sold;
	
}
