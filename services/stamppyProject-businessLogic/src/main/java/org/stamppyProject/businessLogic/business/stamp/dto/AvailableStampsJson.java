package org.stamppyProject.businessLogic.business.stamp.dto;

import java.util.List;

public class AvailableStampsJson {
	
	private int numberStamps;
	
	private List<StampJson> stamps;

	/**
	 * @return the numberStamps
	 */
	public int getNumberStamps() {
		return numberStamps;
	}

	/**
	 * @param numberStamps the numberStamps to set
	 */
	public void setNumberStamps(int numberStamps) {
		this.numberStamps = numberStamps;
	}

	/**
	 * @return the stamps
	 */
	public List<StampJson> getStamps() {
		return stamps;
	}

	/**
	 * @param stamps the stamps to set
	 */
	public void setStamps(List<StampJson> stamps) {
		this.stamps = stamps;
	}
	
	

}
