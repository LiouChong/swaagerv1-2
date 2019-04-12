package com.bysj.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 描述:
 *
 * @author liuchong
 */
public class Client {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        InvocationHandler handler = new InvocationHandlerDome(realSubject);
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
        System.out.println(subject.getClass().getName());
        subject.hello("Hello");
        String result = subject.bye();
        System.out.println("Result is : "  + result);
    }
}
