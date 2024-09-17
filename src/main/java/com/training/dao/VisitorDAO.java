package com.training.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.model.Visitor;

import jakarta.persistence.NamedQuery;

@Repository
public interface VisitorDAO extends CrudRepository<Visitor, Integer> {

	public List<Visitor> findByVisitorName(String visitorName);

	public List<Visitor> findByVisitorIdBetween(int min, int max);

	@Query(value = "select visitorName from Visitor where visitorId =  :vId")
	public String findByMyCustom(int vId);

	public List<Visitor> findByOFSSMobileNumber(String mobileNumber);

}
