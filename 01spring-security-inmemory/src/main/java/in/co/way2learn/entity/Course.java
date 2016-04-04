package in.co.way2learn.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table
public class Course implements Serializable{
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	private String courseId;
	private String name;
	@Column(length=500)
	private String description;
	private int durationInHours;
	private int numberOfViews;
	private int numberOfLearners;
	private int price;
	private int priceUSD;
	private int rating;
	private String imageName;
	private boolean privateCourse;
	@Transient
	private int numberOfReviews;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="course")
	private List<Purchase> purchases=new ArrayList<Purchase>();
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="course")
	private List<Training> trainings=new ArrayList<Training>();
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="course")
	@OrderColumn(name="indx")
	private List<FacebookShareLink> facebookShareLinks;

	
	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}
	public List<Training> getTrainings() {
		return trainings;
	}
	
	public List<FacebookShareLink> getFacebookShareLinks() {
		return facebookShareLinks;
	}

	public int getPriceUSD() {
		return priceUSD;
	}
	public void setPriceUSD(int priceUSD) {
		this.priceUSD = priceUSD;
	}
	
	public void setFacebookShareLinks(List<FacebookShareLink> facebookShareLinks) {
		this.facebookShareLinks = facebookShareLinks;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	public int getNumberOfViews() {
		return numberOfViews;
	}

	public void setNumberOfViews(int numberOfViews) {
		this.numberOfViews = numberOfViews;
	}

	public int getNumberOfLearners() {
		return numberOfLearners;
	}
	 public void incrementLearners(){
		 numberOfLearners++;
	 }

	public void setNumberOfLearners(int numberOfLearners) {
		this.numberOfLearners = numberOfLearners;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public boolean isPrivateCourse() {
		return privateCourse;
	}

	public void setPrivateCourse(boolean privateCourse) {
		this.privateCourse = privateCourse;
	}

	public int getNumberOfReviews() {
		return numberOfReviews;
	}

	public void setNumberOfReviews(int numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
	
	public Course() {}

	public Course(String courseId, String name, String description,
			int durationInHours, int numberOfViews, int numberOfLearners,
			int price, int rating, String imageName, boolean privateCourse,
			int numberOfReviews, List<Purchase> purchases) {
		this.courseId = courseId;
		this.name = name;
		this.description = description;
		this.durationInHours = durationInHours;
		this.numberOfViews = numberOfViews;
		this.numberOfLearners = numberOfLearners;
		this.price = price;
		this.rating = rating;
		this.imageName = imageName;
		this.privateCourse = privateCourse;
		this.numberOfReviews = numberOfReviews;
		//this.mainCourse = mainCourse;
		this.purchases = purchases;
	}

	public Course(String courseId) {
		super();
		this.courseId = courseId;
	}

	public void addFacebookShareLink(FacebookShareLink facebookShareLink) {
		facebookShareLinks.add(facebookShareLink);
		facebookShareLink.setCourse(this);
	}
	
	
}
