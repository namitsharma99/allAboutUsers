package com.code.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_session")
public class UserSession {

	@Column(name = "session_no")
	private int sessionNo;

	@Id
	@Column(name = "session_id")
	private String sessionId;

	@Column(name = "session_start")
	private Timestamp sessionStart;

	@Column(name = "session_end")
	private Timestamp sessionEnd;

	@Column(name = "session_time")
	private Timestamp sessionTime;

//	@OneToOne(mappedBy = "userSession")
//	private User user;
	@Column(name = "user_id")
	private String userId;

	public int getSession_no() {
		return sessionNo;
	}

	public void setSession_no(int session_no) {
		this.sessionNo = session_no;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Timestamp getSessionStart() {
		return sessionStart;
	}

	public void setSessionStart(Timestamp timestamp) {
		this.sessionStart = timestamp;
	}

	public Timestamp getSessionEnd() {
		return sessionEnd;
	}

	public void setSessionEnd(Timestamp sessionEnd) {
		this.sessionEnd = sessionEnd;
	}

	public Timestamp getSessionTime() {
		return sessionTime;
	}

	public void setSessionTime(Timestamp sessionTime) {
		this.sessionTime = sessionTime;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public int getSessionNo() {
		return sessionNo;
	}

	public void setSessionNo(int sessionNo) {
		this.sessionNo = sessionNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserSession [sessionNo=" + sessionNo + ", sessionId=" + sessionId + ", sessionStart=" + sessionStart
				+ ", sessionEnd=" + sessionEnd + ", sessionTime=" + sessionTime + ", userId=" + userId + "]";
	}

}
