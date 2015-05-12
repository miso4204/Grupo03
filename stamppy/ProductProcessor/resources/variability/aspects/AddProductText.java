package org.stamppyProject.businessLogic.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.stamppyProject.businessLogic.business.product.dto.ProductJson;
import org.stamppyProject.model.business.Product;

@Aspect
public class AddProductText {
	
	@Pointcut("call(org.stamppyProject.model.business.Product *.*(org.stamppyProject.businessLogic.business.product.dto.ProductJson))")
    public void entryPoint1() {
    }
	
	@Pointcut("call(org.stamppyProject.businessLogic.business.product.dto.ProductJson *.*(org.stamppyProject.model.business.Product))")
    public void entryPoint2() {
    }


	@AfterReturning(pointcut="entryPoint1()", returning="result")
    public void afterPoint1(JoinPoint joinPoint, Object result) {
        Product product = (Product)result;
        ProductJson productJson = (ProductJson)joinPoint.getArgs()[0];
        product.setText(productJson.getText());
        System.out.println("Add text - entry1, producto: "+product.getText());
    }
	
	@AfterReturning(pointcut="entryPoint2()", returning="result")
	public void afterPoint2(JoinPoint joinPoint, Object result) {
        ProductJson productJson = (ProductJson)result;
        Product product = (Product)joinPoint.getArgs()[0];
        productJson.setText(product.getText());
        System.out.println("Add text - entry2, producto: "+product.getText());
    }
}
