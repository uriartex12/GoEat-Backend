package com.SelfCare.SelfCare.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="client")
@Getter @Setter
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code ;
	private String identitynumber ;
	private String businessname;
	private String secret;
	private Date startdate ;
	private Integer status ;
	private String server;
	private String endpoint ;
	private String logo ;
	private String home;
	private String conf ;
	
	public Client() {
			
	}
}
