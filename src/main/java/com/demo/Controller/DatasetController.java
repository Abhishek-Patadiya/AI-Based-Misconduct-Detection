package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.Model.DatasetVO;
import com.demo.Service.DatasetService;


@Controller
public class DatasetController {
	@Autowired DatasetService datasetservice;
	
	
	
	
	
	@RequestMapping(value="addDataset",method=RequestMethod.GET)
	public ModelAndView loadDataset()
	{
		return new ModelAndView ("admin/addDataset","modeldatasetinsert",new DatasetVO());
	}
	@RequestMapping(value="insertDataset",method=RequestMethod.GET)
	public ModelAndView insertDataset(@ModelAttribute DatasetVO datasetvo)
	{
		this.datasetservice.addDataset(datasetvo);
		return new ModelAndView ("admin/addDataset","modeldatasetinsert",new DatasetVO());
	}

}
