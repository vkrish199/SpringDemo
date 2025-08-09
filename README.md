Spring works on a lot of configuration
The configurations can be based on following:
1. XML based
2. Java based
3. Annotation based

Note that in this project we will use XML based configuration

XML based:
Refer-springInitialWithScopes method
Refer spring.xml - we need to define the beans here with id and class
These beans can be access from main using Application context instance
using ClassPathXmlApplicationContext
Dependency Injection - This will inject the dependency object into the class

By default, all the beans follow singleton scope, which means only 1 instance of the class
will be created, and it will be shared.
If we want a new object to be created everytime we use getBean method, we need to define
the bean with scope as prototype in the xml configuration.

Setter Injection - refer setterInjection method
We can define properties in beans with property tag with name and value
this will be set when the object is created by calling setter method

Reference Attribute - refer referenceAttribute method
When we want to access another class object in the class
we define it as a property in the bean tag however, instead of using value,
we need to use a ref and point it to the bean id of the class we want to refer

Constructor Injection - refer constructorInjection method
Instead of property tag we can use constructor-arg tag to define params in the same
sequence , we can use both value and ref.
If we don't want to worry about the order or sequence, we can use the type attribute
<constructor-arg value="21" type="int"/>
<constructor-arg ref="laptop" type="com.varun.Laptop" />
But this will also not work if there are more than 1 variable of the same type
We can solve it by using index:
<constructor-arg ref="laptop" index="1"/>
<constructor-arg value="21" index="0"/>
We have another solution : directly use variable names, but this again needs order:
<constructor-arg name="age" value="21"/>
<constructor-arg name="lap" ref="laptop"/>
Best way is to use index
We can also use @ConstructorProperties annotation if we don't care about the order
Ex:
@ConstructorProperties({"age", "lap"})
public Alien(int age, Laptop lap) {
this.age = age;
this.lap = lap;
}

Creating Interface - refer interfaceExample method

We can use autowire="byName" in order for spring to automatically inject
the dependencies
ref property takes precedence over autowire

Autowiring can be done in 2 ways:
byName - automatically resolves variable name with the matching bean id (we can only
have 1 bean defined with that id)
byType - automatically resolves based on the type of the variable with the class of
the bean, here as well we can only have one bean defined with the matching type

Lazy init bean: refer lazy_bean_init method
if we use lazy-init="true" in the bean definition, the object won't get created
automatically until we ask for it
When a non-lazy bean is dependent on lazy bean, the object will get created

GetBean by type - refer getBeanByType method
If we don't want to typecast we can use get bean this way:
context.getBean("alien", Alien.class);
we can also use
context.getBean(Computer.class); in this case we need to have either one of the 
matching beans marked as primary or we need to have only 1 matching bean


Inner Bean - refer to innerBean method
