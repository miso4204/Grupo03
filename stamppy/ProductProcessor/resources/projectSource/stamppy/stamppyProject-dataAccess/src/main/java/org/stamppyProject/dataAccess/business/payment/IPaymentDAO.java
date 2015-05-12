package org.stamppyProject.dataAccess.business.payment;

import org.stamppyProject.model.business.Payment;

public interface IPaymentDAO {
	
	public void savePayment(Payment payment);
}
