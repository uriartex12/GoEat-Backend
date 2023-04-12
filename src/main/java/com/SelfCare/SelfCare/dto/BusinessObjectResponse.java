package com.SelfCare.SelfCare.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@Builder
public class BusinessObjectResponse {
	
	private  List<ObjectDataDTO> data;
	private String timeStamp;
	private String Code;
}
