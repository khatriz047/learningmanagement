package mum.cs544.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name = "user")
@SecondaryTables(@SecondaryTable(name = "profile", pkJoinColumns = {
		@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id") }))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
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
	private String firstname;
	@Column(table = "profile")
	private String lastname;
	@Column(table = "profile")
	private String email;
	@Column(table = "profile")
	private String usernumber;
	@Column(table = "profile")
	private String imageUrl;
	@Column(table = "profile")
	private String contactNumber;
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
	private Date effectivedate;
	@Column(table = "profile")
	@Temporal(value = TemporalType.DATE)
	private Date terminationdate;
	@Transient
	private boolean error = false;

	@LazyCollection(LazyCollectionOption.FALSE)
	/* @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) */
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<>();

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

	public void addRole(Role role) {
		this.roles.add(role);
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

	public Date getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}

	public Date getTerminationdate() {
		return terminationdate;
	}

	public void setTerminationdate(Date terminationdate) {
		this.terminationdate = terminationdate;
	}

	public String getFullName() {
		return prefix + " " + firstname + " " + lastname;
	}

}
