package com.homeprices.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fanniemae.tech.mongo.SelectDaoService;
import com.fanniemae.tech.mongo.SelectDaoServiceImpl;

@RestController
@RequestMapping("/home-prices")
public class HomePricesController {
	
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<HomePriceInfo> getAllHomePricesInfo() {
		//List<HomePriceInfo> list = new ArrayList<HomePriceInfo>();
		SelectDaoService select = new SelectDaoServiceImpl();
		List<HomePriceInfo> list = select.getHomeListing();
		/*HomePriceInfo obj1 = new HomePriceInfo();
		HomePriceInfo obj2 = new HomePriceInfo();
		HomePriceInfo obj3 = new HomePriceInfo();
		obj1.setBaths("2");
		obj2.setBaths("3");
		obj3.setBaths("4");
		obj1.setCity("Reston");
		obj2.setCity("Herndon");
		obj3.setCity("Ashburn");
		list.add(obj1);
		list.add(obj2);
		list.add(obj3);*/
		return list;
	}

}
