package com.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.Model.ComplainVO;
import com.demo.Model.FeedbackVO;
import com.demo.Model.LoginVO;
import com.demo.Service.FeedbackService;
import com.demo.Service.*;
@Controller
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackservice;
	
	@Autowired
	ComplainService complainservice;
	
	@RequestMapping(value="/user/addFeedback",method=RequestMethod.GET)
	public ModelAndView viewFeedbackOfUser()
	{
		return new ModelAndView ("/user/addFeedback","feedbackofuser",new FeedbackVO());	
	}

	@RequestMapping(value="/user/insertFeedback",method=RequestMethod.POST)
	public ModelAndView addFeedbackOfUser(@ModelAttribute FeedbackVO feedbackvo,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("usernameofuser");
		LoginVO loginVO=new LoginVO();
		loginVO.setUsername(username);
		List ls1=complainservice.userLoginId(loginVO);
		LoginVO loginVO2=(LoginVO)ls1.get(0);
		feedbackvo.setFromid(loginVO2);
		feedbackservice.addFeedback(feedbackvo);
		return new ModelAndView ("/user/addFeedback","feedbackofuser",new FeedbackVO());	
	}
	@RequestMapping(value="/admin/viewFeedback",method=RequestMethod.GET)
	public ModelAndView viewFeedbackForAdmin()
	{
		
		List ls= feedbackservice.adminViewFeedback();
		return new ModelAndView ("admin/viewFeedback","modelfeedback",ls);	
	}
	
}
