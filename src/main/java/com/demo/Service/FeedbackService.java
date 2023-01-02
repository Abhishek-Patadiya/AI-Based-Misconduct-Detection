package com.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DAO.ComplainDAO;
import com.demo.DAO.FeedbackDAO;
import com.demo.Model.ComplainVO;
import com.demo.Model.*;

@Service
public class FeedbackService {

@Autowired FeedbackDAO feedbackDAO;

	
	
	@Transactional
	public void addFeedback(FeedbackVO feedbackVO)
	{
		feedbackDAO.insertFeedback(feedbackVO);
	}

	@Transactional
	public List adminViewFeedback()
	{
		List ls=feedbackDAO.viewFeedback();
		return ls;
	}
	@Transactional
	public List totalFeedbackCount()
	{
		List ls = feedbackDAO.totalFeedbackCount();
		return ls;
	}
	@Transactional
	public List usertotalFeedbackCount(LoginVO loginVO)
	{
		List ls = feedbackDAO.usertotalFeedbackCount(loginVO);
		return ls;
	}
}
