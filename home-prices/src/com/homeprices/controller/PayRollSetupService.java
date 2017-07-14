package com.homeprices.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payroll-setup-serv")
public class PayRollSetupService {

	//@RequestMapping(value = "/setup-request", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	@RequestMapping(value = "/setup-request", method = RequestMethod.POST)
	@ResponseBody
	public List<PayrollSetupRequest> persist(@RequestBody PayrollSetupRequest request) {
		PayrollConnectDao dao = new PayrollConnectDao();
		List<PayrollSetupRequest> list = dao.persist(request);
		return list;
	}
	
	@RequestMapping(value = "/retrieve", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<PayrollSetupRequest> retrieveAll() {
		PayrollConnectDao dao = new PayrollConnectDao();
		List<PayrollSetupRequest> list = dao.getAllRows();
		return list;
	}
	
	
	
	
}
