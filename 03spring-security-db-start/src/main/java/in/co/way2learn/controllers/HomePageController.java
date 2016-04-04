package in.co.way2learn.controllers;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import in.co.way2learn.entity.AboutUs;
import in.co.way2learn.entity.Course;
import in.co.way2learn.entity.Purchase;
import in.co.way2learn.entity.UserDetails;
import in.co.way2learn.service.AboutUsService;
import in.co.way2learn.service.CourseService;
import in.co.way2learn.service.TestimonialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomePageController {
	
	private JdbcUserDetailsManager java
	;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private AboutUsService aboutUsService;

	@Autowired
	private TestimonialService testimonialService ;
	
	@RequestMapping("/home.htm")
	public String home(HttpSession session){
		
		ServletContext application=session.getServletContext();
		
		List<Course> courses=courseService.getAll(false);
		application.setAttribute("courses",courses);
		application.setAttribute("aboutUs", aboutUsService.get("aboutUs123"));
		application.setAttribute("goodTestimonials",testimonialService.getGoodTestimonials());
		return "baseLayout";
	}
	
	
	
	
	

}
