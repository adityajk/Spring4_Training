package in.co.way2learn.service;

import in.co.way2learn.dao.AboutUsDao;
import in.co.way2learn.entity.AboutUs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AboutUsService {
	@Autowired
	private AboutUsDao aboutUsDao;
	
	@Cacheable(value="aboutus")
	public AboutUs get(String primaryKey) {
		return aboutUsDao.get(primaryKey);
	}

}
