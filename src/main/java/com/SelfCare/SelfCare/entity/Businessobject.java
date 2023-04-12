package com.SelfCare.SelfCare.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="product")
@Getter @Setter
@AllArgsConstructor
@Builder
public class Businessobject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String barcode;
	private String description;
	@JoinColumn(name="clientid")
	private int clientid;
	private String photo;
	private String nameconcat;
	private BigDecimal amount;
	private String name;
	private BigDecimal totalmoney;
	@Column(name="created_at",columnDefinition = "timestamp")	
	private Date create;
	@Column(name="update_at",columnDefinition = "timestamp")	
	private Date update;

}
