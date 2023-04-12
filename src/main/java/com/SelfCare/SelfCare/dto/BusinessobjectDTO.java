package com.SelfCare.SelfCare.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter 
@Builder
@ToString
@AllArgsConstructor
public class BusinessobjectDTO {
	private int id;
	private String code;
	private String barcode;
	private String description;
	private Integer clientid;
	private String photo;
	private String nameconcat;
	private BigDecimal amount;
	private String name;
	private BigDecimal totalmoney;
	private Date create;
	private Date update;
}
