package com.demo.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.demo.Model.ComplainVO;
import com.demo.Model.LoginVO;
import com.demo.Service.ComplainService;




@Controller
public class ComplainController {

	@Autowired ComplainService complainservice;
	
	@RequestMapping(value="/user/addComplain",method=RequestMethod.GET)
	public ModelAndView addComplainOfUser()
	{
			return new ModelAndView ("user/addComplain","modelinsertcomplain",new ComplainVO());
	}
	@RequestMapping(value="/user/viewComplain",method=RequestMethod.GET)
	public ModelAndView viewComplainOfUser(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("usernameofuser");
		LoginVO loginVO=new LoginVO();
		loginVO.setUsername(username);
		List ls1=complainservice.userLoginId(loginVO);
		LoginVO loginVO2=(LoginVO)ls1.get(0);
		ComplainVO complainvo=new ComplainVO();
		complainvo.setToId(loginVO2);
		List ls2=complainservice.viewComplainOfUSer(complainvo);
		int replied=ls2.size();
		System.out.println(ls2+"hello");
		return new ModelAndView ("user/viewComplain","listofuserforview",ls2);
	}
	
	@RequestMapping(value="/user/insertComplain",method=RequestMethod.POST)
	public ModelAndView insertComplainOfUser(@ModelAttribute ComplainVO complainvo,HttpServletRequest request,@RequestParam ("file") MultipartFile file,HttpSession session)
	{
		
		
		
String path = session.getServletContext().getRealPath("/");
		
		String filePath = path + "documents\\profileImage\\";
		
		String fileName = file.getOriginalFilename();
		
		try
		{
			byte b[] = file.getBytes();
			
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath+"/"+fileName));
			System.out.println(filePath+"/"+fileName);
			bufferedOutputStream.write(b);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
		}
		catch (Exception e) {
			System.out.println("Hey I'm Error");
		}
		complainvo.setFileName(fileName);
		complainvo.setFilePath(filePath);
		
		
		
		String username=(String) session.getAttribute("usernameofuser");
		LoginVO loginVO=new LoginVO();
		loginVO.setUsername(username);
		List ls1=complainservice.userLoginId(loginVO);
		LoginVO loginVO2=(LoginVO)ls1.get(0);
		complainvo.setFromId(loginVO2);
	
		LoginVO loginVO3=new LoginVO();
		loginVO3.setLoginId(48);
		complainvo.setToId(loginVO3);
		complainservice.addComplain(complainvo);
		List ls=complainservice.searchComplianData();
		return new ModelAndView ("user/addComplain","modelinsertcomplain",new ComplainVO());
	}
	
	@RequestMapping(value="/admin/viewComplain",method=RequestMethod.GET)
	public ModelAndView viewComplainForAdmin()
	{
		
		List ls= complainservice.searchComplianData();
		System.out.println(ls.size()+"countofcompain");
		return new ModelAndView ("admin/viewComplain","modelinsertcomplain",new ComplainVO()).addObject("listofcomplain",ls);
		
	}
	
	@RequestMapping(value="/admin/replycomplain",method=RequestMethod.GET)
	public ModelAndView replyOfComplain(@ModelAttribute ComplainVO complainvo)
	{
		List l= complainservice.updateComplain(complainvo);
		return new ModelAndView("admin/replycomplain","replycomplain",(ComplainVO)l.get(0));
	
	}
	@RequestMapping(value="/admin/updateComplain",method=RequestMethod.GET)
	public ModelAndView insertReplyOfComplain(@ModelAttribute ComplainVO complainvo)
	{
		List ls1=complainservice.updateComplain(complainvo);
		 LoginVO loginVO=new LoginVO();
		 loginVO.setLoginId(48);
		 complainvo.setFromId(loginVO);
		 
		 
		 ComplainVO complainVO2=(ComplainVO) ls1.get(0);
		 LoginVO loginVO2=complainVO2.getFromId();
		 complainvo.setToId(loginVO2);
		 
		 complainservice.updateReply(complainvo);
		 List ls= complainservice.searchComplianData();
		return new ModelAndView ("admin/viewComplain","modelinsertcomplain",new ComplainVO()).addObject("listofcomplain",ls);
		
	}

}
