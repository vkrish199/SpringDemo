package com.varun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        //This needs spring framework maven dependency
        //It creates a spring container
        //All the objects will be created here for all the bean tags which are of singleton prototype
        //It does not create objects for prototype scope beans
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");
//        new App().springInitialWithScopes(context);
//        new App().setterInjection(context);
//        new App().referenceAttribute(context);
//        new App().constructorInjection(context);
//        new App().interfaceExample(context);
//        new App().primaryBeanExample(context);
//        new App().lazyBeanInit(context);
//        new App().getBeanByType(context);
        new App().innerBean(context);
    }

    public void innerBean(ApplicationContext context) {
        Alien obj = context.getBean("alien", Alien.class);

        System.out.println(obj.getAge());
        obj.code();
    }

    public void getBeanByType(ApplicationContext context) {
        Alien obj = context.getBean("alien", Alien.class);

        System.out.println(obj.getAge());
        obj.code();
        Computer obj2 = context.getBean(Computer.class);
        Desktop obj1 = context.getBean(Desktop.class);
    }

    public void lazyBeanInit(ApplicationContext context) {
        Alien obj = (Alien) context.getBean("alien");
        System.out.println(obj.getAge());

        obj.code();
        //because com2 bean is defined as lazy init true, the object gets created
        //only after running below code
//        Computer desk = (Desktop)context.getBean("com2");
    }

    public void primaryBeanExample(ApplicationContext context) {
        Alien obj = (Alien) context.getBean("alien");
        System.out.println(obj.getAge());
        obj.code();
    }

    public void interfaceExample(ApplicationContext context) {
        Alien obj = (Alien) context.getBean("alien");
        System.out.println(obj.getAge());
        obj.code();
    }

    public void constructorInjection(ApplicationContext context) {
        Alien obj = (Alien) context.getBean("alien");
        obj.code();
    }

    public void referenceAttribute(ApplicationContext context) {
        Alien obj = (Alien)context.getBean("alien");
        System.out.println(obj.getAge());
        obj.code();
    }

    public void setterInjection(ApplicationContext context) {
        Alien obj = (Alien)context.getBean("alien");
        //the age 21 is set from XML bean property
        System.out.println(obj.getAge());
        obj.code();
    }

    public void springInitialWithScopes(ApplicationContext context) {
        System.out.println();
        System.out.println( "Hello World!" );

        //For Singleton We are not actually creating the object here, we are only referring it
        Alien obj= (Alien)context.getBean("alien");
        //this will modify even obj1.age to 21 as only 1 object of alien will be created
        //It uses Singleton by default, so only 1 instance is created and is shared
        //To create a new object everytime, we need to change the scope to prototype
        obj.setAge(21);
        System.out.println(obj.getAge());
        obj.code();

        Alien obj1= (Alien)context.getBean("alien");
        System.out.println(obj1.getAge());
        obj1.code();
    }
}
