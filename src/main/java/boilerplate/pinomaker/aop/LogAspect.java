package boilerplate.pinomaker.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
@Aspect
@Slf4j
public class LogAspect {
    @Pointcut("within(boilerplate.pinomaker.controller.*)")
    public void controller() {
    }

    @Before("controller()")
    public void beforeRequest(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String url = request.getRequestURI();
        String method = request.getMethod();

        log.info("{} : {}", method, url);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Map) {
                Map<String, String[]> paramMap = (Map<String, String[]>) arg;
                paramMap.forEach((key, value) -> log.info("Request Param : {} : {}", key, String.join(", ", value)));

                return;
            } else {
                log.info("Request Body : {}", arg.toString());

                return;
            }
        }
    }

    @AfterReturning(pointcut = "controller()", returning = "returnValue")
    public void afterReturningLogging(JoinPoint joinPoint, Object returnValue) {
        if (returnValue == null) return;

        log.info("Response : {}", returnValue.toString());
    }
}
