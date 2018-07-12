package org.ny.aop.aspact;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.ny.aop.History.History;
import org.ny.aop.History.HistoryRepository;
import org.ny.aop.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component // @Bean과 동일하게 Spring Bean 등록 어노테이션
public class UserHistroy {

    @Autowired
    private HistoryRepository historyRepository;

    @Pointcut("execution(* org.ny.aop.User.UserService.update(*)) && args(user)")
    public void updateUser(User user){

    }

    @AfterReturning("updateUser(user)")
    public void saveHistory(User user){
        historyRepository.save(new History(user.getIdx()));
    }

}
