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
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println();
        System.out.println( "Hello World!" );

        //We are not actually creating the object here, we are only referring it
        Alien obj= (Alien)context.getBean("alien");
        //this will modify even obj1.age to 21 as only 1 object of alien will be created
        //It uses Singleton by default, so only 1 instance is created and is shared
        //To create a new object everytime, we need to change the scope to prototype
        obj.age = 21;
        System.out.println(obj.age);
//        obj.code();

        Alien obj1= (Alien)context.getBean("alien");
        System.out.println(obj1.age);
//        obj1.code();

    }
}
