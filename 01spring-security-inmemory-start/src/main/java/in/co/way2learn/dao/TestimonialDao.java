package in.co.way2learn.dao;

import in.co.way2learn.entity.Testimonial;

import java.util.List;


public interface TestimonialDao{

	List<Testimonial> getGoodTestimonials();

	int getNumberOfTestimonialsByCourse(String courseId);

	List<Testimonial> getTestimonialsByCourse(String courseId);

	Testimonial getTestimonial(String email, String courseId);

	boolean save(Testimonial testimonial);

	boolean update(Testimonial testimonial);
	
}
