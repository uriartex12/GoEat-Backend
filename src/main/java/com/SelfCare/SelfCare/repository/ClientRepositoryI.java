package com.SelfCare.SelfCare.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SelfCare.SelfCare.entity.Client;

@Repository
public interface ClientRepositoryI extends JpaRepository<Client, Integer> {
	
	@Transactional
	@Query(value = "SELECT * FROM client c WHERE c.code=:code",nativeQuery = true)
	public Client getbyCodeClient(String code);

}
	