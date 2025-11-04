# Java Data Types and String Manipulation
### Primitive Types
| type | values |
| ---- | ---- |
| boolean | true, false |
| char | 16-bit unicode |
| byte | 8-bit integer number | 
| short | 16-bit integer number |
| int | 32-bit integer number |
| long | 64-bit integer number |
| float | 32-bit floating number |
| double | 64-bit floating number |

###  Java Literal
1. Literal Default Types
    * integer number -> int
    * floating point number -> double
    * true/false -> boolean
    * letter -> char
    * null
2. Number base prefix
    * no prefix -> base 10
    * 0 -> base 8
    * 0x -> base 16
    * 0b -> base 2
3. Number type suffix
    * long -> L or l
    * float -> F or f
4. `_` usage
    * To make easier to see
    * rules:
        1. can't be used at the beginning or at the end of literal
        2. can't be used next to symbol (including prefix and suffix)

### Identifier
* Methods, Functions and Classes' name is called *identifier*
* Reserved words can't be used as identifier

    |  |  |  |  |  |
    | :---: | :---: | :---: | :---: | :---: |
    | abstract | assert | boolean | break | byte |
    | case | catch | char | class | const |
    | continue | default | do | double | else |
    | enum | extends | final | finally | float |
    | for | goto | if | implements | import |
    | instanceof | int | interface | long | native |
    | new  | package | private | protected | public |
    | return | short | static | strictfp | super |
    | switch | synchronize | this | throw | throws |
    | transient | try | void | volatile | while |
    | _ |  |  |  |  |
* only `_` and `$` symbol can be used in identifier
* number can be used from second character and after

### `var` usage
* local variable only
* type inference during compile
    * lateral 
        ```java
        var a = "sa"; // var is string
    * methods's return type
        ```java
        int returnInt() { return 1 }
        var = returnInt(); // var is int
    * can't infer lambda function
        ```java
        var a = () => {}; // compile error
    * can't infer array instantiation
        ```java
        var a = {1,2,3}; // compile error
    * `<>` infer to `Object` type
        ```java
        var e = new ArrayList<>(); // ok
### `String` 
* instantiation
    ```java
    String string1 = new "String";
    String string2 = "String";
    String string3 = String.valueOf("String");
    ```
* immutable : can't be modified after creation.
* basic methods
    * `charAt()`
    * `indexOf()`
    * `substring()`
    * `replace()`
    * `length()`
    * `startsWith()`
    * `endsWith()`
    * `concat()`
    * `intern()`
* String literal is stored in `constant pool`, same string literal reference same constant
    ```java
    String a = "abc";
    String b = "abc";
    System.out.print(a == b); // true
    ```
  
### `StringBuilder`
* buffer size 16 letter
* basic methods
    * `capacity()`
    * `append()`
    * `reverse()`
    * `indexOf()`
### `Arrays`
* Instantiation
    ```java
    new int[3];
    ```
* Variable declaration
    ```java
    int[] array;
    int array[];
    ```
* Multi-dimensional array
    * Declaration
        ```java
        int[][] arrayA; // 2D array
        int arrayB[][][]; // 3D array

        int[] arrayA[]; // 2D array
        int[][] arrayB[]; // 3D array
        ```
    * Instantiation
        * First dimension's size must be assigned.
        * Second and higher dimension's size can be omitted
            ```java
            int[][] array =  new int[3][]; // OK
            ```
        * Second dimension's size does not need to be the same size
* Default values
    * When instantiatied without initiailizing elements, default values is assigned
        |type|default values|
        |:---:|:---:|
        |integer|0|
        |float|0.0|
        |boolean|false|
        |char|\u0000|
        |object|null|
* Elements initialization
    * initialize array using `{}`
        ```java
        int[] array1 = {2, 3};
        int[] arary2 = new int[]{2,3};
        ```
    * no need to assign size when using `{}`
        ```java
        int[] array3 = new int[2]{2,3}; // compile error
        ```
* `clone()` : copy array instance

### `ArrayList`
* can be used for `Object` type
* adjustable size
* thread unsafe
* basic methods
    * `add()`
    * `set()`
    * `remove()`
* creating fixed length list
    * `Arrays.asList()`
    * `List.of()`