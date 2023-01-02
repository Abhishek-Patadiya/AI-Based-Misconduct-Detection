package com.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DAO.RegisterDAO;
import com.demo.Model.RegisterVO;

@Service
public class RegisterService {
@Autowired RegisterDAO registerDAO;
	
	
	@Transactional
	public void insertData(RegisterVO registerVO)
	{
		this.registerDAO.insertUser(registerVO);
	}


	@Transactional
	public List getData(RegisterVO registerVO)
	{
		List ls=this.registerDAO.getData(registerVO);
		return ls;
	}

	@Transactional
	public void updateData(RegisterVO registerVO)
	{
		this.registerDAO.updateData(registerVO);
	}
}
