package com.SelfCare.SelfCare.dto;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter 
@Builder
@ToString
@AllArgsConstructor
public class BusObjectResquestDTO {
	private ArrayList<BusinessobjectDTO> data;
	private String hash;
	private String code;
	private String timeStamp;
}
