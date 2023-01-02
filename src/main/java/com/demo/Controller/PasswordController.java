package com.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Properties;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.Model.ComplainVO;
import com.demo.Model.LoginVO;
import com.demo.Service.ComplainService;
import com.demo.Service.LoginService;
import com.demo.mail.BaseMethods;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;


@Controller
public class PasswordController extends BaseMethods{
	
	
	@Autowired ComplainService complainService;
	@Autowired LoginService loginService;
	
	
	@RequestMapping(value="forget",method=RequestMethod.GET)
	public ModelAndView step1()
	{
			return new ModelAndView("forget","forgotpassworduser",new LoginVO());
	}
	@RequestMapping(value="passupdate",method=RequestMethod.GET)
	public ModelAndView step3(@ModelAttribute LoginVO loginVO,HttpServletRequest request)
	{	
			
			loginService.updateLoginData(loginVO);
			return new ModelAndView("login");
		
	}
	@RequestMapping(value="verifyotp",method=RequestMethod.POST)
	public ModelAndView checkOTP(@RequestParam("otp") String otpfromuser,HttpSession session)
	{
		int otp = (Integer)session.getAttribute("otp");
		int otp1 = Integer.parseInt(otpfromuser);
		if(otp==otp1)
		{
			return new ModelAndView("user/changepassword");
		}
		else{
			return new ModelAndView("user/userEnterOTP");
		}
	}
	
	@RequestMapping(value="checkuserpassword",method=RequestMethod.GET)
	public ModelAndView step2(@ModelAttribute LoginVO loginVO,HttpSession session)
	{
		String username=loginVO.getUsername();
		List ls1 = new ArrayList();
		System.out.println(username+"usernmae");
		List ls=loginService.searchLoginData();
		System.out.println(ls+"hello2");
			
			for(int i=0;i<ls.size();i++)
			{
				
						LoginVO loginVO1=new LoginVO();
						loginVO1=(LoginVO)ls.get(i);
						System.out.println(loginVO1.getUsername()+"list1");
						String temp=loginVO1.getUsername();
						ls1.add(temp);	
			}
			if(ls1.contains(username))
			{
				List ls5=complainService.userLoginId(loginVO);
				loginVO=(LoginVO) ls5.get(0);
				int loginid=loginVO.getLoginId();
				int otp=generateOTP(4);
				System.out.println("OTP>>>>>>>"+otp);
				session.setAttribute("generatedOTP", otp);
				String subject ="";
				String content="";
				
				sendMail(username, otp, subject, content);
				 session.setAttribute("loginid", loginid);
				 session.setAttribute("otp",otp);
				session.setAttribute("email", username);
				
				
				return new ModelAndView ("forgetstep2","modelcheckuser",(LoginVO)ls5.get(0));
			}
			else
			{
				return new ModelAndView ("login");
			}
			
		}
	
	//Showing all user's data
	@RequestMapping(value="/admin/showUserInfo",method=RequestMethod.GET)
	public ModelAndView showUser()
	{
		System.out.println("inlist");
		List ls=loginService.searchLoginData();
		System.out.println("inlist");
		return new ModelAndView("admin/viewUser","listofuser",ls);
	}
}
