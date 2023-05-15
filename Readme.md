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
Bi-Consumer, BiFunction, BiPredicate - all these have methods that accept two arguments

variants of Function:
Unary operator - datatype of argument and return value are same
Binary operator - datatype of both both arguments and the return type are all same

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
