package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.CountyDao;
import daomodels.County;

@Controller
public class Control {

	@Autowired
	private CountyDao countyDao;

	public Control() {
	}

	@RequestMapping("/asd")
	public void asd() {
		List<County> counties = countyDao.getAllCounties();
		
		for (County c : counties) {
			System.out.println(c.getName());
		}
	}
}
