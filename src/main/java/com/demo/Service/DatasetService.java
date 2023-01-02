package com.demo.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DAO.DatasetDAO;
import com.demo.Model.DatasetVO;

@Service
public class DatasetService {
	
@Autowired DatasetDAO datasetDAO;
	
	
	@Transactional
	public void addDataset(DatasetVO datasetvo)
	{
		datasetDAO.insertDataset(datasetvo);
	}

}
