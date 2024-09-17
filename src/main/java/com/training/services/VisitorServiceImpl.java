package com.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.training.dao.VisitorDAO;
import com.training.model.Visitor;

@Service
public class VisitorServiceImpl implements VisitorService {
	@Autowired
	VisitorDAO visitorDAO;

	public String createVisitor(Visitor visitor) {
		if (visitor.getVisitorId() < 0) {
			return "Visitor id cannot be negative";
		} else {
			visitorDAO.save(visitor);
			return "Visitor saved";
		}
	}

	public boolean isVisitorExists(int visitorId) {
		return visitorDAO.existsById(visitorId);
	}

	@Override
	public void updateVisitor(Visitor visitor) {

	}

	@Override
	public void deleteVisitor(int visitorId) {
		visitorDAO.deleteById(visitorId);
	}

	@Override
	public List<Visitor> findVisitors() {
		return (List<Visitor>) visitorDAO.findAll();
	}

	@Cacheable(value = "visitors", key = "#p0")
	public Visitor findVisitors(int visitorId) {
		return visitorDAO.findById(visitorId).get();
	}

	@Override
	public List<Visitor> findVisitors(int minimumVisitorId, int maximumVisitorId) {
		return visitorDAO.findByVisitorIdBetween(minimumVisitorId, maximumVisitorId);
	}

	@Override
	public List<Visitor> findVisitors(String visitorName) {
		// TODO Auto-generated method stub
		return visitorDAO.findByVisitorName(visitorName);
	}

}
