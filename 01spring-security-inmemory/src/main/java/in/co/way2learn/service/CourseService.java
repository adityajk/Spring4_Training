package in.co.way2learn.service;

import in.co.way2learn.dao.CourseDao;
import in.co.way2learn.entity.Course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseService {
	@Autowired
	private CourseDao courseDao;
	
	@Cacheable(value="courses")
	public List<Course> getAll(boolean isPrivateCourse) {
		return courseDao.getAll(isPrivateCourse);
	}

	@Cacheable(value="courses")
	public Course get(String courseId) {
		return courseDao.get(courseId);
	}

	public List<Object[]> getAllCourseIdNames(boolean isPrivateCourse) {
		
		return courseDao.getAllCourseIdNames(isPrivateCourse);
	}
	
	

/*	public List<Course> getSubCourses(String mainCourseId) {
		return courseDao.getSubCourses(mainCourseId);
	}*/

}
