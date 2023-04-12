package com.SelfCare.SelfCare.service;

import java.util.Map;

import com.SelfCare.SelfCare.dto.BusObjectResquestDTO;
import com.SelfCare.SelfCare.dto.BusinessObjectResponse;
import com.SelfCare.SelfCare.dto.ListResponseDTO;

public interface BusinessObjectServiceI {
	
	public BusinessObjectResponse businessObjectSave(BusObjectResquestDTO params)throws Exception;
	public ListResponseDTO listBusinessObject(Map params) throws Exception;
}
