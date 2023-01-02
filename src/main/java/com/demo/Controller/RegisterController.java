package com.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.demo.Model.*;
import com.demo.Service.RegisterService;
import com.demo.Service.*;
@Controller
public class RegisterController {

	@Autowired RegisterService registerservice; 
	@Autowired LoginService loginservice;
	@Autowired ComplainService complainservice;
	

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView registerPage()
	{
		return new ModelAndView("admin/register","registermodel",new RegisterVO());
	}
	
/*	@RequestMapping(value="/user/editprofile",method=RequestMethod.GET)
	public ModelAndView registerPageUpdate(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("usernameofuser");
		LoginVO loginVO=new LoginVO();
		loginVO.setUsername(username);
		List ls1=complainservice.userLoginId(loginVO);
		return new ModelAndView("admin/register","registermodel",new RegisterVO()).addAllObjects(ls);
	}*/
	
	@RequestMapping(value="registerinsert",method=RequestMethod.GET)
	public ModelAndView registerUser(@ModelAttribute LoginVO loginVO,@ModelAttribute RegisterVO registerVO)
	{		
		loginVO.setUsername(registerVO.getLoginVO().getUsername());
		loginVO.setPassword(registerVO.getLoginVO().getPassword());
		loginVO.setRole("ROLE_USER");
		loginVO.setEnabled(1);
		loginservice.insertLoginData(loginVO);
		registerVO.setLoginVO(loginVO);
		registerservice.insertData(registerVO);
		return new ModelAndView ("admin/register","registermodel",new RegisterVO());
	}
	
	/*@RequestMapping(value="/admin/editprofile",method=RequestMethod.GET)
	public ModelAndView editprofilePage(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("usernameofuser");
		LoginVO loginVO=new LoginVO();
		loginVO.setUsername(username);
		List ls1=complainservice.userLoginId(loginVO);
		LoginVO lognew=(LoginVO)ls1.get(0);
		System.out.println(username+"usernameofuser");
		RegisterVO registerVO=new RegisterVO();
		registerVO.setLoginVO(lognew);
		List ls=registerservice.getData(registerVO);
		System.out.println(ls+"userls");
		RegisterVO regnew=(RegisterVO) ls.get(0);
		
		return new ModelAndView("admin/editprofile","registerupdate",regnew);
	}
	
	@RequestMapping(value="/admin/registerupdate",method=RequestMethod.GET)
	public ModelAndView updateProfileofuser(@ModelAttribute LoginVO loginVO,@ModelAttribute RegisterVO registerVO)
	{
		loginservice.updateNewData(loginVO);
		registerservice.updateData(registerVO);
		return new ModelAndView("/login");
	}*/
}
