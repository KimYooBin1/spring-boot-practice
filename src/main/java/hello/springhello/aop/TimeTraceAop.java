package hello.springhello.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect     //AOP에서 붙여줘야 된다
@Component
public class TimeTraceAop {

    @Around("execution(* hello.springhello..*(..))")   //어디에 적용할지 targeting 해준다. 범위 커스텀 가능. 지금은 패키지 하위에 있는 모든 class 의 메소드에 전부적용
    public Object execute(ProceedingJoinPoint joinPoint) throws  Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START: "+ joinPoint.toString());
        try{
            return joinPoint.proceed();
        }
        finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: "+ joinPoint.toString()+" "+ timeMs + "ms");
        }

    }
}
