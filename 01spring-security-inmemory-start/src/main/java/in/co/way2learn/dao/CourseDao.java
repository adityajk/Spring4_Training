package in.co.way2learn.dao;

import in.co.way2learn.entity.Course;

import java.util.List;


public interface CourseDao{

	List<Course> getAll(boolean isPrivateCourse);

	Course get(String courseId);

	List<Object[]> getAllCourseIdNames(boolean isPrivateCourse);

	

}
