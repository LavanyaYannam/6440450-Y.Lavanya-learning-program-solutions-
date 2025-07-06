package exercise3;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();  // run the target method

        long end = System.currentTimeMillis();

        System.out.println("[AOP] Execution time of " + joinPoint.getSignature() + ": " + (end - start) + " ms");

        return result;
    }
}
