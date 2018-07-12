package org.ny.aop.aspact;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Performance {

    @Pointcut("execution(* org.ny.aop.Board.BoardService.getBoards(..))")
    public void getBoards(){

    }

    @Pointcut("execution(* org.ny.aop.User.UserService.getUsers())")
    public void getUsers(){

    }

    @Around("getBoards() || getUsers()")
    public Object calculatePerformanceTime(ProceedingJoinPoint proceedingJoinPoint){
        Object result = null;
        try{
            long start = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();

            System.out.println("수행 시간 : " + (end - start));
        }catch(Exception e){
           e.printStackTrace();
        } catch (Throwable throwable) {
            System.out.println("exception! ");
        }

        return result;
    }

}
