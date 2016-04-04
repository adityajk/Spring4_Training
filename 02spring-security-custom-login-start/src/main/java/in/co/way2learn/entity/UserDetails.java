package in.co.way2learn.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
@Entity
@Table
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails{
	@Transient
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	private String email;
	private String familyName;
	private String location;
	@Temporal(TemporalType.DATE)
	private Date dob;
	private String accessToken;
	private String bio;
	private String id;
	private String fullName;
	private int accountBalance;
	private int totalEarnedAmount;
	private String occupation;
	private String status="Inactive";
	private String referredBy;
	private String password;
	private String gender;
	private String profileLink;
	private String imageLocation;
	private String relationWithReferredBy;
	@Transient
	private String refrralBonusAmount;
	
	private String phoneNumber;
	private String role;
	private boolean accountNonExpired=true;
	private boolean accountNonLocked=true;
	private boolean credentialsNonExpired=true;
	private boolean enabled=true;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="userDetails")
	//@JoinColumn(name="email")
	private List<Purchase> purchases;
	
	@ManyToMany(mappedBy="allUserDetails")
	private List<Training> trainings;
	
	
	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}
	public List<Training> getTrainings() {
		return trainings;
	}
	public List<Purchase> getPurchases() {
		return purchases;
	}
	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setTotalEarnedAmount(int totalEarnedAmount) {
		this.totalEarnedAmount = totalEarnedAmount;
	}
	public int getTotalEarnedAmount() {
		return totalEarnedAmount;
	}
	
	public UserDetails(String email) {
		this.email = email;
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRelationWithReferredBy(String relationWithReferredBy) {
		this.relationWithReferredBy = relationWithReferredBy;
	}
	public String getRelationWithReferredBy() {
		return relationWithReferredBy;
	}
	
	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public String getPassword() {
		return password;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getOccupation() {
		return occupation;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfileLink() {
		return profileLink;
	}
	public void setProfileLink(String profileLink) {
		this.profileLink = profileLink;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public UserDetails() {}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<SimpleGrantedAuthority> tempAuthorities=new ArrayList<SimpleGrantedAuthority>();
		if(role.contains(",")){
			String[] roles=role.split(",");
			for(String r:roles){
				tempAuthorities.add(new SimpleGrantedAuthority(r));
			}
		}else{
			tempAuthorities.add(new SimpleGrantedAuthority(role));
		}
		return tempAuthorities;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public String getBio() {
		return bio;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getRole() {
		return role;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
	
	
	public UserDetails( String fullName, String email,String status,
			String refrralBonusAmount,String relationWithReferredBy) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.status = status;
		this.refrralBonusAmount = refrralBonusAmount;
		this.relationWithReferredBy=relationWithReferredBy;
	}
	
	/*public UserDetails( String fullName, String email,String status,
			int refrralBonusAmount) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.status = status;
		this.refrralBonusAmount = refrralBonusAmount+"";
	}*/
	public UserDetails(String email, String familyName, String location,
			Date dob, String accessToken, String bio, String id,
			String fullName, int accountBalance, int totalEarnedAmount,
			String occupation, String status, String referredBy,
			String password, String gender, String profileLink,
			String imageLocation, String relationWithReferredBy,
			String phoneNumber, String role, boolean accountNonExpired,
			boolean accountNonLocked, boolean credentialsNonExpired,
			boolean enabled, Address address, List<Purchase> purchases) {
		this.email = email;
		this.familyName = familyName;
		this.location = location;
		this.dob = dob;
		this.accessToken = accessToken;
		this.bio = bio;
		this.id = id;
		this.fullName = fullName;
		this.accountBalance = accountBalance;
		this.totalEarnedAmount = totalEarnedAmount;
		this.occupation = occupation;
		this.status = status;
		this.referredBy = referredBy;
		this.password = password;
		this.gender = gender;
		this.profileLink = profileLink;
		this.imageLocation = imageLocation;
		this.relationWithReferredBy = relationWithReferredBy;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
		this.address = address;
		this.purchases = purchases;
	}
	public String getRefrralBonusAmount() {
		return refrralBonusAmount;
	}
	public void setRefrralBonusAmount(String refrralBonusAmount) {
		this.refrralBonusAmount = refrralBonusAmount;
	}
	
	
		
}
