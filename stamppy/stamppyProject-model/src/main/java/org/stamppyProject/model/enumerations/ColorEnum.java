package org.stamppyProject.model.enumerations;

public enum ColorEnum {
	
	RED("rojo"),
	BLUE("azul"),
	YELLOW("amarillo"),
	GREEN("verde"),
	WHITE("blanco"),
	BLACK("negro");
	
	private String color;
	
	private ColorEnum(String color) {
		this.color=color;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	
}
