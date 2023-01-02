package com.demo.DAO;

import java.util.List;

import com.demo.Model.FeedbackVO;
import com.demo.Model.LoginVO;

public interface FeedbackDAO {
	
	public void insertFeedback(FeedbackVO feedbackvo);
	public List viewFeedback();
	List totalFeedbackCount();
	List usertotalFeedbackCount(LoginVO loginVO);

}
