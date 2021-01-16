package com.code.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Column(name = "s_no")
	private int s_no;

	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_contact")
	private String userContact;

	@Column(name = "user_country")
	private String userCountry;

	@Column(name = "technology")
	private String technology;

//    @OneToOne(cascade = CascadeType.ALL)
////    @JoinTable(name = "user_session", 
////    joinColumns = 
////      { @JoinColumn(name = "user_id", referencedColumnName = "user_id") },
////    inverseJoinColumns = 
////      { @JoinColumn(name = "session_no", referencedColumnName = "session_no") })
//    @JoinColumn(name = "sessionId", referencedColumnName = "sessionId")
//	private UserSession userSession;

	@Column(name = "age")
	private int age;

	
	
	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	public UserSession getUserSession() {
//		return userSession;
//	}
//
//	public void setUserSession(UserSession userSession) {
//		this.userSession = userSession;
//	}

	@Override
	public String toString() {
		return "User [s_no=" + s_no + ", userId=" + userId + ", userName=" + userName + ", userContact=" + userContact
				+ ", userCountry=" + userCountry + ", technology=" + technology
				+ ", age=" + age + "]";
	}

}