package com.SelfCare.SelfCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SelfCare.SelfCare.entity.Businessobject;

@Repository
public interface BusinessObjectRepositoryI extends JpaRepository<Businessobject,Integer> {

}
