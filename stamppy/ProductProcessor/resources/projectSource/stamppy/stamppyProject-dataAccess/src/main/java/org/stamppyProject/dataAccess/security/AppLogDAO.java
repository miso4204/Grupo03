package org.stamppyProject.dataAccess.security;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.stamppyProject.model.security.AppLog;

@Stateless
public class AppLogDAO implements IAppLogDAO {
	
	@PersistenceContext(unitName = "stamppyPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

	@Override
	public AppLog saveLog(AppLog applog) {
		em.persist(applog);
		return applog;
	}

}
