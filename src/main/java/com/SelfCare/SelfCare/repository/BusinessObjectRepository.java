package com.SelfCare.SelfCare.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

@Repository
public class BusinessObjectRepository {
	
	private EntityManager entityManager;
	
	public BusinessObjectRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	public List<Object[]> listBusinessObject(Map params) throws Exception{
		
		StringBuilder sql = new StringBuilder();
		List<Object[]> object = new ArrayList<Object[]>();
		
		String code=( params.containsKey("code") ? " and barcode  like '%"+params.get("code").toString()+"%'" :" ");
		
		try {
			sql.append("SELECT * FROM product where name like '%"+(params.containsKey("name")? params.get("name").toString().toLowerCase().replaceAll("[\\+\\-\\.\\^:,ï¿½\\s]","%"):"")+"%'"
					+code
					+ " ORDER BY id DESC");
			object = entityManager.createNativeQuery(sql.toString()).getResultList();
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return object;
	}
}
