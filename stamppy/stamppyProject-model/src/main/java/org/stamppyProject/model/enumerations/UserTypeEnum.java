package org.stamppyProject.model.enumerations;

public enum UserTypeEnum {
	
	ARTIST("artista"),
	CLIENT("cliente"),
	ADMIN("admin");
	
	private String userType;
	
	private UserTypeEnum(String userType) {
		this.userType=userType;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

}
