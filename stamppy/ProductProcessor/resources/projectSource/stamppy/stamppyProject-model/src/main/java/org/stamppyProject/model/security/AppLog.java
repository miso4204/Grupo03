package org.stamppyProject.model.security;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AppLog
 *
 */
@Entity

public class AppLog implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	private String methodName;
	private String arguments;
	private String result;
	private Date date;
	private static final long serialVersionUID = 1L;

	public AppLog() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getMethodName() {
		return this.methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}   
	public String getArguments() {
		return this.arguments;
	}

	public void setArguments(String arguments) {
		this.arguments = arguments;
	}   
	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
   
}
