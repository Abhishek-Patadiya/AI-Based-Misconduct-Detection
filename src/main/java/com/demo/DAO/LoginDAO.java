package com.demo.DAO;

import java.util.List;

import com.demo.Model.*;

public interface LoginDAO {

	public void insertLogin(LoginVO loginVO);

	public List searchForForgot();

	public void updateData(LoginVO loginVO);
	
	public List searchLoginID(String userName);
	
	public List getFullName(LoginVO loginVO);
	
	public List getGraph(String datetoday);
	
	public void updateNewData(LoginVO loginVO);
}
