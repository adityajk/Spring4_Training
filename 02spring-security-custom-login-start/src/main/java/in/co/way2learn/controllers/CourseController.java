package in.co.way2learn.controllers;

import in.co.way2learn.entity.Course;
import in.co.way2learn.entity.Purchase;
import in.co.way2learn.entity.Testimonial;
import in.co.way2learn.entity.UserDetails;
import in.co.way2learn.service.CourseService;
import in.co.way2learn.service.TestimonialService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {


	@Autowired
	private TestimonialService testimonialService;

	@Autowired
	private CourseService courseService;
	
	@SuppressWarnings({ "unchecked", "unused" })
	@RequestMapping(value={"/viewIndividualCourse","/s/viewIndividualCourse"})
	public String viewIndividualCourse(@RequestParam("courseId")String courseId,HttpSession session,HttpServletRequest request){
		Course currentCourse=null;
		
		if(session.getServletContext().getAttribute("courses")!=null){      //-------------------------> if courses are present in application scope then get course from app scope
			List<Course> courses=(List<Course>)session.getServletContext().getAttribute("courses");
			for(Course course:courses){
				if(course.getCourseId().equals(courseId)){
					request.setAttribute("course", (currentCourse=course));
					break;
				}
			}
			if(request.getAttribute("course")==null){                  //------------------------> if course is private course get from database based on course id
				request.setAttribute("course", (currentCourse=courseService.get(courseId)));
			}
		}
		
		List<Testimonial> testimonials=testimonialService.getTestimonialsByCourse(courseId);
		request.setAttribute("testimonials", testimonials);
		return "viewIndividualCourse";
	}
	
	
	
	
	@RequestMapping(value = { "/browseCourses","/user/browseCourses","/s/myCourses"}, method = RequestMethod.GET)
	public String browseCourses(HttpSession session,HttpServletRequest request) {
		/*if(session.getAttribute("SPRING_SECURITY_CONTEXT")!=null){
			UserDetails userDetails=(UserDetails)session.getAttribute("userDetails");
			List<Purchase> myPurchases=initializeNumberOfReviews(purchasesService.getPurchasesByUser(userDetails.getEmail()));
			session.setAttribute("myPurchases", eliminateOneDayPurchases(myPurchases));
		}*/
		if(request.getParameter("private")!=null && request.getParameter("private").equalsIgnoreCase("true")){
			request.setAttribute("privateCourses", courseService.getAll(true));
			return "privateCourses";
		}
		//Normal courses are already loaded from home.htm
		return "browseCourses";
	}
	
	
	@SuppressWarnings("unused")
	private void initializeNumberOfReviews(List<Course> courses) {
		for(Course course:courses){
			course.setNumberOfReviews(testimonialService.getNumberOfTestimonialsByCourse(course.getCourseId()));
		}
	}

	@RequestMapping(value={"/s/coursePending"})
	public String courseTentative(){
		
		return "coursePending";
	}
	
	@RequestMapping(value={"/s/courseExpired.htm"})
	public String courseExpired(){
		
		return "courseExpired";
	}
}