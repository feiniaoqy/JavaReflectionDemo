package com.feiniaoqy.demo;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import sun.rmi.runtime.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by asus on 2016/4/16.
 */

public class Reflection {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/ReflectionDemo/src/reasource/log4j.properties");
        Logger log= Logger.getLogger(Log.class);
        Demo demo = new Demo();
        //获取对象名称
        log.info(demo.getClass().getName());
        Class c = null;
        try {
            c = Class.forName("com.feiniaoqy.demo.Demo");
            //创建此Class 对象所表示的类的一个新实例
            Demo demo1 = (Demo) c.newInstance();
            log.info(demo1.s);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //获取方法
        Method method[]=c.getMethods();
        for(int i=0;i<method.length;++i){
            Class<?> returnType=method[i].getReturnType();
            Class<?> para[]=method[i].getParameterTypes();
            int temp=method[i].getModifiers();
            log.info(Modifier.toString(temp)+" ");
            log.info(returnType.getName()+"  ");
            log.info(method[i].getName()+" ");
            log.info("(");
            for(int j=0;j<para.length;++j){
                log.info(para[j].getName()+" "+"arg"+j);
                if(j<para.length-1){
                    log.info(",");
                }
            }
            //获取异常类型
            Class<?> exce[]=method[i].getExceptionTypes();
            if(exce.length>0){
                log.info(") throws ");
                for(int k=0;k<exce.length;++k){
                    log.info(exce[k].getName()+" ");
                    if(k<exce.length-1){
                        log.info(",");
                    }
                }
            }else{
                log.info(")");
            }
            log.info("\n");
        }


        //调用类中的方法
        try {
            Method method2=c.getMethod("printNameAndAge", String.class,int.class);
            method2.invoke(c.newInstance(),"Rollen",20);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
