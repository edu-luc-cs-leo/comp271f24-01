# Assignment 05

## Part I: code review of previous assignment

Using the [solution](../04-interfaces/Solution_Person.java) and the [technical note](../04-interfaces/TechNote.md) for the previous assignment, conduct a code review for your implementation of the **`SillyActions`** interface. In your review:

* describe any red, yellow, or green level issues with your code. For red and yellow issues, discuss what led to them;
* suggest how the code could be improved;
* reflect if the quality of your code is related to time management and how to mitigate things.
* propose how Leo's code can be improved.

Your review must exude professionalism: few (ideally no) typos, and nicely organized. You may produce it as a PDF file to attach to Sakai, or as plain text typed straight in the Sakai textbox. It may be a good idea if you used an editor to compose your review, then past the text in Sakai to avoid loss of data.
 

## Part II: traversing a trainline

For this assignment you'll work with classes [`Trainline`](./TrainLine.java) and [`TrainStation`](./TrainStation.java). Most of the work will be done in `TrainLine`.

The [Programmer's Pact](../misc/ProgrammerPact.pdf) is in full effect. You may not use any imports or any utilities from `System` except to print. (No `StringBuilder` either.) Your code must as *lean* as possible, i.e., avoid redundant statements.

By introducing class attributes `TrainLine.numberOfStations` and `TrainLine.tail` we have eliminated the need to traverse the object when we needed to find how many stations are linked or when we wanted to add another station object. In terms of performance analysis, an $\mathcal{O}(n)$ operation (that's math slang for "linear time" operation) turned into a constant time operation (in math, $\mathcal{O}(1)$). We'll discuss the *big-oh* notation ($\mathcal{O}$ )next week. For now we want to focus on a couple of traversal operations.

In general, a traversal operation starts from `TrainLine.head` and follows `TrainStation.next` while the train station object has a next station to go to. The typical pattern, as shown in class, is:

```java
if (this.head != null) {            // No point trying if line is empty
  TrainStation cursor = this.head;  // Start at beginning
  while (cursor.hasNext()) {        // Sometimes we check for cursor!=null instead
    // do something                 // Work that needs to be performed  
    cursor = cursor.getNext();      // Move to the next station
  }
}
```

For this assignment, please write the following four methods. The examples below are based on a hypothetical `TrainLine` named `"redLineSB"` with the following stations:
```text 
head                                       tail
______                                     _________
Howard --> Jarvis --> Morse --> Loyola --> Granville --> null
```

Method `TrainLine.main` provides test code to verify that `indexOf`, `contains`, and `reverseList` work properly. No testing is provided for method `isEmpty`.


### Deliverable: method `boolean contains(String)`
Write a method that returns true if a `TrainStation` whose name is given by the string parameter, exists in a `TrainLine` object. If no such station is found, the method shall return false. For example,

```java
redLineSB.indexOf("Howard");    // Returns true (station exists)
redLineSB.indexOf("Morse");     // Returns true (station exists)
redLineSB.indexOf("Bryn Mawr"); // Returns false (not found)
```
 

### Deliverable: method `int indexOf(String)`
Write a method that returns the position of a `TrainStation` whose name is given by the string parameter, in a `TrainLine` object. If no such station is found, the method shall return -1. For example,

```java
redLineSB.indexOf("Howard");    // Returns 0 (first station)
redLineSB.indexOf("Morse");     // Returns 2 (third station)
redLineSB.indexOf("Bryn Mawr"); // Returns -1 (not found)
```


### Deliverable: method `String reverseList()`

*For this method, use of `"\n"` is NOT considered a magic value.*

Return a string with the names of the stations in reverse order, one station per line. Arrays and ArrayLists cannot be used in this method. No `StringBuilder` either. The method itself should not print anything, just return a string. For example
```java
System.out.println(redLineSB.reverseList());
``` 
should dispay:
```
Granville
Loyola
Morse
Jarvis
Howard
```

### Deliverable: method `boolean isEmpty()`

To return `true` if a trainline object has no stations and `false` otherwise.


## Reading material
 
* [Classes and Objects tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html) from the Java documentation project. Skip the material for nested classes and enum(eration)s for now.

* [Java in a Nutshell](https://learning.oreilly.com/library/view/java-in-a/9781098130992/), avaiable from the O'Reilly platform at no cost when you use your LUC email to login.