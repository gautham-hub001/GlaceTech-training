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
Exception: An exception is an event, which occurs during the execution of a program, that disrupts the normal flow of the program's instructions.

types:

1. checked exceptions - should be handled in compile time only (when you write the code itself) because the code would not be compiled if you don't write the exception. It is checked because you already know about the exception.
   ex. FileNotFound exception, IO, SQL
2. unchecked exceptions - runtime exceptions - You don't need to handle it mandatorily
   ex. ArrayIndexOutOfbounds exception, ArithmeticException, NullPointerException

Handling exceptions:

1. Using try catch block - there can be multiple catch blocks for a try block

Or

2. throws keyword - you can mention in the method's first line itself - not actual handling, you're just saying it will throw an exception.

Note: If you use a method which throws an exception in another method, you need to either declare using throws or use try catch.

Note: If you don't handle it even in the main method, JVM is going to print in the console about the exception (only if the exception actually occurs).

**throw**: If you want to throw an exception (existing or custom)

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
