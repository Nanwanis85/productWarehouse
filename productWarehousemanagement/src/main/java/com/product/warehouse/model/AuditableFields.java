package com.product.warehouse.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditableFields {

	@Id
	@GeneratedValue(
	    strategy= GenerationType.AUTO,
	    generator="native"
	)
	@GenericGenerator(
	    name = "native",
	    strategy = "native"
	)
	private Long id;

	@Column(name="created_date_time")
	Date createdDateTime;
	
	@Column(name="updated_date_time")
	Date updatedDateTime;
	
	@PrePersist
	public void setDate() {
		this.createdDateTime = new Date();
	}
	
	@PreUpdate
	public void updateDate() {
		this.updatedDateTime = new Date();
	}
	
}
