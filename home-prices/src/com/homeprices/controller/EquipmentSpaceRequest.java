package com.homeprices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eqip-space-serv")
public class EquipmentSpaceRequest {
	
	@RequestMapping(value = "/eqip-space", method = RequestMethod.POST)
	@ResponseBody
	public List<EquipSpaceInfo> persist(@RequestBody EquipSpaceInfo request) {
		EquipSpaceDao dao = new EquipSpaceDao();
		List<EquipSpaceInfo> list = dao.persist(request);
		return list;
	}
}
