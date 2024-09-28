# Magic Values

In programming, anything that **is not** a:

* null
* empty string (`""`)
* a single space as a string (`" "`) or as a `char` (`' '`)
* 0 (`int` or `double`)
* 1 (`int` or `double`) including -1
* the booleans `true` and `false` at initialization

is a **magic value** and should be avoided.

For example, instead of

```java
System.out.println("boo");
```
it's better to write
```java
System.out.println(scaryNoun);
```
and have `String scaryNoun` initialized earier in the code.

Loops should never be terminated with literals. Instead of

```java
for (int i = 0; i < 5; i++) { ... } 
```
we should write
```java
for (int i = 0; i < numberOfSteps; i++) { ... } 
```
or
```java
for (int i = 0; i < someArray.length; i++) { ... } 
```

Boolean literals are ok during initialization of boolean variables. Further changes in the values of these variables should be done with expressions, not literals. For example, instead of

```java
boolean countains(String[] array, String target) {
    boolean found = (target != null)
    int i = 0;
    while (i < array.length && !found) {
        if (target.equals(array[i])) {
            found = true;
        }
        i++;
    }
    return found;
}
```

it is better to write:

```java


```java
boolean countains(String[] array, String target) {
    boolean found = (target != null)
    int i = 0;
    while (i < array.length && !found) {
        found = (target.equals(array[i]));
        i++;
    }
    return found;
}
```

**Magic values lack of context.**  Hard-coded literal values have no obvious meaning by themselves. For example, seeing a number like 42 in the middle of a program doesn’t convey a purpose. The code becomes difficult to understand and maintain.

**Magic values reduce maintainability.** Imagine a program that comprises several classes and each class has several methods.  If the same magic value is used in these classes and methods and we want to change it later, each occurrence must be updated manually. This could lead to inconsistencies. What if we forget to change one occurrence? That's why it is better to use named constants. We change them in one place only.

**Magic numbers make code less readable.** Surely we can write comments explaining what the magic value is but that adds clutter to the code. Sometimes it is best to replace comments with a thoughtfully named variable or constant.

**Magic values make debugging more difficulty.** It is not always clear why a particular value was used in a program or how it relates to the overall logic of the program. This slows down debugging often to the point that it renders it ineffective.

**Magic values violate the DRY Principle.** In their book [*The Pragmatic Programmer*](https://en.wikipedia.org/wiki/The_Pragmatic_Programmer),  Andy Hunt and Dave Thomas suggest that "every piece of knowledge must have a single, unambiguous, authoritative representation within a system". Use of magic values violates the "Don't Repeat Yourself" (DRY) principle. Defining the number as a constant (or a variable) in one place and using it throughout the code fulfills the requirement for *single, unambiguous, authoritative representation* and promotes consistency and clarity.