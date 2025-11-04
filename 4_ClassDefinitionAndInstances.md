### Class Definition
```java
public class Cat {
    String name;       // Instance variable
    int age;

    // Constructor
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method
    void meow() {
        System.out.println(name + " says meow!");
    }
}
```
* Class names start with a capital letter (convention).
* Fields, constructors, and methods define class behaviour
* The `this` keyword refers to the current object.
#### Constructor
* 
#### Method
* vaargs parameter
    * treated as array
    * at most 1 vaargs per method
    * must be the last parameter
* static method
    * can only access static member
#### Initialization
```java
Cat c1 = new Cat("momo", 3);
Cat c2 = new Cat("kuro", 2);
```
* Objects are created using the `new` keyword.
* Each object has its **own copy** of instance variables.
* Initialization Order
    1. Static initializer -> run once per class
    2. Instance initializer -> run before the constructor
    3. Constructor -> final step in initialization
    ```java
    public class InitOrder {
        static { System.out.println("Static block"); }
        { System.out.println("Instance block"); }

        InitOrder() {
            System.out.println("Constructor");
        }

        public static void main(String[] args) {
            new InitOrder();
            new InitOrder();
        }
    }
    ```
    will result 
    ```
    Static block
    Instance block
    Constructor
    Instance block
    Constructor
    ```

#### Intance and Static Member
|Type|Declared with| Accessed by|Belongs to|Memory|
|---|---|---|---|---|
|Instance|none|Object|Each object| Per Instance|
|Static|`static`|Class name|Class itself|One shared copy|
```java
public class Counter {
    static int totalCount = 0; // Shared by all objects
    int id;                    // Unique to each instance

    Counter() {
        totalCount++;
        id = totalCount;
    }
}

Counter a = new Counter();
Counter b = new Counter();

System.out.println(a.id);        // 1
System.out.println(b.id);        // 2
System.out.println(Counter.totalCount); // 2
```

#### 