/**
 * 
 */
package com.chandra.aopapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	/**
	 * Declaring before advice 
	 * @param jp
	 * @throws Throwable
	 */
	//@After("execution(* com.chandra.aopapp.service.*.*(..))") // after advice with pointcut expression directly
	@After("logForAllMethods()") //after advice with name pointcut that declared as name logForAllMethods()
	public void afterAdviceForAllMethods(JoinPoint jp) throws Throwable {
        System.out.println("****LoggingAspect.afterAdviceForAllMethods() " + jp.getSignature().getName());
    }
	
	/**
	 * Declaring after advice for all transfer methods whose taking three arguments of any type 
	 * of all classes in the package com.doj.aopapp.service
	 * @param jp
	 * @throws Throwable
	 */
	@After("execution(* com.chandra.aopapp.service.*.transfer(*,*,*))")
	public void afterAdviceForTransferMethods(JoinPoint jp) throws Throwable {
        System.out.println("****LoggingAspect.afterAdviceForTransferMethods() " + jp.getSignature().getName());
    }
	
	/**
	 * Declaring named pointcut
	 */
	@Pointcut("execution(* com.chandra.aopapp.service.*.*(..))")
	public void logForAllMethods(){}
}
