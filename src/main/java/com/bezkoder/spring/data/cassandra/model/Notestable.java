package com.bezkoder.spring.data.cassandra.model;


import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;


@Table("notestable")
public class Notestable {
	

	  @PrimaryKey
	  private String notename;	  
	  private String note;
	  private  String createdate;
	  private  String updatedate;
	  private boolean deleted;
	  
	  public Notestable() {
		  
	}
	  
	  
	public Notestable(String notename, String note, String createdate, String updatedate, boolean deleted) {
		super();
		this.notename = notename;
		this.note = note;
		this.createdate = createdate;
		this.updatedate = updatedate;
		this.deleted = deleted;
	}
	
	
	public String getNotename() {
		return notename;
	}
	public void setNotename(String notename) {
		this.notename = notename;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	  
	  
	  
	  
	
	  
}
