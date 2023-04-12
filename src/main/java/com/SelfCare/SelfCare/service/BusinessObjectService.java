package com.SelfCare.SelfCare.service;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.SelfCare.SelfCare.dto.BusObjectResquestDTO;
import com.SelfCare.SelfCare.dto.BusinessObjectResponse;
import com.SelfCare.SelfCare.dto.BusinessobjectDTO;
import com.SelfCare.SelfCare.dto.ListResponseDTO;
import com.SelfCare.SelfCare.dto.ObjectDataDTO;
import com.SelfCare.SelfCare.entity.Businessobject;
import com.SelfCare.SelfCare.entity.Client;
import com.SelfCare.SelfCare.repository.BusinessObjectRepository;
import com.SelfCare.SelfCare.repository.BusinessObjectRepositoryI;
import com.SelfCare.SelfCare.util.Util;

@Service
public class BusinessObjectService implements BusinessObjectServiceI{
	
	@Value("${autoservice.secret}")
	private String secret;
	ClientService clientService;
	@Autowired
	BusinessObjectRepositoryI businessObjectRepositoryI;
	
	BusinessObjectRepository businessObjectRepository;
	
	public BusinessObjectService(ClientService clientService,BusinessObjectRepositoryI businessObjectRepositoryI,BusinessObjectRepository businessObjectRepository) {
		this.clientService=clientService;
		this.businessObjectRepositoryI=businessObjectRepositoryI;
		this.businessObjectRepository=businessObjectRepository;
	}
	

	
	@Override
	public BusinessObjectResponse businessObjectSave(BusObjectResquestDTO params) throws Exception {
		
		try {
			List<ObjectDataDTO> Object_ = new ArrayList<ObjectDataDTO>();
			String signatureBet = Util.signSha512Base64(params.getCode()+"*"+params.getTimeStamp()+"*"+secret);
			if(!signatureBet.equals(params.getHash())) throw new Exception("INVALID_SIGNATURE");
		 	LocalDateTime dateTime = LocalDateTime.now();
		 	String timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateTime);
			Client client=clientService.validateCodeClient(params.getCode());	
			for (BusinessobjectDTO item : params.getData()) {
				 Businessobject bxt= Businessobject.builder()
						.amount(item.getAmount())
						.barcode(item.getBarcode())
						.clientid(client.getId())
						.code(item.getCode())
						.description(item.getDescription())
						.nameconcat(item.getNameconcat())
						.photo(item.getPhoto())
						.name(item.getName())
						.totalmoney(item.getTotalmoney())
						.create(new Date())
						.build();			
				 businessObjectRepositoryI.save(bxt);
				 ObjectDataDTO objt= ObjectDataDTO.builder()
						 .code(item.getCode())
						 .message("Registered product")
						 .build();
				 Object_.add(objt);
			}
			BusinessObjectResponse response = new BusinessObjectResponse(Object_, timeStamp, params.getCode());
			return response;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
	
	@Override
	public ListResponseDTO listBusinessObject(Map params) throws Exception {
		try {
			
			List<Object[]> list = businessObjectRepository.listBusinessObject(params);
			List<BusinessobjectDTO> listDTO = new ArrayList();
			ListResponseDTO response = null;
			for(int i=0; i <list.size(); i++) {
				Object[] item= list.get(i);
				int j=0;
				BusinessobjectDTO object=BusinessobjectDTO.builder()
						.id(Integer.parseInt(item[j++].toString()))
						.code(item[j++].toString())
						.barcode(item[j++].toString())
						.description(item[j++].toString())
						.clientid(Integer.parseInt(item[j++].toString()))
						.photo(item[j++].toString())
						.nameconcat(item[j++].toString())
						.amount((BigDecimal)item[j++])
						.name(item[j++].toString())
						.totalmoney((BigDecimal) item[j++])
						.create((Date)item[j++])
						.build();
				listDTO.add(object);
			}
			
			if(params.containsKey("pagina")){
				params.put("count", true);
				List<Object[]> total_ = this.businessObjectRepository.listBusinessObject(params);
				response= ListResponseDTO.builder()
						.pagina(Integer.parseInt(params.get("pagina").toString()))
						.xpagina(Integer.parseInt(params.get("xpagina").toString()))
						.total(0)
						.list(listDTO)
						.build();
			}
			
			return response;	
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		
	}
	
	
}
