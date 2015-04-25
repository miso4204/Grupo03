package org.stamppyProject.businessLogic.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.stamppyProject.businessLogic.business.product.dto.ProductJson;
import org.stamppyProject.model.business.Product;

@Aspect
public class AddProductColor {
	
	@Pointcut("call(* *.convertToProduct(..))")
    public void entryPoint1() {
    }
	
	@Pointcut("call(* *.convertToProductJson(..))")
    public void entryPoint2() {
    }


	@AfterReturning(pointcut="entryPoint1()", returning="result")
    public void afterPoint1(JoinPoint joinPoint, Object result) {
        Product product = (Product)result;
        ProductJson productJson = (ProductJson)joinPoint.getArgs()[0];
        product.setColor(productJson.getColor());
        System.out.println("SIRVIOOOOO, producto: "+product.getText()+", "+product.getColor());
    }
	
	@AfterReturning(pointcut="entryPoint2()", returning="result")
	public void afterPoint2(JoinPoint joinPoint, Object result) {
        ProductJson productJson = (ProductJson)result;
        Product product = (Product)joinPoint.getArgs()[0];
        productJson.setColor(product.getColor());
        System.out.println("SIRVIOOOOO, productJson: "+productJson.getText()+", "+productJson.getColor());
    }

}
