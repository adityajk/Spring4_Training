package in.co.way2learn.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table
public class Training {
	@Id
	private String trainingId;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private int price;
	private String trainingType;
	private String timing;
	private String meetingLink;
	private String passcode;
	private int priceUSD;
	
	
	private String trainerName;
	@Transient
	private int numberOfSeatsLeft;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="courseId")
	private Course course;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="users_trainings",
				joinColumns={@JoinColumn(name="trainingId")},
				inverseJoinColumns={@JoinColumn(name="email")})
	private List<UserDetails> allUserDetails;
	
	
	public String getMeetingLink() {
		return meetingLink;
	}
	public void setMeetingLink(String meetingLink) {
		this.meetingLink = meetingLink;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
		this.numberOfSeatsLeft = numberOfSeatsLeft;
	}
	public int getNumberOfSeatsLeft() {
		return numberOfSeatsLeft;
	}
	
	public void addCourse(Course course){
		this.course=course;
		this.course.getTrainings().add(this);
	}
	
	
	public void setAllUserDetails(List<UserDetails> allUserDetails) {
		this.allUserDetails = allUserDetails;
	}
	
	public List<UserDetails> getAllUserDetails() {
		return allUserDetails;
	}
	
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getTrainerName() {
		return trainerName;
	}
	
	public String getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(String trainingId) {
		this.trainingId = trainingId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setPriceUSD(int priceUSD) {
		this.priceUSD = priceUSD;
	}
	public int getPriceUSD() {
		return priceUSD;
	}
	
	public String getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	
	public Training() {}
	@Override
	public String toString() {
		return "Training [numberOfSeatsLeft=" + numberOfSeatsLeft + "]";
	}
	
	
	
}
