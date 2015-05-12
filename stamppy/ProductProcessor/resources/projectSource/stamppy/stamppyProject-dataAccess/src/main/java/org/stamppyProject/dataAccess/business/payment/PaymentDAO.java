package org.stamppyProject.dataAccess.business.payment;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.stamppyProject.model.business.Payment;

@Stateless
public class PaymentDAO implements IPaymentDAO{
	
	@PersistenceContext(unitName = "stamppyPU", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;
	
	@Override
	public void savePayment(Payment payment) {
		em.persist(payment);
		
	}
}
