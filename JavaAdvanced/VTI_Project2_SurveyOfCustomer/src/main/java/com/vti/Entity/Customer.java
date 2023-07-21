package com.vti.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Customer", catalog = "SurveyOfCustomer")
public class Customer implements Serializable {
	@Column(name = "CustomerID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	@Column(name = "Email", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "Username", length = 50, nullable = false, unique = true)
	private String username;

	@Column(name = "FullName", length = 50, nullable = false)
	private String fullname;

	@Column(name = "AvatarImageName", length = 50, unique = true)
	private String avatarImageName;

	@Column(name = "Mobile", length = 50, nullable = false, unique = true)
	private String mobile;

	@Column(name = "Address", length = 100, nullable = false, unique = true)
	private String address;

	@Column(name = "Password", length = 100, nullable = false)
	private String password;

	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAvatarImageName() {
		return avatarImageName;
	}

	public void setAvatarImageName(String avatarImageName) {
		this.avatarImageName = avatarImageName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

//	public Customer(short id, String email, String username, String fullname, String avatarImageName, String mobile,
//			String address, String password, Date createDate) {
//		super();
//		this.id = id;
//		this.email = email;
//		this.username = username;
//		this.fullname = fullname;
//		this.avatarImageName = avatarImageName;
//		this.mobile = mobile;
//		this.address = address;
//		this.password = password;
//		this.createDate = createDate;
//	}

}
