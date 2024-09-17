package com.training.services;

import java.util.List;

import com.training.model.Visitor;

public interface VisitorService {

	public String createVisitor(Visitor visitor);
	public void updateVisitor(Visitor visitor);
	public void deleteVisitor(int visitorId);
	public List<Visitor> findVisitors();
	public boolean isVisitorExists(int visitorId);
	public Visitor findVisitors(int visitorId);
	
	public List<Visitor> findVisitors(int minimumVisitorId,int maximumVisitorId);
	public List<Visitor> findVisitors(String visitorName);
	
}
