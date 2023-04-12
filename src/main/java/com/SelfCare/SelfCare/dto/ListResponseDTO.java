package com.SelfCare.SelfCare.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class ListResponseDTO {
	private Integer total;
	private Integer xpagina;
	private Integer pagina;
	private List list;
}
