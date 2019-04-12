package com.bysj.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 描述:
 *
 * @author liuchong
 */
public class InvocationHandlerDome implements InvocationHandler {
    private Object subject;

    public InvocationHandlerDome(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before Method");
        System.out.println("Call Method:" + method);
        Object object = method.invoke(subject, args);
        System.out.println("After method");
        System.out.println();

        return proxy;
    }
}
