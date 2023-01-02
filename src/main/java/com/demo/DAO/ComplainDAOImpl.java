package com.demo.DAO;
import java.util.List;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.Model.ComplainVO;
import com.demo.Model.LoginVO;

@Repository
public class ComplainDAOImpl implements ComplainDAO {
	
    	@Autowired
		private SessionFactory sessionFactory;

		public void setSessionFactory(SessionFactory sf) {
			this.sessionFactory = sf;
		}
		
		public void insertComplain(ComplainVO complainVO) {
			 Date d = new Date();
			 complainVO.setComplainstatus("pending");
			 complainVO.setComplaindate((new java.sql.Date(System.currentTimeMillis()).toString()));
			complainVO.setComplaintime(java.time.LocalTime.now().toString());
			Session session = this.sessionFactory.getCurrentSession();
			session.save(complainVO);
		}

		@Override
		public List seaechComplain() {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from ComplainVO");
			List ls=q.list();
			return ls;
		}

		@Override
		public List updateComplainData(ComplainVO complainVO) {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from ComplainVO where complainid='"+complainVO.getComplainid()+"'");
			List ls=q.list();
			return ls;
		}
		public void insertUpdatedReply(ComplainVO complainVO) {
			
			complainVO.setComplaindate((new java.sql.Date(System.currentTimeMillis()).toString()));
			complainVO.setComplaintime(java.time.LocalTime.now().toString());
			complainVO.setComplainstatus("Replied");
			Session session = this.sessionFactory.getCurrentSession();
			session.update(complainVO);
		}

		@Override
		public List searchLoginIdOfUser(LoginVO loginVO) {
			// TODO Auto-generated method stub
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LoginVO where username='"+loginVO.getUsername()+"'");
			List ls=q.list();
			return ls;
		}

		@Override
		public List viewComplainUSer(ComplainVO complainVO) {
			
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from ComplainVO where toId='"+complainVO.getToId().getLoginId()+"' AND complainstatus='Replied' ");
			List ls=q.list();
			return ls;
		}
		@Override
		public List totalComplaintCount() {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("select count(complainid) from ComplainVO");
			List ls=q.list();
			return ls;
		}

		@Override
		public List pendingComplaintCount() {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("select count(complainid) from ComplainVO where complainstatus='pending' ");
			List ls=q.list();
			return ls;
		}

		@Override
		public List userComplaintCount(LoginVO loginVO) {
			// TODO Auto-generated method stub
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("select count(complainid) from ComplainVO where fromId='"+loginVO.getLoginId()+"'");
			List ls=q.list();
			return ls;
		}

		@Override
		public List userpendingComplaintCount(LoginVO loginVO) {
			// TODO Auto-generated method stub
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("select count(complainid) from ComplainVO where complainstatus='pending' and fromId='"+loginVO.getLoginId()+"'");
			List ls=q.list();
			return ls;
		}
		
}
