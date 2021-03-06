package in.co.way2learn.dao;

import in.co.way2learn.entity.AboutUs;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AboutUsDaoImpl implements AboutUsDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public AboutUs get(String primaryKey) {
		try {
			return (AboutUs)sessionFactory.getCurrentSession().createQuery("from AboutUs where aboutUsId=:aboutUsId").setString("aboutUsId", primaryKey).setMaxResults(1).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
