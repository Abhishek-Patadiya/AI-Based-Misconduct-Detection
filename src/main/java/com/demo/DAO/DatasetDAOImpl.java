package com.demo.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.Model.DatasetVO;

@Repository
public class DatasetDAOImpl implements DatasetDAO {
	
		@Autowired
		private SessionFactory sessionFactory;

		public void setSessionFactory(SessionFactory sf) {
			this.sessionFactory = sf;
		}
		
		public void insertDataset(DatasetVO datasetVO) {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(datasetVO);
		}
}
