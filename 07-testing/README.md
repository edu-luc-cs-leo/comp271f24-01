# Assignment 07

## Part I: code review of previous assignment

Using the [solution and technical note](../06-linkedlists/TechNote.md) for the previous assignment, conduct a code review for your implementation of ``stringTo``, ``insert``, and ``isEmpty`` methods. In your review:

* describe any red, yellow, or green level issues with your code. For red and yellow issues, discuss what led to them;
* suggest how the code could be improved;
* reflect if the quality of your code is related to time management and how to mitigate things.
* propose how Leo's code can be improved.

Your review must exude professionalism: few (ideally no) typos, and nicely organized. You may produce it as a PDF file to attach to Sakai, or as plain text typed straight in the Sakai textbox. It may be a good idea if you used an editor to compose your review, then past the text in Sakai to avoid loss of data.
 

## Part II: Fast Queue

Queues are *first-in/first-out* (FIFO) data staging techniques. Removals and additions are executed as follows.

```java
public String remove() {
    String removed = this.array[0]; 
    for (int i = 0; i < this.used-1; i++) 
      array[i] = array[i+1];
    array[this.used--] = null;
    return removed;
}

public boolean add(String string) {
  boolean success = (this.used < this.array.length)
  if (success) {
    this.array[this.used++] = string;
  }
  return success;
}
```
 The methods above are part of an object using a ``String[] array`` to stage data queue-fashion, and ``int used`` to count how many elements of that array are currently used.

 From the code above, it can be seen that additions to the queue are done very fast; in fact they are done in constant-time. It takes the same number of steps to to add a value to the queue, no matter how many items are already stored in the queue. Constant time operations are writen as *big-Oh one:* $\mathcal{O}{(1)}$.

 Removals from the queue however require a number of steps that is proportional to the number of values already stored in the queue - that's the number of times we run the `for`-loop in method `remove`. We note this operation as *big-Oh n:* $\mathcal{O}(n)$

Removal performance can be improved and become size-independent. To do that we eliminate the `for`-loop and we introduce two new variables:

```java
int front; // points to the front of the queue
int back; // points to the back of the queue
```

By manipulating these two pointers we can always tell where the front and the back of the queue is. We remove data from `this.array[this.front]` and we add data to `this.array[this.back]` as long as there is room for data, i.e., `this.used < this.array.length`.

Write code to perform constant-time removals and additions in class [FastQ](./FastQ.java) using `front` and `back`. **Your code should not have any loops:** no `for`-loops, no `while`-loops, no `do`-loops. For this assignment you cannot use any imports or ``System`` functions.

When your code is completed you can test it with [FastQTest](./FastQTest.java). 

To run the test class in Visual Studio Code, you must have the *Test Runner for Java* extension installed. You'll need to right-click on ``FastQ`` (not on ``FastQTest``) and select ``Run Tests``.

## Reading material
 
* [The Queue interface in Java](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Queue.html) is not required for this assignment but it's a good review of how FIFO is done in the language.

* [The Deque interface in Java](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/Deque.html), is not required for this assignment but it's a good review of how LIFO is done in the language. Java has a [Stack class](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/Stack.html) but it is been slowly abandoned in favor of the Deque interface.