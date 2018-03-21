package Temp.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HouseOwnerProxy implements InvocationHandler{

    private Owner houseOwner;

    public HouseOwnerProxy(Owner houseOwner) {
        this.houseOwner = houseOwner;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = proxy.getClass().getName();
//        System.out.println(name);
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(houseOwner, args);
        long endTime = System.currentTimeMillis();
        System.out.println(method.getName() + "方法一共消耗了: " + (endTime - startTime) + "毫秒");
        return result;
    }
    public Owner getOwnerProxy(){
        return(Owner) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                HouseOwner.class.getInterfaces(),this);
    }
}
