package org.stamppyProject.model.enumerations;

public enum SizeEnum {
	
	XS("xs"),
	S("s"),
	M("m"),
	L("l"),
	XL("xl");
	
	private final String size;
	
	SizeEnum(String size){
		this.size=size;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	
	

}
