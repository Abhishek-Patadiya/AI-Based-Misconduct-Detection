package com.demo.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.Model.LoginVO;
import com.demo.Model.RegisterVO;
import com.demo.Service.ComplainService;
import com.demo.Service.FeedbackService;
import com.demo.Service.LoginService;
import com.demo.mail.*;


@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	@Autowired
	ComplainService complainservice;
	@Autowired
	FeedbackService feedbackService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loadLogin() {

		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView adminIndex(HttpServletRequest request ) {

		HttpSession session=request.getSession();
		String s=(String)session.getAttribute("usernameofuser");
		
		
		LoginVO loginVO=new LoginVO();
		loginVO.setUsername(s);
		System.out.println(loginVO.getUsername());
		List idofuser=complainservice.userLoginId(loginVO);
		LoginVO loginvonew=(LoginVO)idofuser.get(0);
		List fullname=loginService.getFullName(loginvonew);
		RegisterVO reg=(RegisterVO)fullname.get(0);
		String full=reg.getFullName();
		
		List complainCount= complainservice.totalComplainCount();
		
		List pendingComplainCount= complainservice.pendingComplainCount();
		
		List feedbackCount= feedbackService.totalFeedbackCount();
		
		Date d = new Date();
		DateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("date today===="+dateFormat.format(d));
		
		List graphCount = this.loginService.getGaph(dateFormat.format(d));
		return new ModelAndView ("admin/index")
						.addObject("pendingComplainCount",pendingComplainCount.get(0))
						.addObject("complainCount",complainCount.get(0))
						.addObject("feedbackCount",feedbackCount.get(0))
						.addObject("name",full).addObject("graphcount",graphCount);
	}
	
	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public ModelAndView userIndex(HttpServletRequest request ) {
		HttpSession session=request.getSession();
		String s=(String)session.getAttribute("usernameofuser");
		
	
		LoginVO loginVO=new LoginVO();
		loginVO.setUsername(s);
		List idofuser=complainservice.userLoginId(loginVO);
		LoginVO loginvonew=(LoginVO)idofuser.get(0);
		List fullname=loginService.getFullName(loginvonew);
		RegisterVO reg=(RegisterVO)fullname.get(0);
		String full=reg.getFullName();
		
		List complainCount= complainservice.usertotalComplainCount(loginvonew);
		
		List pendingComplainCount= complainservice.userpendingComplainCount(loginvonew);
		
		List feedbackCount= feedbackService.usertotalFeedbackCount(loginvonew);
		
		Date d = new Date();
		DateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("date today===="+dateFormat.format(d));
		
		List graphCount = this.loginService.getGaph(dateFormat.format(d));
		System.out.println("graphCount==="+graphCount.size());
		return new ModelAndView ("user/index")
				.addObject("pendingComplainCount",pendingComplainCount.get(0))
				.addObject("complainCount",complainCount.get(0))
				.addObject("feedbackCount",feedbackCount.get(0))
				.addObject("name",full).addObject("graphcount",graphCount);
	}
	
	@RequestMapping(value="/user/teacher_visualLine",method=RequestMethod.GET)
	public ModelAndView teacher_visualLine()
	{
		return new ModelAndView ("user/teacher_visualLine");
	}
	
	@RequestMapping(value="/user/teacher_authentication",method=RequestMethod.GET)
	public ModelAndView teacher_authentication()
	{
		return new ModelAndView ("user/teacher_authentication");
	}
	
	@RequestMapping(value="/user/faceDetection",method=RequestMethod.GET)
	public ModelAndView faceDetection()
	{
		String userName = BaseMethods.getUser();
		List loginList = this.loginService.searchLoginID(userName);
		LoginVO loginVO = (LoginVO)loginList.get(0);
		
		return new ModelAndView ("user/faceDetection","userName",userName).addObject("loginVO",loginVO);
	}
	
	@RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})	
	public String viewUserDetails(ModelMap model,HttpServletResponse response,HttpServletRequest request) {

		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	            request.getSession().invalidate();
	            request.getSession().setAttribute("tempStatus", "success");
	            request.getSession().setAttribute("statusText", "Logout Successfully!");
	        }
	        return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView load() {

		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView load403() {

		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView error() {

		return new ModelAndView("login");
	}
	
}