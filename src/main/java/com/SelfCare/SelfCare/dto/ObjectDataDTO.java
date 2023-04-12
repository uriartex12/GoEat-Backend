package com.SelfCare.SelfCare.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@Builder
public class ObjectDataDTO {
	private String code;
	private String message;
}
