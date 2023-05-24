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

**Path params and Query params In a GET request:**

1. www.bestbuy.com/123/details -> 123 is /{productID}/ - 123 is called Path param/ Path variable
2. www.bestbuy.com/details?productid=123 - 123 is called Query param/ Request param

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
mvn package -> compile all the classes
mvn install -> compiles all the classes and places the jar file in .m2 folder - useful when you're using this project as a dependency in another project
mvn clean package -> cleans and packages
mvn clean install -> cleans and installs

Last 2 commands are most used
