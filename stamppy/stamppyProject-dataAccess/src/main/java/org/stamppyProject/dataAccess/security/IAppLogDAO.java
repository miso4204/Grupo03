package org.stamppyProject.dataAccess.security;

import org.stamppyProject.model.security.AppLog;

public interface IAppLogDAO {
	
	public AppLog saveLog(AppLog applog);

}
