package com.demo.Service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DAO.ComplainDAO;
import com.demo.Model.ComplainVO;
import com.demo.Model.LoginVO;



@Service
public class ComplainService {
	
@Autowired ComplainDAO complainDAO;
	
	
	@Transactional
	public void addComplain(ComplainVO complainvo)
	{
		complainDAO.insertComplain(complainvo);
	}
	@Transactional
	public List searchComplianData()
	{
		List ls = complainDAO.seaechComplain();
		return ls;
	}
	@Transactional
	public List viewComplainOfUSer(ComplainVO complainvo)
	{
		List ls = complainDAO.viewComplainUSer(complainvo);
		return ls;
	}
	@Transactional
	public List updateComplain(ComplainVO complainvo)
	{
		List ls = complainDAO.updateComplainData(complainvo);
		return ls;
	}
	@Transactional
	public void updateReply(ComplainVO complainvo)
	{
		complainDAO.insertUpdatedReply(complainvo);
	}
	@Transactional
	public List userLoginId(LoginVO loginVO)
	{
		List ls=complainDAO.searchLoginIdOfUser(loginVO);
		return ls;
	}

	@Transactional
	public List totalComplainCount()
	{
		List ls = complainDAO.totalComplaintCount();
		return ls;
	}
	@Transactional
	public List usertotalComplainCount(LoginVO loginVO)
	{
		List ls = complainDAO.userComplaintCount(loginVO);
		return ls;
	}
	
	@Transactional
	public List userpendingComplainCount(LoginVO loginVO)
	{
		List ls = complainDAO.userpendingComplaintCount(loginVO);
		return ls;
	}
	@Transactional
	public List pendingComplainCount()
	{
		List ls = complainDAO.pendingComplaintCount();
		return ls;
	}
	
	
	
}
