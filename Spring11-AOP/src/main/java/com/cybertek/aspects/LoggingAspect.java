package com.cybertek.aspects;

import com.cybertek.controller.ProductController;
import com.cybertek.entity.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Aspect
@Configuration
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

//    @Pointcut("execution(* com.cybertek.controller.ProductController.*(..))")
//    public void pointcut(){}
//
//    @Before("pointcut()")
//    public void log(){
//        logger.info("-------------");
//    }
//
//
//    @Before("execution(* com.cybertek.controller.ProductController.*(..))")
//    public void beforeAdvice(){
//        logger.info("-----------");
//    }
//

    //execution
    @Pointcut("execution(* com.cybertek.controller.ProductController.up*(..))")
    private void anyUpdateOperation(){}

    @Pointcut("execution(* com.cybertek.repo.ProductRepo.findById(Long))")
    private void anyProductRepositoryFindById(){}

    @Before("anyProductRepositoryFindById()")
    public void beforeProductRepoAdvice(JoinPoint joinPoint){
        logger.info("Before(findById) -> Method {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
    }

    @Before("anyUpdateOperation()")
    public void beforeControllerAdvice(JoinPoint joinPoint){
        logger.info("Before -> Method {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
    }

    //within
    @Pointcut("within(com.cybertek.controller..*)")
    private void anyControllerOperation(){

    }

    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void anyServiceAnnotatedOperation(){}

    @Before("anyServiceAnnotatedOperation()||anyControllerOperation()")
    public void beforeControllerAdvice2(JoinPoint joinPoint){
        logger.info("Before -> Method {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
    }
    //within
    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    private void anyDeleteProductOperation(){

    }
    @Before("anyDeleteProductOperation()")
    public void beforeControllerAdvice(){

    }
//after rturning
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetProductOperation(){

    }

    @AfterReturning(pointcut = "anyGetProductOperation()",returning = "results")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, Product results){
        logger.info("Before -> Method {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getSignature().toShortString(),results);
    }
    @AfterReturning(pointcut = "anyGetProductOperation()",returning = "results")
    public void afterReturningControllerAdvice2(JoinPoint joinPoint, List<Product> results){
        logger.info("Before -> Method {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getSignature().toShortString(),results);
    }
    //after throwing pointcut
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetPutOperation(){

    }
    @AfterThrowing(pointcut = "anyGetPutOperation()",throwing = "exception")
    public void afterContollerAdvice(JoinPoint joinPoint, RuntimeException exception){

    }

    //afteer
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetPutProductOperation2(){}











}
