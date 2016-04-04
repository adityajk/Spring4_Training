package in.co.way2learn.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table
public class Testimonial implements Serializable {
	@Transient
	private transient static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="fg")	
	@GenericGenerator(name="fg",strategy="foreign",parameters={@Parameter(name="property",value="purchase")})
	private String testimonialId;
	
	
	
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="testimonial")
	//@PrimaryKeyJoinColumn(name="testimonialId",referencedColumnName="purchaseId")
	private Purchase purchase;
	private int rating;
	private String title;
	@Column(length=750)
	private String description;

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	
	public Testimonial() {}

	public Testimonial(Purchase purchase, int rating, String title,
			String description) {
		super();
		this.purchase = purchase;
		this.rating = rating;
		this.title = title;
		this.description = description;
	}

	public void addPurchase(Purchase purchase) {
		this.setPurchase(purchase);
		purchase.setTestimonial(this);
	}

	
}
