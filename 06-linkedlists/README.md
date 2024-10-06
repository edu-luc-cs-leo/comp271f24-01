# Assignment 06

## Part I: code review of previous assignment

Using the [solution](../05-redline/TrainLine_Solution.java) and the [technical note](../05-redline/TechNote.md) for the previous assignment, conduct a code review for your implementation of ``indexOf``, ``contains``, ``isEmpty`` and ``reverseList`` methods. In your review:

* describe any red, yellow, or green level issues with your code. For red and yellow issues, discuss what led to them;
* suggest how the code could be improved;
* reflect if the quality of your code is related to time management and how to mitigate things.
* propose how Leo's code can be improved.

Your review must exude professionalism: few (ideally no) typos, and nicely organized. You may produce it as a PDF file to attach to Sakai, or as plain text typed straight in the Sakai textbox. It may be a good idea if you used an editor to compose your review, then past the text in Sakai to avoid loss of data.
 

## Part II: two more methods for `TrainLine`

For this assignment you'll work with classes [`Trainline`](./TrainLine.java) and [`TrainStation`](./TrainStation.java). Most of the work will be done in `TrainLine`.

The [Programmer's Pact](../misc/ProgrammerPact.pdf) is in full effect. You may not use any imports or any utilities from `System` except to print. (Exceptions: `StringBuilder` is now available to you but not recommended, in the interest of time. `ArrayList` is also available to use (`import java.util.ArrayList`)).  


### Deliverable: method `void insert(String, int)`

This method adds a new station with the name given as `String` after the station in position identified by `int`. For example, consider the TrainLine in the following code:

```java
TrainLine redLineSB = new TrainLine("Red Line SB");
redLineSB.add("Howard");
redLineSB.add("Jarvis");
redLineSB.add("Loyola");
```

The object corresponds to the following links:


```text
+--------+    +--------+    +--------+     
| Howard | -> | Jarvis | -> | Loyola | -> null
+--------+    +--------+    +--------+   
```

The invocation
```java
redLineSB.insert("Morse",2);
```

shall bring the object to the following state:

```text
+--------+    +--------+    +-------+    +--------+     
| Howard | -> | Jarvis | -> | Morse | -> | Loyola | -> null
+--------+    +--------+    +-------+    +--------+   
```


### Deliverable: method `String toString()`

The string representation of a TrainLine object should be a snake-like visualization of the trainline. Using the southbound CTA Red Line as an example, 
```java
System.out.println(redLineSB.toString());
```
should produce the following output

```text
         1         2         3         4         5         6         7         8
12345678901234567890123456789012345678901234567890123456789012345678901234567890

Howard --> Jarvis --> Morse --> Loyola --> Granville --> Thorndale --+
                                                                     |
      +-- Addison <-- Sherida <-- Wilson <-- Argyle <-- Bryn Mawr <--+ 
      |
      +--> Belmont --> Fullerton --> North/Clyburn --> Clark/Division --+
                                                                        |
+-- Roosevelt <-- Harrison <-- Jackson <-- Monroe <-- Clark <-- Chicago +
|
+--> Cermak-Chinatown --> Sox-35th --> 47th --> Garfield --> 63rd --> 69th --+
                                                                             |
                                 null <-- 95th/Dan Ryan <-- 87th <-- 79th <--+
```

The digits on the first two lines are for illustration only, and measure the number of characters per line. The snake pattern should not exceed 80 characters per line.


## Reading material
 
* [Classes and Objects tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html) from the Java documentation project. Skip the material for nested classes and enum(eration)s for now.

* [Java in a Nutshell](https://learning.oreilly.com/library/view/java-in-a/9781098130992/), avaiable from the O'Reilly platform at no cost when you use your LUC email to login.