package AOP_Package;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Pointcut
    @Pointcut("execution(* AOP_Package.OrderService.*(..))")
    public void serviceMethods(){}

    // 1️⃣ Before Advice
    @Before("serviceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before Method Started: " + joinPoint.getSignature().getName());
    }

    // 2️⃣ After Advice (always executes)
    @After("serviceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After Method Finished: " + joinPoint.getSignature().getName());
    }

    // 3️⃣ AfterReturning Advice (only when method succeeds)
    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("Method Successfully Executed: " + joinPoint.getSignature().getName());
        System.out.println("Return Value: " + result);
    }

    // 4️⃣ AfterThrowing Advice (only when exception occurs)
    @AfterThrowing(pointcut = "serviceMethods()", throwing = "ex")
    public void logAfterException(JoinPoint joinPoint, Exception ex) {
        System.out.println("Exception in method: " + joinPoint.getSignature().getName());
        System.out.println("Exception message: " + ex.getMessage());
    }

    // 5️⃣ Around Advice (before + after control)
    @Around("serviceMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("Around Before Method: " + joinPoint.getSignature().getName());

        Object result = joinPoint.proceed(); // calls actual method

        System.out.println("Around After Method: " + joinPoint.getSignature().getName());

        return result;
    }
}