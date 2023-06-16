Original repo: https://github.com/jcbyBharath/java-beginner-programs/tree/feature/Ticket-1-java-oops-concepts

Class: it is a blueprint which contains some properties and some methods.
Object: is an instance of a class. Constructor will allocate memory for the object in heap.

OOPS concepts:

1. Encapsulation - capsule - binding properties and methods together. Ex. private properties and public getters and setters to achieve data hiding. If you don't want others to set value of a variable, you will have private setter
2. Abstraction - hiding implementation details. Can be achieved in 2 ways - abstract classes and interfaces. abstract classes can have both method declarations and method definitions. But interfaces can only have method declarations. For interfaces you don't even need to add public abstract infront of method names, it will be added automatically by compiler.

Note: We can't create an instance of an interface. But this can be done-
interface ABC {
void m1(); // public abstract void m1();
}

ABCImple implements ABC {
void m1() {
sout("m1");
}
}

ABCImple a = new ABCImple();

3. Inheritance -
   types:
   single - A-B
   multilevel - A-B-C
   hierarchical - A-B, A-C
   multiple - not supported in java directly
   hybrid - not supported in java directly

parent class / parent/ base
child class / sub / derived

super() is called from child class constructor

4. Polymorphism -
   method overloading - same method name but signatures(parameters - datatype and number) are different
   method overriding - inheritance - same method and signature but different implementation - you are re-implementing again in the child class.

**conditional and loop statements**
if
if elseif
if else
switch
while - entry controlled
do while - it is exit controlled. It will execute atleast once
for - entry controlled

**getters and setters:**
public class Person {
private String name; // private = restricted access

// Getter
public String getName() {
return name;
}

// Setter
public void setName(String newName) {
this.name = newName;
}
}

If static keyword is used with variable/method, memeory is allocated during compilation itself. So, they belong to the class. We don't need an instance.

JUnit for unit testing
You need two dependencies for Junit: junit, hamcrest. typically, you do not need to install them again, they're included. You can import them directly.

Note: Intellij

THere are two types of constructors:

1. default constructor
2. parameterized constructor

Note: static properties can be accessed without any instance
eg.
class A {
static int a;

    static int b;
    static int add(int a, int b) {
        return a+b;
    }

}

sout(A.a); // 0
sout(A.b); // 0
sout(A.add(10,20)); // 30

Encapsulation
Binding varaibles and methods together is called as Encapsulation
PRimary goal of Encapsulation is data hiding using getters and setters.

Inheritance
5 types

Apr 26
try{

}
catch(Exception1){

}
catch(Exception2) {

}
finally{

}

Error: Suppose if your stack is full, you'll get StackOverflow error. It is a system resource problem.
You cannot handle errors since It does not depend on your program.
Ex. StackOverflow, OutofMemory, VirtualMachine error....

Exception: An exception is an unexpected/unwanted event, which occurs during the execution of a program, that disrupts the normal flow of the program's instructions.

types:

1. checked exceptions - compiletime exceptions- they should be handled in compile time only (when you write the code itself) because the code would not be compiled if you don't handle the exception. It is checked because you already know about the exception.
   ex. FileNotFound exception, IO, SQL
2. unchecked exceptions - runtime exceptions - You don't need to handle it mandatorily
   ex. ArrayIndexOutOfbounds exception, ArithmeticException, NullPointerException

Handling exceptions (both checked and unchecked):

1. Using try catch block - there can be multiple catch blocks for a try block

Or

2. throws keyword - you can mention in the method's first line itself - not actual handling, you're just saying it will throw an exception.

Note: If you use a method which throws an exception in another method, you need to either declare using throws or use try catch.

Note: If you don't handle it even in the main method, JVM is going to print in the console about the exception (only if the exception actually occurs).

**Creating a Custom Exception -**
class TestException extends Exception {
public TestException() {
super();
}
public TestException(String message) {
super(message);
}
public TestException(String message, Throwable exp) {
super(message, exp);
}
}

**throw**: If you want to throw a new exception (existing or custom) -
throw new ArithmeticException();

throw vs throws:
throw - to throw a new exception
throws - declare at method level that it throws an exception

Unchecked Exceptions / RuntimeExceptions:

1. NullPointerException
   String num; // null
   num.substring(2,4); // NullPointerException because you're trying to access null value
   num.length(); // NullPointerException

   // So, you can use Optional
   Optional<String> num;

2. ArithmeticException - Divide by 0

finally block:
Code inside this block gets executed irrespective of any exceptions that occur.
finally block use case:
Every database has limited number of connections. Suppose a database can only have 30 users access it. So, you can write code to close the connection in finally block.

Object class is the parent of all classes

**Generics**
Generics means parameterized types. The idea is to allow type (Integer, String, … etc., and user-defined types) to be a parameter to methods, classes, and interfaces.

Iterator - Since Iterable is extended by Collection and Collection is imported by List, Queue, Set... Iterator can be used on all the Collections.

Internal implementation of ArrayList uses Array. The main difference between array and ArrayList is ArrayList is dynamic (memory allocation) - based on a load factor as soons as more than 3/4th of the space gets used up, it will double the size of the ArrayList. Usually, the load factor is 0.75.

**Collections**

Iterable interface
|
Collection interface
|
List, Set, Queue interfaces

Imp Note: Collection is an interface. Collections is a utility class (since it has utility functions like sort())
import java.util.Collections;
Collections.sort(names);

1. List properties
   can contain duplicate values
   can have multiple null values
   Maintains insertion order

   a. ArrayList
   b. LinkedList
   c. Stack
   d. Vector

2. Set properties
   contains unique elements
   can only contain one null value since it has unique elements
   does not maintain insertion order

   a. HashSet -
   b. LinkedHashSet - maintains insertion order
   c. SortedSet - implementation is Treeset - sorts elements

3. Map
   keys must be unique. So, we have keySet()
   Entries are also unique. So, we have entrySet()
   Each entry contains 4 things: key, value, hashcode of key, address of next element
   a. HashMap
   b. LinkedHashMap
   c. SortedMap - implementation is TreeMap - sorts based on keys.

ArrayList<Integer> a = new ArrayList<>();

1. for(Integer i : arr) {
   sop(i);
   }

2. Iterator

**ArrayList vs Vector**
If multiple people are working on an ArrayList, the changes cannot be predicted. So, ArrayList is not thread safe(not synchronized). But Vector is synchronized. So, there is lock mechanism in Vectors.

ArrayList allows null values an duplicates. And it stores in contiguous memory allocation.

HashSet does not maintain insertion order
LinkedHashSet maintains insertion order and it has unique elements.
TreeSet by default will have elements sorted in ascending order

hashCode(), toString(), equals(), wait() are all present in Object class. They can be overridden using @Override

For String comparison, always go with s1.equals(s2)

**HashMap internal working**
It stores in key, value format.
HashMap internally stores (key,value,hashcode of key,address of next element) in each bucket. Each bucket in HashMap can have multiple nodes. All keys of the HashMap should be unique. Address of next element is initially null.
How does HashMap store? - It creates hashcode using a hashing function -> (key%hashtable_size) and store the node there. And it does the same thing for retrieval too to find the bucket number. And If multiple elements are present in the chain, it will compare hashcodes to find the exact node.

Initial table size is 16.

Since Hashtable is dynamic too. It uses load factor of 0.75 too.

**Operations after put()**
Whenever you use m.put(1, "microsoft")
First, you send the key to hashing function to generate hashcode (lets say 12345678)
Now, hashcode %16 (%tablesize) is computed and based on the result, lets say 5, it will place the Node (1, "microsoft", 12345678, null) at index 4.

If two nodes get same index (bucket number) - then the first element will replace null with the address of the new element.
Note: For same key, hashing function will generate same hash code.
**get()**
hashCode() and equals() contract
First, it passes the key to hashing function to generate hashcode (**hashcode()**). hashcode%16 is done to get bucket number where the element was stored. Now, it will compare if the hashcodes match. If they match(**equals()**), it will then compare the keys. And if that also matches, then it will return the value

**Collision handling-**

1. Chaining - linked list - used in hashmap
2. Open addressing - element is stored in the hashtable itself.

Note: Interface is a contract where the implementing class needs to implement all of the methods in the interface.

1. Lamda expressions - introduced in java 8
2. Functional Interfaces - SAM - Single Abstract Method - An interface which contains only one method is called as Functional Interface

Java 8 (1.8)features:

1. default methods - interfaces can have default methods with implementations:
   interface ABC {
   public void m1();
   default int add(int a, int b) {
   return a+b;
   }
   }
   This is added because if there is interface I with a method add() and interfaces I1, I2, I3 also have add() with same implementation. So, it is better to implement default add() in interface I only so that we don't need to re-implement it in sub-interfaces.
2. Functional interfaces - SAM - single abstract method - interface with only one function (method)
   advantage of Functional interfaces - we can remove boiler plate code (like method name, return type, datatypes of arguments ) of the abstract method using lambda expression in the implementing class.
   public interface MFI {
   int add(int a, int b);
   }

   implementation using a seperate class -
   public class MainClassImplementation implements MFI {
   public int add(int a, int b) {
   return a+b;
   }
   }

   implementation using anonymous inner class - inner class because we're creating a class inside another class (MainClass) -

   public class MainClass {
   psvm(String[] args) {
   MFI m = new MFI() {
   public int add(int a, int b) {
   return a+b;
   }
   };
   }
   }

   implementation using lambda expression -
   public class MainClass {
   psvm(String[] args) {
   MFI m = (a,b) -> {return a+b;};
   sout(m.add(1,2)); // 3
   }
   }

   Note: We can also use @FunctionalInterface annotation - from java.lang.
   Note: lambda expression (->) is same arrow function in javascript (=>)

   There are 4 functional interfaces provided by Java:

   1. consumer - the method accept takes input but does not return anything
   2. supplier - the method get does not take any input but returns something
   3. function - the method apply takes input and returns something
   4. predicate - it is a function but it returns boolean

   Special cases of functional interfaces:
   BiConsumer, BiFunction, BiPredicate - all these have methods that accept two arguments

   variants of Function:
   UnaryOperator - datatype of argument and return value are same
   BinaryOperator - datatype of both both arguments and the return type are all same

   1. consumer
      interface Consumer {
      void accept(int a);
      }
   2. supplier
      interface Supplier {
      public abstract int get();
      }
   3. function
      interface Function {
      public abstract int apply(int a);
      }
   4. predicate
      interface Predicate {
      public abstract boolean test(int a);
      }

Assignment - resources/companies.txt

Note: for loop and enhanced for loop is an external loop. forEach is an internal loop. forEach() was introduced in java 8
forEach() is a default method added to Iterable interface in Java 8. It takes Consumer object as input. It executes accept() in Consumer interface for each element in the List.
ex. ForEach.java

Note: Function.identity() is same as e->e. It takes an input and returns the same element.
Note:
If there is only 1 statement in the lambda expression: we can remove flower braces. We can also remove the return keyword if the only statement happens to be a return statement.

3. Method reference: Short hand of already short hand Lambda expressions
   System.out::println() // :: means method reference
   Note: System.out::println is a replacement for e -> System.out.println(e)
   3 types:

   1. constructor reference - used when a new instance(Object) is being returned
   2. static method reference
   3. instance method reference - 2 types:
   arbitrary object method reference, particular object method reference
   <!-- 4. direct-instance reference method - using existing class -->

4. Stream API - vvvv Imp
   Returns Stream<T>.
   source: set of data (it can be collection, array, I/O stream....)

   Intermediate operations are optional and there can be multiple intermediate operations.
   On the data, you can apply **intermediate operations:**

   1. filter,
   2. map,
   3. flatMap - it is actually not a Map- it is for List of Lists - [[1,2], [3,4]] -> [1,2,3,4]
   4. distinct,
   5. sorted
   6. skip(n) - skips first element till nth index (including nth index) element
   7. limit(n) -
   8. peek(e -> System.out.println(e)) - used for debugging

   And then you can apply **terminal operations -**

   1. collect - collects into a bucket using Collectors - .collect(Collectors.toList()), collect(Collectors.toSet()),collect(Collectors.toMap(k,v)), collect(Collectors.joining("-")) - returns String and here "-" is the delimeter, it joins all the elements with the delimeter between all the elements. Collectors.partitioningBy(), Collectors.groupingBy(e -> e.key()),
      Collectors.allMatch(), noneMatch(), anyMatch() - shortcircuit operations - they return Boolean(true/false)
   2. min,
   3. max,
   4. count...

   In Collectors.toMap(k,v), suppose if there are duplicate keys, it gives error. So, we need to manage this conflicts. So, if we want to replace the old value of the key with new value for the duplicate keys:
   Ex. Map<String, Integer> m = names.stream()
   .collect(Collectors.toMap(e -> e, e -> e.length(), (oldvalue, newvalue) -> newvalue))

   Collectors.partitioningBy() - checks the elements on a condition and returns a Map<Boolean, List<T>> with 2 elements:
   true, []
   false, []

   Collectors.groupingBy() - grouping all elements based on some key which have same value together and returns a Map<DatatypeOfKey, List<T>-
   ex. [A(aa) , B(bb), C(cc), D(dd), E(aa), F(bb)] - groupBy - [aa, ] , [bb, bb] , [cc] , [dd]

   Note: What if no element gets filtered:
   Optional<String> nameOptional = names.stream ()
   .filter (e -> e.startsWith ("A"'))
   .findAny();
   System.out .println (nameOptional); // Optional.empty if element is not present
   System.out.println (nameOptional.isPresent ()? nameOptional.get(): "Not Found");

   String nameOptional = names.stream ()
   .filter (e -> e.startsWith ("A"'))
   .findAny()
   .orElse(null)

   filter takes predicate as input
   map takes function as input

   ex. numbers.stream()
   .filter(e -> e%2==0) // intermediate operation
   .map(e -> e\*2) // intermediate operation
   .forEach(System.out::println) // terminal operation

   ArrayList<Integer> numbers = Arrays.asList(1,2,3,4,5);

   Properties of stream -

   1. Can only go from beginning to end
   2. Once you use it, you can no longer use the same stream
   3. It will not affect the source

Note: Streams are lazy. Since, if there is no terminal operation, it does not perform any of the intermediate operations. Until it encounters terminal operation, it does not perform intermediate operations.

Styles of coding -

1.  Imperative - loops, iterators
2.  Declarative - streams

**Comparator vs Comparable**
Comparator is a Functional Interface (FI)
Comparator - compare(,) - returns int -

      1.  public int compare(String s1, String s2) {
         return s1.compareTo(s2);
         }

Comparable - compareTo() -> for strings: s1.compareTo(s2) -> compares with the current instance. So, it takes only one argument.
Ex.
Collections.sort(names); // natural order
// natural order using comparator
Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
// reverse order
Collections.sort(names, (o1, o2) -> o2.compareTo(o1));
// reverse order for integers
Collections.sort(names, (o1, o2) -> o2-o1);

Note:
If the list is small, use List.of()
Otherwise, use Arrays.asList()

Note: Convert array of primitive type to List
int[] primitiveArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
List‹Integer> integerList = Arrays.stream(primitiveArray).boxed().collect(Collectors.toList());

There are 2 types of streams:

1. bounded - fixed number of elements - List
2. infinite - 2 methods are used to generate it- it is like infinite loop
   1. Stream.iterate() - Ex. Stream.iterate(0, i->i+1).forEach(sop) - 0,1,2,3,4.....
   2. Stream.generate() - Ex. Stream.generate(() -> new Random().nextInt(1000)).limit(20).collect(Collectors.toList()); // 767, 988,......

`**Spring**`

1. .jar file - java archive. It is a collection of .class files.

Suppose you want to export all the files in your project. Then you can create a jar file which contains class files of all the files in your project and in a different project, you can add this jar file as a dependency in the build path.

2. .war file - web archive. It is a collection of different type of UI files (.html, .js, .css, .properties, .xml, .java .....)

3. .ear file - enterprise archive. Same like war but has additional complex files like .ejb, .bpal.....

- it is heavy weight file

**maven | gradle** -

1. build management tool - they are used to package (build) the entire application and create jar/war/ear file.
2. It also takes care of dependency management.

Maven has a central repository (Maven repository on internet) - (remote repository) - which contains .jar files of different libraries.

local repository -(.m2 folder - in Windows, it is present in C/Users) - repository on our machine - when you build the app, when installing the dependencies, first it will check this folder, if not, it will check private repository of the company, if not, then maven will fetch them from remote repository (central repo) and place them in this folder and then fetch from this folder.

building - like compile - creating jar file

libraries - have .jar files - which have .class files
**pom.xml:**
Every maven project has this file.
If there is pom.xml file, that means it is a maven project.
It contains list of dependency
pom - project object model

Each dependency has:
group id - com.something.something
artifact id - artifact -> project name
version number - major.minor.patch

Spring is a framework

- it is a collection of jars

**UI application architecture:**
Frontend(UI) - Backend -(asks for data from)- Database
or
Frontend - Backend -(asks for data from) - Another webservice

This anotehr webservice can have different tech stack like .Net. So, we need protocol for these 2 web services to communicate with each other.

**Protocols for communication between 2 webservices:**

1. SOAP - Simple Object Access Protocol - xml format - .wsdl/ .xsd files
2. REST - Representational State Transfer - JSON format (JavaScript Object Notation)
   REST endpoint example - /hello

wsdl file- web service description language - xml file which contains how many input and output variables are needed and their datatypes

Any page on the web will have an IP address & port and this IP address will be mapped to a domain name using DNS mapping.

**HTTP status codes:**
1xx - shows some information
2xx - success
3xx - redirection error
4xx - client side issue
5xx - server side issue

HTTP methods - CRUD operations -
Create - POST
Read - GET
Update - PUT
Delete - DELETE

Note: To securely send data using POST instead of sending it through URL, we send it through Request Body.

All the compiled files will be placed in target folder
**spring commands:**
clean
package
install
compile

mvn -install -> To check maven version

mvn clean -> deletes target folder
mvn compile -> checks if all the classes can be compiled or not
mvn package -> compile all the classes and also place the jar file in target folder
mvn install -> compiles all the classes and places the jar file in .m2 folder - useful when you're using this project as a dependency in another project
mvn clean package -> cleans and packages
mvn clean install -> cleans and installs

Last 2 commands are most used

Dependencies used: Spring Web

The java version mentioned in the pom.xml and the java version of the machine where the app is being compiled must be same.

default IP address of localhost: 127.0.0.1
default port of tomcat: 8080
To change the port:
server.port=8081
In application.properties: -> this file is used for configurations
We can also use .yaml file for configurations. yaml more human readable.
Ex.
In application.properties:
server.port=8081
project.owner.name=gautham

In .yaml:
server
--port: 8081 -> here I have added -- instead of space. 2 spaces are added.
project
--owner -> 2 spaces
----name:gautham -> here there are 4 spaces total

SDLC:
requirements
development env -> local testing/ JUnit testing
testing: dev, SIT (System Integration Testing)/QA (Quality Assurance) -> QAs will test here, UAT (User acceptance testing) -> Business users test here
pre-prod -> Beta users test here
prod

Configurable properties: properties that change for every environment -> placed in application.properties file
Dev env, SIT env, QA env will all have different DBs. Each DBs will be serving on different ports.

Profiles:
application.properties -> default profile
application-<>.properties:
application-local.properties
application-dev.properties
application-qa.properties
application-uat.properties
application-prod.properties

To change profile in Intellij:
Goto Add configuration:
click on +
select maven
under profiles: mention local/dev/qa/uat/prod whichever one you want to run as the profile

Code structure:
Controller (endpoint) - Service (Business logic) - Repository - DB
or
Controller (endpoint) - Service (Business logic) - another Web-service (SOAP/ REST) - DB
or
Controller (endpoint) - Service (Business logic) - Message queue (kafka) - DB

Different packages for each of these should be created: controller, service, repository

Reading values from application.properties:
In application.properties:
db.name="mydb ipaddress"

In code:
@Value("${db.name}")
String dbname;

**Path params and Query params In a GET request:**

1. www.bestbuy.com/details/123 -> 123 is /{productID}/ - 123 is called Path param/ Path variable
   @GetMapping("/details/{id}")
   public String details1(@PathVariable Integer id){
   return "Id: " + id;
   }
2. www.bestbuy.com/details?productid=123 - 123 is called Query param/ Request param
   @GetMapping("/details")
   public String details2(@RequestParam Integer id){
   return "Id: " + id;
   }

   If you want to send multiple attributes, you use &.
   **POST request:**
   Note: It is not compulsory to send data if you're using POST/GET request. It is just expected that you send data when you're using POST, since it is a Create request.
   Data can be sent through two ways:

3. Headers -
   headers:
   {
   "customName" : "John"
   }
   @PostMapping("/details")
   public String details_post(@RequestHeader("customName") String name){
   return "Id: " + name;
   }
4. Request body
   body - JSON -
   {
   "address1": "a1",
   "address2": "a2",
   "address3": "a3",
   "state": "knjad",
   "city": "abcd",
   "zipcode": "1321"
   }

   @PostMapping("/details")
   public Address details_post(@RequestBody("customName") Address addr){ // all the variables in this class (Address) need to be passed
   return address;
   }

**DELETE request**
Same like GET request, we can send id through Query param/ PathVariable
Suppose we're sending the id of the record that we need to delete through query param:
@DeleteMapping("/details")
public String details2(@RequestParam Integer id){
return "Deleted record";
}

**PUT request**
Same like POST request, we need to send through header/request body which has all the values to which a record needs to be modified:
eg. Using request body:
@PutMapping("/details")
public String details2(@RequestBody Address add){
return "updated the record";
}

Swagger:
Suppose you're using a web-service to get/post data and it has multiple endpoints. To know what those endpoints are and what datatypes they're expecting and what data they're going to return, they provide all of these details through Swagger_url.

Previously, spring had Swaggerfox, which had 2 dependencies that you need to add (same dependency name but different artifact IDs):

1. Swagger2
2. Swagger_ui

@EnableSwagger2()

Now, you can just add 1 dependency:
springdoc_Openapi_starter_webmvc_ui -> artifact name

@OpenApiDefinition(info=@Info(title="Company API", version="1.0.0")) -> This is added at the Main class, i.e, below @SpringApplication()

Swagger endpoint will be automatically created:
http://localhost:8080/swagger-ui/index.html
or
http://localhost:8080/swagger-ui.html

Swagger UI sort of shows like documentation of all the endpoints of your website. You can use this page to view and also execute the requests directly there. It will also show you the curl commands that it is executing to get the response.

CURL - Client URL

**Missed class - May 30**

Dependency injection:

1. Field injection: @Autowired above variable
2. constructor injection - @Autowired above a parameterized constructor
3. Setter injection

@Qualifier - if there is an interface and there are multiple implementations of it

Stereotype annotations:

1. Component - To let Spring know that a class is available for injection, we add @Component on top of the class. For example we can use this in Service classes. But it will be better to use @Service for Service classes.
2. Controller - It uses DTO (Data Transfer Object). DTOs will be returned to the client.
3. Service
4. Repository - It uses Entity object/ DAO (Data Access Object) - You should not send this object as it is to service layer since it should not be revealed to the client. So, we use a Mapper which will take DAO(Entity) and returns DTO.

**Converting String to JSON object/ JSON object to String:**
Suppose you call a web service(REST endpoint) from another web service(REST endpoint), we might get the response as String but it is actually a JSON object/ List of objects.

To convert from String to JSON objects/ List of JSON objects, we can use ObjectMapper.readValue(stringValue, new TypeReference<List<Employee>>(){})

To convert from JSON object/ List of JSON objects to String, we can use ObjectMapper.writeValueAsString(employeesObject) // check once

**Scopes:**
singleton(default) and prototype scopes are most used and sometimes request scope is used.
ex. @Scope(value="prototype")

1. singleton scope - for spring, default scope is singleton. For any injection(field/setter/constructor), it will only create one instance and wherever you inject, it will return the same object.
2. prototype scope - every time you request for an instance, it will create a new instance and return it.
3. Request scope - for any bean under the same request(HttpRequest), one instance will be created and the same instance will be used
4. Session scope - for any bean under the same session, one instance will be created and the same instance will be used. It is from login to logout.
5. Application scope - for any bean under the same Application context, one instance will be created and the same instance will be used
6. Websocket scope -

Session is created to maintain state(storing attributes) of the user.

**Exception Handling in Spring boot applications:**
If any runtime exception occurs in the backend(spring), spring will not send the user what exception occured. It will only send 500 Internal Server error but it doesnot give exact reason to the user.

Suppose you have a table in database with 1 column having UNIQUE constraint. But if you're trying to insert duplicate elements, it will give you UniqueConstraintException.

If there is no handler, it will send 500 Internal Server error. Otherwise, it will first check if there is any @ControllerAdvice and check if there is any handler for that exception and call it.
All the excpeptioms are handled using:

1. @ControllerAdvice - class level - on top of your exception handler
2. The class also needs to extend ResponseEntityExceptionHandler
3. @ExceptionHandler(ExceptionName.class) - method level - your exception handler should extend ResponseEntityExceptionHandler and you should write a method which returns ResponseEntity<String>

@ComponentScan - spring will scan from the base package and search for all classes which are declared using @Component

**Mockito:**
All the things for which you use @Autowired, you can mock using @Mock
JUnit - @Test

**JPA:**
DataBase servers - MySQL, Oracle, PostGres, SyBase.... All these will have different kind of drivers.
Previously, **JDBC** (Java to DataBase Connectivity) was used connecting java to database. Steps in JDBC:

1. register and load drivers(whichever SQL server you're going to connect to)
2. Establish connection (connection URL, username, password)
3. write SQL statements (SELECT, UPDATE, DELETE)
4. execute SQL statements
5. Results will be returned as ResultSet.

Disadvantages of using JDBC:
you write your own queries. Suppose you have to shift from MySQL to Oracle db, you'd have rewrite all the queries to match Oracle DB's syntax.

This all was done before **ORM** (Object Relational Mapping) came into picture.
ORM - Data JPA, Hibernate
JPA Specification - specification (list of interfaces)
Hibernate - is a framework which implemented JPA specifications.

In ORM, you don't need to write SQL statements and execute them. ORM will generate them in the background.
Object - classes - they exist in Java
Relational - table - they exist in Database
Mapping - Mapping between classes and tables.

Entity - corresponding classes of tables are called as Entities - @Entity
@Entity
class Person {
private String fName;
private String lName;
private String email;
}

Table - with columns:
fName
lName
email

For the ORM to uniquely identify each record, there needs to be a Primary Key. Primary Key (Unique, Not NULLL) is mandatory for ORM.

To declare a column as primary key:

1. we need to declare it as NOT NULL, auto_increment.
2. Also mention in the end that the column is PRIMARY KEY: primary key (address_id)

To declare a column as foreign key:

1. we need mention in the end that the column is FOREIGN KEY using references

Mapping multiple tables:
Table_1 Company:
c_id, c_name, c_ein, c_ticker, c_address_id

create table company (
c_id int not null auto_increment,
c_name varchar(100),
c_ein int,
c_ticker varchar(10),
c_address_id int,
primary key c_id,
foreign key (c_address_id) references address(address_id)
);

Note: address_id is the foreign key in the company table. Primary key of One table can be foreign key in another table

Table_2 Address:
address_id, add1, add2, add3, city, state, zipcode

create table address (
address_id int not null auto_increment,
add1 varchar(100),
add2 varchar(10),
add3 int,
city varchar(100),
state varchar(100),
zipcode int,
primary key address_id,
);

The mapping between these tables can be 1:1 (one-to-one)

Q. Insert values into address table?
insert into address(add1, add2, add3, city, state, zipcode) values('a1', 'a2', 'a3', 'djn', 'an', 12345);

Q. Get distinct cities in address table?
select distinct city from address;

Q. Updating record
update company set column_2 = 'jnada' where companyId=3;

Q. Mapping / Join. Give company id, company name, address id, address zipcode?
The two tables can be joined using the common column - address_id

select c.c_id, c.c_name, a.address_id, a.zipcode from company c join address a on c.c_address_id = a.address_id;

Q. Similarly we can also perform join on 3 tables?
select
e.e_full_name, c.company name, c.compoany ein, a address 1, a.zip
from
employee e join company c on e.company_id = c.company id
join
address a on e.emplovee_address_id = a address id;

Note: Join by default is inner join.

Q. Difference between drop, truncate, delete?
Drop - drop an entire table : drop table employees;
truncate - table will be there but all the records will be deleted : truncate table employees;
delete - only a particular record will be deleted.

Q. UNION vs UNION ALL
Union joins records and doesnot return duplicate records
Union all joins records and returns duplicate records too.

Associations between tables:
1-1
1-many
many-1
many-many

Annotations in Spring Data JPA:

1. @Id - to declare an attribute as primary key. To declare it as not null, we use nullable=false
2. @Entity
3. @Table() - used when class name and table name are different
4. @Column(name = "") - by default variable name is given in camel case (createdDate) and this will be mapped with column called as created_Date. If they're different, we need to use @Column annotation.
5. @GeneratedValue(strategy=GeneratedType.Auto) - It is used on id attribute. This is similar to AUTO_INCREMENT in JDBC.

   GeneratedType - 4types:

   1. Auto - depending on the type of DB, it will automatically select either Identity/ Sequence.
   2. Identity - similar to AutoIncrement
   3. Sequence - suggested to use - There is another sequence column in another table which has rows with values : 1,2,3,4.... These will point to rows in the original table
   4. Table

6. @Query

**Heirarchy of JPARepository:**
Repository
CrudRepository (extends Repository) - used when there are only C,R,U,D operations to be performed
Pagination&sortingrepository (extends CrudRepository) - suppose you have 500 pages to load but initially you only want to laod first 5 pages, you can extend this repository.
JPARepository (extends Pagination&sortingrepository) - used to write customized queries (JPQL) - @Query

JPQL - Java Persistence QUery Language

Adding database to our project:

1. Add spring boot starter data jpa dependency to pom.xml - for mysql or any other database
2. Or add h2 dependency if you want to use in-memory database. H2 data will be deleted when server is stopped.
3. Configurations (application.properties):
   sring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=

   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

   **\ Note: vvv imp\*** **Dialect** - kind of like database language. If you're shifting from MySQL to Oracle DB. You only need to change here to let the ORM know what database language you're going to use so that it will generate queries accordingly.

   **Optional configurations:**
   spring.h2.console.enabled=true -> If this is enabled, h2-console will be available
   spring.h2.console.path=/h2-console
   spring.jpa.show-sql=true -> SQL statements will be printed into the console, if this is enabled.
   spring.jpa.properties.hibernate. format_sql=true -> SQL statements that are being printed into the console will be formatted. Otherwise, they will be printed in a single line.

Repository -
interface EmployeeRepository extends JPARepository<Employee, Long> {} Employee is Entity name. Long is the data type of primary key.

**Convention:**
For every Table, there will be a corresponding Entity (class)
For every Entity, there will be a corresponding Repository.
Ex.
Employee table -> Employee class -> EmployeeRepository

**Operations in Repository given by Hibernate:**

1. Whenever we use employeeRepository.save(employee) in service layer, hibernate will generate SQL insert statement. -> Create operation
2. .findById() -> Read operation. It throws exception. So, it is optional. We can use .get()
3. .deleteById() -> delete operation

Note: If you use .save() on an existing record again using same primary key, then it will update the record. If the record does not exist, it will create new record.

Suppose you want to search by firstName or something like that, then you need to write custom queries:
**Custom Queries (JPQL queries):**
@Query ("SELECT e FROM Employee e WHERE e.firstName = :fName") -> :fName, : is called as dynamic replacement.
List<Employee> findByName (@Param("fName") String firstName);
Note: Dynamic replacement can be used along with @Param in the method declaration.

// or we can use positional params
@Query ("SELECT e FROM Employee e WHERE e.firstName = ?1") -> :fName, : is called as dynamic replacement.
List<Employee> findByName (String firstName);

Hibernate will also convert this query to generate corresponding query in MySQL/ Oracle DB or anyother DB that you've configured.
Note: Some queries are database specific, for such queries you need to write the query manually using nativeQuery=true and you'd have to write using the exact column names from the database. So, native queries are DB dependent.

Note: For Update query using JPQL (@Query), we need to add another tag: @Modifying on top of @Query and we also need to add @Transactional tag on the method at service layer.

**Imp**
**@Transactional** is used because suppose if the query is modifying records in multiple records, and if the data gets modified in some tables and if there is any error in modifying record in one/ multiple tables; then there is data inconsistency between the tables. So, if we use @Transactional at service layer, it makes sure that all the records will be rolled back if there is failure while updating record in any of the tables.

**DTO(Data Transfer Object)**
Since your Entity is closely coupled with database, you should not let user know the column names of the tables in the database. So, you'll generally create EmployeeDTO which contains different field names and when you ask user for data (like using RequestBody), you'll use this object and you'll map it when the object is passed to repository layer.

**Using MySQL Dialect:**

1. add dependency (pom.xml): mysql-conenctor-j
2. add configuration (application.properties):
   # database configuration
   1. spring.datasource.url=jdbc:mysql://localhost:3306/JCByBharath -> JCByBharath is the schema name
   2. spring.datasource.username=root
   3. spring.datasource.password=JCBharath@2023
   4. spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   # Hibernate configuration
   1. spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
   2. spring.jpa.hibernate.ddl-auto=update # depending on the table status (create (used for the first time)/ create-drop (used in testing. Whenever appm starts it creates the tables and when it is stopped, it deletes the tables) / validate / none (used in production) / update)

**JUnit**
For Unit tests using JUnit:

We used @Test on top of method
We use same package structure as source code.
Steps:

1. You create object of the actual class and pass some test value to the each of the methods of the object in seperate test methods.
2. use assertions to test the result returned : assertEquals(), assertNotSame(), assertNotNull(), assertTrue()....

In JUnit, if a method does not return anything, you can not test it. But you can do it in Mockito.

There are changes between JUnit4 and JUnit5:

1. JUnit4 does not support Java 8 or greater
   JUnit5 supports Java 8 or greater
2. In JUnit4, everything was clubbed into one jar and we add that to our external libraries. But in JUnit5, they've split it into multiple modules like Jupyter module, Vintage module... We generally use Jupyter module.
3. Some changes were also made like BeforeClass was changed to something else....
4. JUnit4 uses @RunWith(MockitoJUnitRunner.class), JUnit5 uses @ExtendWith(MockitoExtension.class)

**Mockito**
Add dependencies:

1. mockito-core
2. mockito-junit-jupyter

For all the classes that are injected (i.e, the ones which are not actually created but are injected (@Autowired) ), you can use Mockito to mock them.

Here also, We use @Test on top of method
Here also, we use same project structure.

Steps:

1. Use @InjectMocks instead of creating an object of the class you're going to test.
2. Mock all the objects that injected(@Autowired) using @Mock
3. If the method is calling some other method, then Prepare dummy return value and use doReturn().when().method() or when().thenReturn() to return this dummy value.
4. For each scenario, we write seperate tests(methods) (like if a method is going to give multiple exceptions, you write seperate tests for each of the exceptions of the method along with tests for each of the return values of the method).
5. verify any function calls being made using verify().
6. Write assertions to check return value of the method.

any(Employee.class) ->any instance of Employee class. Or you can use new Employee().
Note: Suppose your method is calling other methods using static values like 10, "adn"... you need to use equivalent: eq(10), eq("adn)...

Note: Suppose if the dummy return value is supposed to be void, we can directly use doNothing() instead of doReturn()

Argumentcaptor
Suppose if your argument value gets changed and you are passing that argument to another method and you want to check the value of the argument with which this method is being called, you can use Argumentcaptor.

**Jenkins**
It has multiple stages in its pipeline.
It will have a hook on your Git repo. So, whenever you push your code, it will be invoked.

Boomer

SonareQube
Rules like:

1. If you have very long nested if
2. if your method is too lengthy (too many lines)
3. If there are any vulnerabilities etc....

We can add SonarQube plugin to intellij

**Associations between tables:**
consider two tables: Employee, Address

1. 1-1 - when each employee only has one address
   @OneToOne - gives a default name to the foreign key column
   @JoinColumn - if you want to rename the foreign key column name. If you do not give this, by default it is secondarytablename_primarykeyofsecondarytable_id

   Unidirectional: If you create a column only on one side (@onetoone only in one class)
   Bidirectional: If you create a column on both sides (@onetoone in both classes)

2. 1-many - when each employee only has one or more addresses
   In employee class:
   @OneToMany(mappedBy="employee")
   private List<Address> eAddresses;

In Address class:
@ManyToOne
@JoinColumn(name="fk_emp_id")
private Employee employee; // THis variable name is mentioned in mappedBy in Employee class.

3. many-1: same as onetomany.

4. many-many:
   Suppose there are two tables - Employee, SkillSet
   One employee can multiple skillset and one skillset can be present in multiple employees
   Note: We can't achieve Many to Many on two tables since we don't know where to put the foreign key. We will create another table which is a temporary table called as Joining table/ Junction table:
   emp_skillset_mapping_table with two foreign keys: emp_id, skillset_id

   For creating the temporary table, we use: @JoinTable

   In employee class:
   @ManyToMany(mappedBy="employee")
   @JoinTable(name="emp_skillset_mapping_table", joiningcolumn="emp_id", inversejoiningcolumn="skillset_id")
   private List<Address> eAddresses;

   In Address class:
   @ManyToMany
   @JoinColumn(name="fk_emp_id")
   private Employee employee; // THis variable name is mentioned in mappedBy in Employee class.

Fetch Type:

1. Eager loading/ early loading - by default when you're joining , it'll fetch all the data all at once - reduces performance -
2. Lazy loading - data is fetched only when you ask for it, query will only be generated only when you need it. Initially, it'll take time but most probably you'll use cache, so later on it'll be faster - sometimes increases performance

Cascading type - suppose you do some operation on one table, does it need to affect another also or not.

1. ALL - for all CRUD operations, it'll by default apply all the same operations on the other table too. You should be careful because if you delete, it'll delete in other table too
2. PERSIST - only restricted for save operation (only insert operation).
3. REMOVE - only for delete operation
4. DETACH
5. MERGE

**Cache:** It is a memory.
Stores using id and value.
For a request, If the data is available in the cache, it is directly returned. Otherwise, it is fetched from database and then returned.
Types:

1. EHCache.
2. Redis

It is used in service layer.

3. @EnableCaching
4. @Cacheable
5. @CacheEvict - Used for Database delete operation
6. @CachePut - Used for Database update operation

Note: Instead of writing lot of boiler code for constructors, getters and setters, we can use lombox dependency:
@Getter - integrates getters for all attributes.
@Setter
@NoArgsConstructor - default constructor
@AllArgsConstructor - parameterized constructor with all args

DBBrowser extension can be used in Intellij to access and write sql queries in intellij itself.

Mapper: Mapper class has method which takes DTO object, creates a DAO object and returns it.
Note: In service class file, you should not write like 100 lines of code, you should create another helper class which will return the required object to service class.

1.  mapping forward: dao to dto
2.  mapping backward: dto to dao

Design patterns:

1. Builder pattern - For example while writing setter, if you return the object. It is called builder pattern.
   Ex. Checkout forward mapping in EmployeeMapper and EmployeeDto.

Invoking one web service from another:

1. HttpClient
2.
3. RestTemplate
