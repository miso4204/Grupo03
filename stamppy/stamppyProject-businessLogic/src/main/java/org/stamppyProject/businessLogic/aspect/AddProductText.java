package org.stamppyProject.businessLogic.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.stamppyProject.businessLogic.business.product.dto.ProductJson;
import org.stamppyProject.model.business.Product;

@Aspect
public class AddProductText {
	
	@Pointcut("call(* Product.*(..))")
    public void entryPoint1() {
    }
	
	@Pointcut("call(* ProductJson.*(..))")
    public void entryPoint2() {
    }


	@AfterReturning(pointcut="entryPoint1()", returning="result")
    public void afterPoint1(JoinPoint joinPoint, Object result) {
        Product product = (Product)result;
        ProductJson productJson = (ProductJson)joinPoint.getArgs()[0];
        product.setText(productJson.getText());
    }
	
	@AfterReturning(pointcut="entryPoint2()", returning="result")
	public void afterPoint2(JoinPoint joinPoint, Object result) {
        ProductJson productJson = (ProductJson)result;
        Product product = (Product)joinPoint.getArgs()[0];
        productJson.setText(product.getText());
    }
}
