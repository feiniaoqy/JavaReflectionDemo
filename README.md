#JavaReflection 反射的学习
##反射的概念
主要是指程序可以访问，检测和修改它本身状态或行为的一种能力，并能根据自身行为的状态和结果，调整或修改应用所描述行为的状态和相关的语义。反射是java中一种强大的工具，能够使我们很方便的创建灵活的代码，这些代码可以再运行时装配，无需在组件之间进行源代码链接。但是反射使用不当会成本很高！
##反射机制的作用
* 反编译：.class-->.java
* 通过反射机制访问java对象的属性，方法，构造方法等；
##反射机制中的类
* java.lang.Class;
* java.lang.reflect.Constructor;
* java.lang.reflect.Field;
* java.lang.reflect.Method;
* java.lang.reflect.Modifier;
##反射机制获取类有三种方法：
		/第一种方式：
        Class c1 = Class.forName("com.feiniaoqy.demo.Demo");
        //第二种方式：
        //java中每个类型都有class 属性.
        Class c2 = Demo.class;

        //第三种方式：
        //java语言中任何一个java对象都有getClass 方法
        Demo demo = new Demo();
        Class c3 = demo.getClass(); //c3是运行时类
##获取类后通过无参构造函数创建对象:
		Class c = Class.forName("com.feiniaoqy.demo.Demo");
        //创建此Class 对象所表示的类的一个新实例
        Demo demo1 = (Demo) c.newInstance();
* getDeclaredMethods()//获取所有的方法
* getReturnType()//获得方法的放回类型
* getParameterTypes()//获得方法的传入参数类型
* getDeclaredMethod("方法名",参数类型.class,……)//获得特定的方法
* getDeclaredConstructors()//获取所有的构造方法
* getDeclaredConstructor(参数类型.class,……)//获取特定的构造方法
*  getSuperclass()//获取某类的父类
*  getInterfaces()//获取某类实现的接口
