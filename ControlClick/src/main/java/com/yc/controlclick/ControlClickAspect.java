package com.yc.controlclick;

import android.view.View;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author by CNKIFU on 2020/6/12.
 */
@Aspect
public class ControlClickAspect {

    @Pointcut("execution(@com.yc.controlclick.ControlClick * *(..))")
    public void methodAnnotated() {
    }

    @Around("methodAnnotated()")
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        View view = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof View) {
                view = (View) arg;
                break;
            }
        }
        if (view == null) {
            return;
        }
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        if (!method.isAnnotationPresent(ControlClick.class)) {
            return;
        }
        ControlClick controlClick = method.getAnnotation(ControlClick.class);
        if (!ClickUtil.isFastDoubleClick(view, controlClick.value())) {//判断是否是快速点击,不是就放行
            joinPoint.proceed();
        }
    }
}