package com.demo.DAO;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.Model.*;

@Repository
public class LoginDAOImpl implements LoginDAO {
	 @Autowired
		private SessionFactory sessionFactory;

		
	public void insertLogin(LoginVO loginvo)
	{
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(loginvo);
	}


	@Override
	public List searchForForgot() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from LoginVO");
		List ls=q.list();
		return ls;
	}


	@Override
	public void updateData(LoginVO loginVO) {
		// TODO Auto-generated method stub
		loginVO.setEnabled(1);
		Session session = this.sessionFactory.getCurrentSession();
		session.update(loginVO);
		
	}
	
	@Override
	public List searchLoginID(String userName) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from LoginVO where username = '"+userName+"' ");
		List ls = q.list();
		return ls;
	}


	@Override
	public List getFullName(LoginVO loginVO2) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from RegisterVO where loginVO.loginId='"+loginVO2.getLoginId()+"' ");
		List ls = q.list();
		return ls;
		
	}


	@Override
	public List getGraph(String datetoday) {
		// TODO Auto-generated method stub
		
		System.out.println(datetoday+"date");
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createSQLQuery("SELECT SUM(Angry),SUM(Disgust),SUM(Fear),SUM(Happy),SUM(Sad),SUM(Surprise),SUM(Neutral) FROM face_detection  WHERE detectionDate = '"+datetoday+"' ");
		List ls = q.list();
		return ls;
	}


	@Override
	public void updateNewData(LoginVO loginVO) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(loginVO);
	}
}
