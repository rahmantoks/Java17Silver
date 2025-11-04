## Operators
### Logical Operator
|operator|usage|meaning|
|:---:|:---:|:---:
|&|a & b| true if a and b true|
|&&|a && b| true if a and b true|
|\||a \| b| true if a or b true|
|\|\||a \|\| b| true if a or b true|
|!|!a| true if a false, false if a true|

* `&` and `|`
    * evaluate both side everytime
* `&&` and `||`
    * short circuit operator
    * evaluate right side based on result on left side

### Java Operator Priority
* Priority from highes to lowest
    1. `[]` `.` `x++` `x--`
    2. `++x` `--x` `+x` `~` `!`
    3. `new ()`
    4. `*` `/` `%`
    5. `+` `-`
    6. `<<` `>>` `>>>`
    7. `<` `>` `<=` `>=` `instanceof`
    8. `==` `!=`
    9. `&`
    10. `^`
    11. `|`
    12. `&&`
    13. `||`
    14. `?:`
    15. `=` `+=` `-=` `/=` `%=` `*=` `^=` `<<=` `>>=` `>>>=`
* Same priority operators are evaluated from left to right  

### Bitwise Operator
|operator|operation|explanation|example|
|:---:  |:---|:---|:---|
|&      |Bitwise AND            |1 if both operands are 1|
|\|     |Bitwise OR             |1 if either opearand is 1|
|^      |Bitwise XOR            |1 if operands are different|
|~      |Bitwise Complement     |invert all the bits in operand|
|<<     |Left Shift             |shift to the left|
|>>     |Signed Right Shift     |shift to the right|
|>>>    |Unsigned Right Shift   |shift to the right, fill with 0|

## Control Flow
### Switch
```java
int day = 3;
switch (day) {
    case 1:
        System.out.println("Monday");
        break; // prevent fall-through
    case 2:
        System.out.println("Tuesday");
        break;
    default:
        System.out.println("Other day");
}
```
* Used for multi-branch control.
* Works with `int`, `char`, `String` and enums.
* `break;` statement to prevent fall through.
* case values
    * type must same as condition
    * constant, or value can be evaluated during compile
    * not null

### Enhanced Switch
```java
String day = "SAT";
String type = switch (day) {
    case "SAT", "SUN" -> "Weekend";   // multiple labels
    case "MON"        -> "Workday";
    default           -> "Weekday";
};
System.out.println(type); // Weekend
```
* Removes fall-througs, supports multiple labels, and can return values.
* no need for `break;` statement.
* must cover all value (need default case).
* ends with semicolon.
* can be used as an expresions (returns a value) or statement (just execute)
* arrow statement:
    * return values
    * throw exception
    * code block (use yield to return block's result)
### For Loop
```java
for (int i = 0; i < 3; i++) {
    System.out.println("i = " + i);
}
```
* used when you know the number of iterations.
* initializer
    * can delcare multiple variables. variables must have same types
* condition
    * can only have one condition.
* refresh statement
    * can have multiple

### Enhanced For
```java
String[] names = {"Alice", "Bob", "Charlie"};
for (String name : names) {
    System.out.println(name);
}
```
* Iterates over arrays or collections.
* Read-only access to elements (you cannot modify the array index).

### Label
```java
outer:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (i == j) continue;        // skip same index
        if (i + j == 3) break outer; // break outer loop
        System.out.println(i + "," + j);
    }
}
System.out.println("Exited outer loop");
```
* label mark a loop or blocks so you can `break` or `continue` it directly.
* label name must be a valid identifier followed by `:`.
* can be used with break, continue
* can't be used with return.
* typically used to exit nested loops cleanly.
