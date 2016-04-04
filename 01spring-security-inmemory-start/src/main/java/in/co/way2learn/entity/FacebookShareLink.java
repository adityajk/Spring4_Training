package in.co.way2learn.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class FacebookShareLink {
	@Id
	private String id;
	private String link;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="courseId")
	private Course course;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public FacebookShareLink() {
		// TODO Auto-generated constructor stub
	}
	public FacebookShareLink(String id, String link, Course course) {
		super();
		this.id = id;
		this.link = link;
		this.course = course;
	}
	
}
