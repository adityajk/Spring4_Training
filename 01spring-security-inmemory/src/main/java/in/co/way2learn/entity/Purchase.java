package in.co.way2learn.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
@Entity
@Table
public class Purchase implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	private String purchaseId;
	private boolean onlinePayment;
	private String status;
	private int price;
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;
	@Temporal(TemporalType.DATE)
	private Date expiryDate;
	private String machineId;
	private String machineSecret;
	private int refrralBonusAmount;
	private String purchaseType;
	private String referralEmail;
	private double conversionRate;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="email")
	private UserDetails userDetails;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="courseId")
	private Course course;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="couponCode")
	private CouponCode couponCode;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Testimonial testimonial;

	
	public void setConversionRate(double conversionRate) {
		this.conversionRate = conversionRate;
	}
	
	public double getConversionRate() {
		return conversionRate;
	}
	
	public void setReferralEmail(String referralEmail) {
		this.referralEmail = referralEmail;
	}
	public String getReferralEmail() {
		return referralEmail;
	}
	
	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}
	
	public String getPurchaseType() {
		return purchaseType;
	}
	
	public String getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}

	public boolean isOnlinePayment() {
		return onlinePayment;
	}

	public void setOnlinePayment(boolean onlinePayment) {
		this.onlinePayment = onlinePayment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	public String getMachineSecret() {
		return machineSecret;
	}

	public void setMachineSecret(String machineSecret) {
		this.machineSecret = machineSecret;
	}

	public int getRefrralBonusAmount() {
		return refrralBonusAmount;
	}

	public void setRefrralBonusAmount(int refrralBonusAmount) {
		this.refrralBonusAmount = refrralBonusAmount;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	public void addUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
		userDetails.getPurchases().add(this);
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
		//course.getPurchases().add(this);
	}
	
	public void addCourse(Course course) {
		this.course = course;
		course.getPurchases().add(this);
	}

	public CouponCode getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(CouponCode couponCode) {
		this.couponCode = couponCode;
	}

	public Testimonial getTestimonial() {
		return testimonial;
	}

	public void setTestimonial(Testimonial testimonial) {
		this.testimonial = testimonial;
	}
	
	public Purchase() {}

	public Purchase(String purchaseId, boolean onlinePayment, String status,
			int price, Date purchaseDate, Date expiryDate, String machineId,
			String machineSecret, int refrralBonusAmount,
			UserDetails userDetails, Course course, CouponCode couponCode,
			Testimonial testimonial) {
		this.purchaseId = purchaseId;
		this.onlinePayment = onlinePayment;
		this.status = status;
		this.price = price;
		this.purchaseDate = purchaseDate;
		this.expiryDate = expiryDate;
		this.machineId = machineId;
		this.machineSecret = machineSecret;
		this.refrralBonusAmount = refrralBonusAmount;
		this.userDetails = userDetails;
		this.course = course;
		this.couponCode = couponCode;
		this.testimonial = testimonial;
	}
	
}
