package org.stamppyProject.businessLogic.aspect;

import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.stamppyProject.dataAccess.security.IAppLogDAO;
import org.stamppyProject.model.security.AppLog;


@Aspect
public class AppLogAspect {
	
	
	
	@Pointcut("call(* org.stamppyProject.businessLogic.business..*(..))")
	public void entryPoint1(){
		
	}
	@AfterReturning(pointcut="entryPoint1()", returning="result")
    public void afterPoint1(JoinPoint joinPoint, Object result) throws NamingException {
        AppLog applog = new AppLog();
        applog.setMethodName(joinPoint.getSignature().getName());
        applog.setDate(new Date());
        String cadenaArgs ="";
        if(joinPoint.getArgs()!=null){
        	int argsSize = joinPoint.getArgs().length;
        	for(int i=0; i<=argsSize-1;i++){
        		String tmp = joinPoint.getArgs()[i]!=null?joinPoint.getArgs()[i].toString():"";
            	cadenaArgs =cadenaArgs +" "+tmp;
            }
        	if(cadenaArgs.length()>254){
        		cadenaArgs = cadenaArgs.substring(0, 254);
        	}
        }      
        applog.setArguments(cadenaArgs);
        String resultCadena = "";
        if(result!=null){
        	resultCadena =result.toString();
        	if(resultCadena.length()>254){
        		resultCadena = resultCadena.substring(0, 254);
        	}
        	applog.setResult(resultCadena);
        }
        IAppLogDAO appLogDAO = (IAppLogDAO)InitialContext.doLookup("java:module/AppLogDAO");
        appLogDAO.saveLog(applog);
    }

}
