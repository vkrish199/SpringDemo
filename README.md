Spring works on a lot of configuration
The configurations can be based on following:
1. XML based
2. Java based
3. Annotation based

XML based:
Refer spring.xml - we need to define the beans here with id and class
These beans can be access from main using Application context instance
using ClassPathXmlApplicationContext
Dependency Injection - This will inject the dependency object into the class

By default, all the beans follow singleton scope, which means only 1 instance of the class
will be created, and it will be shared.
If we want a new object to be created everytime we use getBean method, we need to define
the bean with scope as prototype in the xml configuration.