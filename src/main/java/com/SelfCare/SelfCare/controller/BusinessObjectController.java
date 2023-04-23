package com.SelfCare.SelfCare.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SelfCare.SelfCare.dto.BusObjectResquestDTO;
import com.SelfCare.SelfCare.dto.BusinessObjectResponse;
import com.SelfCare.SelfCare.dto.ListResponseDTO;
import com.SelfCare.SelfCare.service.BusinessObjectServiceI;
import com.SelfCare.SelfCare.util.Util;

@RestController
@RequestMapping("api/businessobject")
public class BusinessObjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(BusinessObjectController.class);
	
	BusinessObjectServiceI businessObjectService;
	
	public BusinessObjectController(BusinessObjectServiceI businessObjectService) {
		this.businessObjectService=businessObjectService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> getBusinessObject(@RequestBody BusObjectResquestDTO params) throws Exception{
		Map response= new HashMap<String, String>();
		try {
			if(params.getData()==null)throw new Exception("MISSED_PARAMS");
			BusinessObjectResponse product=businessObjectService.businessObjectSave(params);
			return new ResponseEntity<BusinessObjectResponse>(product, HttpStatus.OK);
		} catch (Exception e) {
			logger.info("BUSINESSOBJECT_ERROR: "+e.getMessage());
			response.put("error", e.getMessage());
			response.put("cause", e.getCause());
			response.put("e", e.toString() );
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);	
		}		
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> list(@RequestParam Map params){
			try {
				params.put("count", false);
				if(!params.containsKey("pagina")) params.put("pagina",1);
				params.put("xpagina", params.containsKey("xpagina")?params.get("xpagina"):10);
				int limit = Util.resolveLimit(params);		
				params.put("limit", limit);
				ListResponseDTO ship = businessObjectService.listBusinessObject(params);
				return new ResponseEntity<>(ship, HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity<>(new HashMap() {{ put("error",e.getMessage());}}, HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
}
