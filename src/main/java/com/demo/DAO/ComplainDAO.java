package com.demo.DAO;

import java.util.List;
import com.demo.Model.ComplainVO;
import com.demo.Model.LoginVO;


public interface ComplainDAO {
	
	public void insertComplain(ComplainVO complainVO);
    public List seaechComplain();
    public List updateComplainData(ComplainVO complainVO);
    public void insertUpdatedReply(ComplainVO complainVO);
    public List searchLoginIdOfUser(LoginVO loginVO);
    public List viewComplainUSer(ComplainVO complainVO);
	List totalComplaintCount();
	List pendingComplaintCount();
	List userComplaintCount(LoginVO loginVO);
	List userpendingComplaintCount(LoginVO loginVO);
}
