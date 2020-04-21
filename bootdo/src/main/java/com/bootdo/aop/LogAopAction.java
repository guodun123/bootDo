package com.bootdo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LogAopAction {
    //配置接入点,如果不知道怎么配置,可以百度一下规则
    @Pointcut("@annotation(com.bootdo.aop.Log)")
    private void anyMethod(){

        System.out.println("log记录------------------------");
    }//定义一个切入点

    @Before("anyMethod() && args(name)")
    public void doAccessCheck(String name){
        System.out.println(name);
        System.out.println("前置通知--------------------------");
    }

    @AfterReturning("anyMethod()")
    public void doAfter(){
        System.out.println("后置通知-------------------------");
    }

    @After("anyMethod()")
    public void after(){
        System.out.println("最终通知---------------------------");
    }

    @AfterThrowing("anyMethod()")
    public void doAfterThrow(){
        System.out.println("例外通知-----------------------------------");
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("进入环绕通知------------------------------");
        Object object = pjp.proceed();//执行该方法
        System.out.println("退出方法--------------------");
        return object;
    }
}
