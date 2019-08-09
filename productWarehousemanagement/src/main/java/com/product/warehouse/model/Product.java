package com.product.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PRODUCT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AuditableFields {
	
	@Column(name="product_color")
	private String productColor;
	
	@Column(name="product_code")
	private String productCode;
	
}
