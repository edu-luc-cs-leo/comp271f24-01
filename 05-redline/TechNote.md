# Technical note: `indexOf`, `contains`, `reverseList`, `isEmpty`

This assignment implements the interface [`SillyActions](./SillyActions.java).

## Overall remarks

A critical aspect of this assigment is to recognize that method `contains` can be based on method `indexOf`.

```java
boolean contains(String name) {
    return this.indexOf(name) > -1;
}
```

This way we avoid duplicating code (and effort). 

Another challenging point in the assignment is in the `reverseList` method: how we produce the names of the stations in reverse order while traveling in the opposite direction? In the exampe of the CTA Red Line southbound, the first station is Howard, but we want it listed at the end. The second station is Jarvis and we want it listed second from the end, and so on. This is the equivalent of writing the names of the stations on a piece of paper, beginning from the bottom and moving up. 

```text
                                 Loyola     ...
                      Morse      Morse      ...
           Jarvis     Jarvis     Jarvis     ...
Howard     Howard     Howard     Howard     ...
```

How can we achieve that with a string?

Usually we add new data to the end of a string, e.g.,
```java
stationList = stationList + somethingNew;
```
For this problem we want to reverse the operation:
```java
stationList = somethingNew + stationList;
```

## Assessment guidelines

### Red-level issues

* Program does not compile/execute.
* Program has minimal or no comments.
* Program is not lean because contains method is not based on a return value of `indexOf`.
* Method `reverseList` uses anything more than a string, contrary to specifications.
* Program has non descriptive variable names, such as single-letter names -- ok to use them for loop indices though.
* Any violation of the Programmer's Pact is a red issue.
* No Javadoc.
* **Code has magic values**. 

### Yellow level issues

* You are not using the keyword `this` when handling object fields in your code.
* Program executes but results are not as expected and significantly different from specs.
* Your code could be a bit more creative.


### Green level issues

* Output is close to specified but not identical
