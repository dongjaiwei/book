package com.dongjiawei.tree_hold.aop.aspect;

import com.dongjiawei.tree_hold.dto.MyResponse;
import com.dongjiawei.tree_hold.entity.UserInfo;
import com.dongjiawei.tree_hold.entity.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LoginAspect {
    @Autowired
    private UserService userService;

    @Pointcut("@annotation(com.dongjiawei.tree_hold.aop.action.LoginAction)")
    public void controllerAspect() {
    }


    @Around("controllerAspect()")
    public MyResponse around(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String token = request.getHeader("token");
        System.out.println(token);
        UserInfo user = userService.getUserFromToken(token);
        System.out.println(user);
        MyResponse proceed = (MyResponse) pjp.proceed();
        if (user == null) {

            proceed.setData(null);
            proceed.setCode(406);
            proceed.setMessage("用户未登录");
        }
        return proceed;
    }


}
