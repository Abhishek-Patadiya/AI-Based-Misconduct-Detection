package com.demo.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.Model.FeedbackVO;
import com.demo.Model.LoginVO;

@Repository
public class FeedbackDAOImpl implements FeedbackDAO{

	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void insertFeedback(FeedbackVO feedbackvo) {
		// TODO Auto-generated method stub
		 Date d = new Date();
		 feedbackvo.setComplaindate((new java.sql.Date(System.currentTimeMillis()).toString()));
		feedbackvo.setComplaintime(java.time.LocalTime.now().toString());
		Session session = this.sessionFactory.getCurrentSession();
		session.save(feedbackvo);		
	}

	@Override
	public List viewFeedback() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from FeedbackVO");
		List ls=q.list();
		return ls;
	}
	
	@Override
	public List totalFeedbackCount() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select count(feedbackid)from FeedbackVO");
		List ls=q.list();
		return ls;
	}

	@Override
	public List usertotalFeedbackCount(LoginVO loginVO) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select count(feedbackid)from FeedbackVO where fromid='"+loginVO.getLoginId()+"'");
		List ls=q.list();
		return ls;

	}
	
	

}
