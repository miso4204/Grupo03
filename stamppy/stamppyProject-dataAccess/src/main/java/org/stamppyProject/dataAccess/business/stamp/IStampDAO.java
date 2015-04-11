package org.stamppyProject.dataAccess.business.stamp;

import java.util.List;

import javax.ejb.Local;

import org.stamppyProject.model.business.Stamp;

@Local
public interface IStampDAO {
	
	public void insertStamp(Stamp stamp);
	
	public void deleteStamp(Stamp stamp);
	
	public void updateStamp(Stamp stamp);
	
	public List<Stamp> getAvailableStamps();
	
	public Stamp getStamp(Long id);
}
