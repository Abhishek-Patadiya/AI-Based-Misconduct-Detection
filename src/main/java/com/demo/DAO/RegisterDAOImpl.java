package com.demo.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.demo.Model.RegisterVO;

@Repository
public class RegisterDAOImpl implements RegisterDAO{
	
	 @Autowired
		private SessionFactory sessionFactory;

		public void setSessionFactory(SessionFactory sf) {
			this.sessionFactory = sf;
		}
	public void insertUser(RegisterVO regvo)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.save(regvo);
	}
	@Override
	public List getData(RegisterVO registerVO) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from RegisterVO where loginVO='"+registerVO.getLoginVO().getLoginId()+"'");
		List ls=q.list();
		return ls;
	}
	@Override
	public void updateData(RegisterVO registerVO) {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.getCurrentSession();
		session.update(registerVO);
		
	}

}
