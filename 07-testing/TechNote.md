# Technical note: $\mathcal O (1)$ queue operations

Arrays are linear structures but our imagination and creativity can bend them into circular shape. This creates a structure bringing the first position of an array immediately afer its last. In an array with $n$ elements, we can go around in circles moving from the last element in position $[n-1]$ to the next element in position $[0]$. Typically, that would involve getting to the last position and adding 1 to move to the next element. But $(n-1)+1$ will take us to position $[n]$ which, for an array with $n$ elements, is out-of-bounds.

To move *around* the array as if it were circular, we need a map like

$$\texttt{array}[(\texttt{array.length}-1)+1]\mapsto \texttt{array}[0]
$$

This can be accomplished with the *modulo* function since

$$
0 \leq (i\ \bmod \texttt{array.length}) \leq \texttt{array.length}-1
$$

The array reference

```java
array[i % array.length]
```
will always be within array bounds for any value of $i\geq 0$.

The circular queue requires two index pointers: one to the front of the queue and one to the back of the queue. When implementing a *linear* queue we move the data closer to the *front of the array*. In the circular implementation, we move the front of the queue to whichever place in the array it needs to be. Same for the back of the queue.

When the queue is empty, the front and the back of the queue coincide with the front of the array. That's why class `FastQ` initializes
```java
this.front = 0;
this.back = 0;
```



## method `boolean add`

The method moves the back of the queue from the front of the array to the right; when the back of the queue reaches the back of the array, we wrap around to the front of the array and start again:
```java
this.back = (this.back + 1) % this.size;
```
The method returns `false` when there is no room in the array to add new data; otherwise it returns `true` after placing the new data at `this.array[this.back]` and advacing the back to the next position. It's important to update `this.used` to reflect the number of data items in the array.


## method `String remove`

The method returns `null` if there are no data in the array. But if there are data (`this.used>0`) the method returns the data at the front of the queue and moves the front to the right of the array. When the front of the queue reaches the back of the array, we wrap around and start again. It's important to update `this.used` to reflect the number of data items in the array.



# Assessment guidelines

## Red-level issues

* Program does not compile/execute.
* Program has minimal or no comments.
* Program has non descriptive variable names, such as single-letter names -- ok to use them for loop indices though.
* Any violation of the Programmer's Pact is a red issue.
* No Javadoc.
* **Code has magic values**. 
* Code doesn't pass `FastQTest`
* Assignment is incomplete (one or more of the three required methods are missing; ungrading reflection is missing).

## Yellow level issues

* You are not using the keyword `this` when handling object fields in your code.
* Program executes but results are not as expected and significantly different from specs.
* Your code could be a bit more creative.


## Green level issues

* Output is close to specified but not identical
