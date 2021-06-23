package com.atelier.common.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

import lombok.extern.log4j.Log4j;

/*
	AOP를 적용하는 3가지 방법
	1. Runtime 시점에서 적용 (Proxy 이용)
		1) JDK Proxy : Interface에 대한 proxy
		2) CGLB :  Class에 대한 proxy
	2. Complie 시점에서 적용 (AspectJ로 직접 구현)
*/

// 여기서는 AOP를 적용할 대상이 Controller 이므로 Dynamic Proxy 방식이 아닌 AspectJ를 이용하여 처리
@ControllerAdvice 
@Aspect
@Log4j
public class ControllerLoggerAdvice {
	
	// 1. 원하는 포인트 컷을 메소드로써 등록
	@Pointcut("execution(* com.atelier.*.controller.*.*(..)) || execution(* com.atelier.*.*.controller.*.*(..))")
	public void controllerLogger() {};
	
	// 2. AOP를 적용할 시점을 5가지의 annotation으로 구분하여 적용 @Before, @AfterRetuning, @AfterThrowing, @After, @Around
	// 각 annotation 마다 매개변수로 받는 타입이 달라진다.
	@Before("controllerLogger()")
	public void beforeLogPrint(JoinPoint joinPoing) throws Throwable{
		// JoinPoint란 advice가 적용될 수 있는 위치를 말함 (여기서는 target 오브젝트가 구현한 인터페이스의 모든 메소드는 JoinPoint가 된다)
		// @Before에서는 target에서 실행되는 메소드를 제어할 수 없으므로, 반환형이 void
		log.info(joinPoing.getSignature().getDeclaringTypeName()  + " - " + joinPoing.getSignature().getName() + ".run()");
	}
	
	//@Around("controllerLogger()")
	// 본 메소드는 예시로 작성해 둠
	public Object logPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		// JoinPoint란 advice가 적용될 수 있는 위치를 말함 (여기서는 target 오브젝트가 구현한 인터페이스의 모든 메소드는 JoinPoint가 된다)
		log.info(proceedingJoinPoint.getSignature().getName() + ".run()");
		return proceedingJoinPoint.proceed(); // 다음 advice를 실행하거나, target의 메소드를 실행;
	}
}
