package com.training.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.dao.VisitorDAO;
import com.training.model.Visitor;
import com.training.services.VisitorService;

@RestController
@RequestMapping("visitor")
public class VisitorController {

	@Autowired
	VisitorService visitorService;

	@Autowired
	VisitorDAO visitorDAO;
	
	
	@GetMapping("generateVisitorId") // localhost:9090/visitor/generateVisitorId - GET
	public String getRandomVisitorId() {
        Random rand = new Random();
		return  "V00 "+rand.nextInt(100, 90000);
	}
	
	@GetMapping("meeting") // localhost:9090/visitor/meeting - GET
	public String getMeetingDetails() {
		return  "Meeting is happening at : 8th Floor ";
	}
	
	@GetMapping("meeting2") // localhost:9090/visitor/meeting - GET
	public String getMeetingDetails2() {
		return  "Meeting is happening at : 8th Floor ";
	}
	
	@GetMapping("getManagerDetails") // localhost:9090/visitor/getManagerDetails - GET
	public String getManagerDetails() {
		return  "My Manager is :: Missing ";
	}

	@GetMapping // localhost:9090/visitor - GET
	public List<Visitor> getVisitors() {
		System.out.println("####" + visitorDAO.findByMyCustom(11));
		System.out.println("#####" + visitorDAO.findByOFSSMobileNumber("9876543211"));
		return (List<Visitor>) visitorService.findVisitors();

	}

	@GetMapping("{visitorId}")
	public ResponseEntity<String> getSingleVisitors(@PathVariable("visitorId") int visitorId) {
		if (visitorService.findVisitors(visitorId) == null) {
			return new ResponseEntity<String>("Visitor does not exist", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(visitorService.findVisitors(visitorId).toString(), HttpStatus.OK);

	}

	@DeleteMapping("{visitorId}") // localhost:9090/visitor/8272 // DELETE
	public String deleteVisitor(@PathVariable("visitorId") int visitorId) {
		return "visitor deleted with id :" + visitorId;
	}

	@PutMapping // localhost:9090/visitor // PUT
	public String updateVisitor(@RequestBody Visitor visitor) {
		return "visitor updated";
	}

	@PostMapping // localhost:9090/visitor - POST
	public ResponseEntity<String> saveVisitors(@RequestBody Visitor visitor) {
		String result = null;
		ResponseEntity<String> responseEntity = null;

		// code to check whether visitor already exists
		if (visitorService.isVisitorExists(visitor.getVisitorId())) {
			responseEntity = new ResponseEntity<String>(
					"Visitor already exists with visitor id :" + visitor.getVisitorId(), HttpStatus.CONFLICT);

		} else {
			result = visitorService.createVisitor(visitor);
			if (result.equals("Visitor saved")) {
				responseEntity = new ResponseEntity<String>("Visitor saved with visitor id :" + visitor.getVisitorId(),
						HttpStatus.CREATED);
			} else {
				responseEntity = new ResponseEntity<String>(result + visitor.getVisitorId(), HttpStatus.NOT_ACCEPTABLE);
			}
		}

		return responseEntity;
	}

	@PutMapping("{visitorId}") // localhost:9090/visitor/19191 // PUT
	public String updateVisitor(@PathVariable("visitorId") int visitorId, @RequestBody Visitor visitor) {
		return "visitor updated by visitor id :" + visitorId + "Visitor Details updated : " + visitor;
	}

	@GetMapping("findVisitor/{visitorName}")
	public List<Visitor> findVisitor(@PathVariable("visitorName") String visitorName) {
		return visitorService.findVisitors(visitorName);
	}

	@GetMapping("findVisitor/{visitorid1}/{visitorid2}")
	public List<Visitor> findVisitor(@PathVariable("visitorid1") int visitorid1,
			@PathVariable("visitorid2") int visitorid2) {
		return visitorService.findVisitors(visitorid1, visitorid2);
	}

}
