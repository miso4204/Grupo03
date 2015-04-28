package org.stamppyProject.model.security;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.stamppyProject.model.enumerations.UserTypeEnum;



@Entity
@Table(name="Usr")
@NamedQueries({
@NamedQuery(name="user.findAll", query="SELECT u FROM User u"),
@NamedQuery(name="user.findByUsername", query="SELECT u FROM User u WHERE u.username = :username"),
@NamedQuery(name="user.findUserByType", query="SELECT u FROM User u WHERE u.userType=:userType"),
@NamedQuery(name="user.findByUsernamePassword", query="SELECT u FROM User u WHERE u.username = :username and u.password=:password")
}) 
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String name;
	
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private UserTypeEnum userType;


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	@JsonIgnore
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userType
	 */
	public UserTypeEnum getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserTypeEnum userType) {
		this.userType = userType;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
