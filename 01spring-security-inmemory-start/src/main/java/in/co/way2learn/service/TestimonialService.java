package in.co.way2learn.service;

import in.co.way2learn.dao.TestimonialDao;
import in.co.way2learn.entity.Purchase;
import in.co.way2learn.entity.Testimonial;
import in.co.way2learn.entity.UserDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestimonialService {
	@Autowired
	private TestimonialDao testimonialDao;

	
	@Cacheable(value="testimonials")
	public List<Testimonial> getGoodTestimonials() {
		
		return testimonialDao.getGoodTestimonials();
	}

	@Cacheable(value="testimonials")
	public int getNumberOfTestimonialsByCourse(String courseId) {
		
		return testimonialDao.getNumberOfTestimonialsByCourse(courseId);
	}

	@Cacheable(value="testimonials",key="'getTestimonialsByCourse'+#courseId")
	public List<Testimonial> getTestimonialsByCourse(String courseId) {
		if(courseId.equals("0")){
			return getGoodTestimonials();
		}
		return testimonialDao.getTestimonialsByCourse(courseId);
	}

	public Testimonial getTestimonial(String email, String courseId) {
		return testimonialDao.getTestimonial(email,courseId);
	}

	
	public boolean save(Testimonial testimonial) {
		return testimonialDao.save(testimonial);
	}

	
	public boolean update(Testimonial testimonial) {
		return testimonialDao.update(testimonial);
	}
	
	

}
