package com.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class FeedbackVO {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int feedbackid;
	
	@Column(name="feedback")
	private String feedback;
	
	@ManyToOne
	private LoginVO fromid;
	
	@Column(name="date")
	private String complaindate;

	@Column(name="time")
	private String complaintime;
	
	public String getComplaindate() {
		return complaindate;
	}

	public void setComplaindate(String complaindate) {
		this.complaindate = complaindate;
	}

	public String getComplaintime() {
		return complaintime;
	}

	public void setComplaintime(String complaintime) {
		this.complaintime = complaintime;
	}

	

	public int getFeedbackid() {
		return feedbackid;
	}

	public void setFeedbackid(int feedbackid) {
		this.feedbackid = feedbackid;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public LoginVO getFromid() {
		return fromid;
	}

	public void setFromid(LoginVO fromid) {
		this.fromid = fromid;
	}

}
