**Spring Core framework**

Dependency injection:
You have 2 classes: Bike, Car But in future it may change and I want objects of either Bike/ Car in your controller and you don’t care which one it is. In this case, you want to abstract out them to Vehicle class and have spring provide you the object whichever is available automatically. This is called loose coupling.

Note: new Somthing(); -> dependency

interface Vehicle {
Void drive();
}

class Bike implements Vehicle {
Public drive() {
….
}
}

class Car implements Vehicle {
public drive() {
….
}
}

myConfigs.xml

<?xml version=“1.0” encoding=“UTF-8” ?>

<beans
xmlns=“....” # can be found online
xmlns:xsi=“....”
xsi:schemaLocation=“….” >
<bean 
	id=“vehicle” class=“com.abc.project.Car”></bean> # in future if we want to change the class, we can just change it here, no need to change the source code. This is helpful because we don't need to recompile again.
</beans>

Class App {
psvm(String[] args) {
ApplicationContext context = new ClassPathXmlApplicationContext(“myConfigs.xml”);
Vehicle obj = (Vehicle)context.getBean(“vehicle”); // ApplicationContext or BeanFactory. ApplicationContext is superset of BeanFactory
obj.drive();
}
}

1. xml based config - Above example
2. Annotation based -
   You need to add 2 lines - xmlns:context= , some link in xsi:schemaLocation for adding spring-context
   And you can remove <bean> tags in myConfigs.xml
   and add <context:component-scan base-package="com.abc.project"></context:component-scan>
   You can add @Component on top of your Car/Bike class

   But then you have to again mention the bean you want by-
   Vehicle obj = (Vehicle)context.getBean("bike");

3. Java config -

Note: Suppose your class has a property, you can set the value of that property from xml too-
ex.
class Bike {
String brand;
public drive() {

}
}

in myConfigs.xml-
<beans xmlns=“....”
xmlns:xsi=“....”
xsi:schemaLocation=“….”>
<bean id=“vehicle” class=“com.abc.project.Car”>
<property name="brand" value="BMW"></property>
</bean>
</beans>

**Constructor Injection:**
Suppose your class has a property, and you want to set its value use constructor

class Bike {
String brand;

public Bike(String brand) {
super();
this.brand = brand;
}
public drive() {
}
}

in myConfigs.xml-
<beans xmlns=“....” # can be found online
xmlns:xsi=“....”
xsi:schemaLocation=“….”>
<bean id=“vehicle” class=“com.abc.project.Car”>
<constructor-arg value="BMW"></constructor-arg>
</bean>
</beans>

**Autowired Injection**
class Bike {

@Autowired
Tyre tyre;

public getTyre() {
return tyre;
}

public setTyre(Tyre tyre) {
this.tyre = tyre;
}

public drive() {
}
}

2 ways -

1. XML based config-
   in myConfigs.xml-
   <beans xmlns=“....” # can be found online
   xmlns:xsi=“....”
   xsi:schemaLocation=“….”>
   <bean id=“vehicle” class=“com.abc.project.Car”>
   <constructor-arg value="BMW"></constructor-arg>
   </bean>

<bean id="tyre" class="com.abc.project.Tyre"></bean>
</beans>

2. Using Annotation -
   @Component on top of public class Tyre {}

**Annotationbased config**

public class Samsung{
@Autowired
MobileProcessor mp;

public MobileProcessor getMobileProcessor() {
return mp;
}
public void setMobileProcessor(MobileProcessor mp) {
this.mp = mp;
}

public void config()
{
System.out.println("Octa Core, 4 gb Ram, 12MP camera");
}
}

interface MobileProcessor {
void process();
}
public class Snapdragon implements MobileProcessor {
public void process() {
sout("processing....");
}
}

@Configuration
public class AppConfig {

@Bean
public Samsung getPhone() // Name of this method can be anything
{
return new Samsung();
}

@Bean
public MobileProcessor getProcessor()
{
return new Snapdragon();
}
}

in App.java-
public class App {
psvm(String[] args) {
ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
Samsung s7 = factory.getBean(Samsung.class);
s7.config();
}
}

If you don't want to manually mention Beans of all the dependencies:

1. Use @Component for all the dependencies
2. Remove all the beans in AppConfig and add @ComponentScan(basePackages="com.abc.project")
3. If you have multiple classes implementing a interface, you need to use @Primary on top of the class you want to prefer among all the classes or other way is you can mention along with @Autowired: @Qualifier("snapdragon") // bean name of the class you want to prefer for this particular object.
