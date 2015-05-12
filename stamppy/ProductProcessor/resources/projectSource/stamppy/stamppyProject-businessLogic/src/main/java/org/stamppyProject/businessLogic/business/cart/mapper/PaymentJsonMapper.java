package org.stamppyProject.businessLogic.business.cart.mapper;

import org.stamppyProject.businessLogic.business.cart.dto.PaymentJson;
import org.stamppyProject.model.business.Payment;

public class PaymentJsonMapper {
	
	public static PaymentJson convertToPaymentJson(Payment payment){
		PaymentJson paymentJson = new PaymentJson();
		paymentJson.setId(payment.getId());
		paymentJson.setPrice(payment.getPrice());
		paymentJson.setStatus(payment.getStatus());
		paymentJson.setType(payment.getType());
		return paymentJson;
	}
	
	public static Payment convertToPayment(PaymentJson paymentJson){
		Payment payment = new Payment();
		payment.setPrice(paymentJson.getPrice());
		payment.setType(paymentJson.getType());
		return payment;
	}

}
