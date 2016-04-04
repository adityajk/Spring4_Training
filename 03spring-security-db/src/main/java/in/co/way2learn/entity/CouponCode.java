package in.co.way2learn.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class CouponCode implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	private String couponCode;
	private int percentage;
	private String status;
	
	
	public CouponCode() {}

	public CouponCode(String couponCode, int percentage, String status) {
		super();
		this.couponCode = couponCode;
		this.percentage = percentage;
		this.status = status;
	}

	public CouponCode(String couponCode) {
		this.couponCode=couponCode;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public int getPercentage() {
		return percentage;
	}
	
	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
