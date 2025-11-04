## JAVA 17 Silver Study Note
1. Java Language Edge Cases
    * Initialization order
        * Static blocks, instance initiailzeds, constructors
        * Field default values (especially for array)
    * Variable scope & shadowing
        * this vs local variables with same name
        * Shadowing with inner classes or lambda parameters
    * Definite assignment 
        * Variables must be assigned before use (especially in conditionals)
    * var inference limits
        * Where it can and can't be used (only for local variables with initializers)
    * String immutability vs StringBuilder mutability
        * Common trick: "a" + "b" == "ab" vs new String("ab")
2. Object-Oriented Programming (Core of Exam)
    * The exam test compiler behavior and subtle rules
    * Constructor chaining (this() / super()) rules
    * Overloading vs overriding (return type, visibility, checked exceptions)
    * Upcasting/downcasting and instanceof
    * Access modifiers (especially package-private behavior)
    * Abstract classes vs interfaces (including default and static methods)
    * final classes, methods and variables
    * record classes (Java 16+) - understand syntax and immutability basics
    * sealed classes (Java 17+) - permits and non-sealed syntax
3. Java Core APIs (Frequenly Tested)
    * Focus on details that are easy to confuse under time pressure:
    * String
        * substring()
        * indexOf()
        * replace()
        * trim()
        * equals()
        * == 
    * Wrapper classes
        * Autoboxing/unboxing
        * parseXXX
        * valueOf()
    * Collections
        * ArrayList
        * List
        * Set
        * Map
        * removeIf
        * forEach
    * Arrays
        * Arrays.equals()
        * Arrays.sort()
        * multi-dimensional initialization
    * Date/Time API
        * LocalDate
        * LocalDateTime
        * Period
        * Duration
    * Exception Handling
        * Checked vs unchecked
        * re-throw rules
        * multi-catch
4. Java 17 Features That Might Appear
    * Pattern matching for instanceof
    * Enhanced switch expressions
    * Text blocks (""") - syntax recognition only
    * sealed classes (concenpt + syntax)
5. Common Exam Gotchas
    * order of import statements and package declaration
    * Illegal identifiers (`int _ = 5;` is OK; `int 1st = 5;` is not)
    * Using uninitialized local variables (compiler errors)
    * methods returning void can't be used in expressions
    * Understanding compile-time vs runtime errors
6. Mock Tests and Review
---
# Must-Know 30 Exam Traps
## 1 - 5 : Variables & Initialization
1. Uninitialized local variables
    ```java
    int x;
    System.out.println(x); // compile error
    ```
2. Default values only apply to fields
    ```java
    class A {
        int x; // x = 0
    }
    ```
3. `var` needs an initializer
    ```java
    var s;  // must have initializer
    ```
4. Type inference is compile-time only
    ```java
    var n = 1;
    n = 1.5; // double not compatible with int
    ```
5. Shadowed fields
    ```java
    int x = 5;
    class Inner {
        int x = 10;
        void print() {
            System.out.println(x); // print 10
        }
    }
    ```
## 6 - 10 : Operators & Control Flow
6. `==` compares references for objects
    ```java
    "abc" == new String("abc"); // false
    ```
7. `switch` fall-through vs arrow
    ```java
    switch(n) {
        case 1:
            System.out.println("A"); // no break!
        default:
            System.out.println("B");
    }
    ```
8. Enhanced `switch` requires total coverage
    ```java
    int r = switch(day) {
        case MONDAY -> 1; // needs default or all cases
    }; 
    ```
9. Ternary type promotion
    ```java
    var x = true ? 1 : 2.0; // x is double
    ```
10. Short-circuit evaluation
    ```java
    if (x != 0 && 10/x > 1) // safe; right side is skipped if x == 0
    ```
## 11-15 : Methods & Overloading
11. Exact match beatds widening/autoboxing
    ```java
    void f(int n ) {}
    void f(Integer n) {}
    f(1); // ok, calls int version
    ```
12. Varargs has lowest priority
    ```java
    void f(int... x){};
    f(); // ok
    ```
13. Return type alone doesn't overload
    ```java
    int f(){return 1;}
    void f(){} // error, uplicate
    ```
14. Pass-by-value for objects
    ```java
    void m(SringBuilder s){
        s.append("X");
        s = null;
    }
    ```
15. Recursion & stack overflow edge case

## 16-20 : Classes & OOP Rules
16. Initialization order
17. Constructors: frist statement must call `this()` or `super()`
18. Private constructors prevent subclassing
19. Override requires same or narrower checked exceptions
20. Access can only wide when overriding (private -> protected -> public)

## 21-25: Inheritance & Polymorphism
21. Field hiding, not overriding
    ```java
    class P {
        int x = 1;
    }
    class C extends P {
        int x = 2;
    }
    System.out.println(((P) new C()).x); //1
    ```
22. Static methods aren't polymorphic
    ```java
    class P {
        static void f(){

        }
    }
    class C extends P {
        static void f() {

        }
    }
    ```
23. Upcasting is implicit; downcasting requireds check
    ```java
    P p = new C();
    C c = (C)p; // OK
    ```
24. `instanceof` with pattern
    ```java
    if (obj instanceof String s) System.out.println(s.length());
    ```
25. Sealed classe syntax
    ```java
    sealed class A permits B {

    }
    final class B extends A {

    }
    ```
## 26 - 30 : Core API & Exceptionds
26. `StringBuilder` is mutable
    ```java
    var sb = new StringBUilder("a");
    sb.append("b"); //sb="ab"
    ```
27. `String` methods create new objects
    ```java
    String s = "a";
    s.concat("b");
    System.out.println("s"); // prints "a"
    ```
28. Wrapper caching
    ```java
    Integer a=100, b=100;
    a == b; //true 
    ```
29. Try-with-resources auto-close order
    ```java
    try (A a = new A(); B b = new B()){} // close B then A
    ```
30. Multi-catch must not have parent-child
    ```java
    catch (IOException | FileNotFoundException e) {} //invalid
    ```