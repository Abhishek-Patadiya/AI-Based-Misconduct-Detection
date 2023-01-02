package com.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DAO.LoginDAO;
import com.demo.Model.LoginVO;

@Service
public class LoginService {
	
@Autowired LoginDAO loginDAO;
	
	
	@Transactional
	public void insertLoginData(LoginVO loginVO)
	{
		this.loginDAO.insertLogin(loginVO);
	}
	@Transactional
	public List getFullName(LoginVO loginVO)
	{
		List ls=this.loginDAO.getFullName(loginVO);
		return ls;
	}
	@Transactional
	public List getGaph(String datetoday)
	{
		List ls=this.loginDAO.getGraph(datetoday);
		return ls;
	}
	@Transactional
	public List searchLoginData()
	{
		List ls=this.loginDAO.searchForForgot();
		return ls;
	}
	
	@Transactional
	public void updateLoginData(LoginVO loginVO)
	{
		this.loginDAO.updateData(loginVO);
	}
	
	@Transactional
	public List searchLoginID(String userName) {
		List ls = this.loginDAO.searchLoginID(userName);
		return ls;
	}
	
	@Transactional
	public void updateNewData(LoginVO loginVO) {
		 this.loginDAO.updateNewData(loginVO);
			}
}
