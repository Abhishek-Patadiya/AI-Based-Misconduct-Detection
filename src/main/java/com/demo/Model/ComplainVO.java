package com.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="complain")
public class ComplainVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int complainid;
	
	@Column(name="subject")
	private String complainsubject;
	
	@Column(name="description")
	private String complaindescription;
	
	@Column(name="reply")
	private String replydescription;
	
	@Column(name="status")
	private String complainstatus;
	
	@Column(name="date")
	private String complaindate;

	@Column(name="time")
	private String complaintime;
	
	@Column
	private String fileName;

	@Column
	private String filePath;
	
	@ManyToOne
	private LoginVO fromId;
	
	@ManyToOne
	private LoginVO toId;
	
	
	public LoginVO getFromId() {
		return fromId;
	}

	public void setFromId(LoginVO fromId) {
		this.fromId = fromId;
	}

	public LoginVO getToId() {
		return toId;
	}

	public void setToId(LoginVO toId) {
		this.toId = toId;
	}

	public String getReplydescription() {
		return replydescription;
	}

	public void setReplydescription(String replydescription) {
		this.replydescription = replydescription;
	}

	public String getComplainstatus() {
		return complainstatus;
	}

	public void setComplainstatus(String complainstatus) {
		this.complainstatus = complainstatus;
	}

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

	public int getComplainid() {
		return complainid;
	}

	public void setComplainid(int complainid) {
		this.complainid = complainid;
	}

	public String getComplainsubject() {
		return complainsubject;
	}

	public void setComplainsubject(String complainsubject) {
		this.complainsubject = complainsubject;
	}

	public String getComplaindescription() {
		return complaindescription;
	}

	public void setComplaindescription(String complaindescription) {
		this.complaindescription = complaindescription;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

		
}
