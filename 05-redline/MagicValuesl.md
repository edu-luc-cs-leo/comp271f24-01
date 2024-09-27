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