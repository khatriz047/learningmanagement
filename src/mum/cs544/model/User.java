package mum.cs544.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "user")
@SecondaryTables(@SecondaryTable(name = "profile", pkJoinColumns = {
		@PrimaryKeyJoinColumn(name = "profile_id", referencedColumnName = "id") }))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;
	private boolean active;
	private boolean resetRequest;

	@Column(table = "profile")
	private String prefix;
	@Column(table = "profile")
	@NotEmpty
	private String firstname;
	@Column(table = "profile")
	private String lastname;
	@Column(table = "profile")
	@Email(message = "Please provide a valid email address")
	@Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
	private String email;
	@Column(table = "profile")
	private String usernumber;
	@Column(table = "profile")
	private String imageUrl;
	@Column(table = "profile")
	private String contactNumber;
	@Column(table = "profile")
	private String staffInformation;
	@Column(table = "profile")
	private String studentInformation;
	@Column(table = "profile")
	private String city;
	@Column(table = "profile")
	private String state;
	@Column(table = "profile")
	private String zip;
	@Column(table = "profile")
	private String address;
	@Column(table = "profile")
	private String country;
	@Column(table = "profile")
	private String homeCountry;
	@Column(table = "profile")
	@Temporal(value = TemporalType.DATE)
	private Date enrolledDate;
	@Transient
	private boolean error = false;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Role> roles = new HashSet<>();

	//relation with resource
	@OneToMany
	private Set<Resources> resource = new HashSet<>();

	public User() {

	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getStaffInformation() {
		return staffInformation;
	}

	public void setStaffInformation(String staffInformation) {
		this.staffInformation = staffInformation;
	}

	public String getStudentInformation() {
		return studentInformation;
	}

	public void setStudentInformation(String studentInformation) {
		this.studentInformation = studentInformation;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHomeCountry() {
		return homeCountry;
	}

	public void setHomeCountry(String homeCountry) {
		this.homeCountry = homeCountry;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public Date getEnrolledDate() {
		return enrolledDate;
	}

	public void setEnrolledDate(Date enrolledDate) {
		this.enrolledDate = enrolledDate;
	}

	public boolean isResetRequest() {
		return resetRequest;
	}

	public void setResetRequest(boolean resetRequest) {
		this.resetRequest = resetRequest;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

}
