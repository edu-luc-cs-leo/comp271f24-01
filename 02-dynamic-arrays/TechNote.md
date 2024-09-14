# Technical note: class `DynamicArray`

This was a rolling assignment that led to six methods added to class `DynamicArray`. The solution is presented here as `DynamicArray_Week02`. The six methods we added are described below. As I mentioned in class, your code is probably different than mine. It's ok. Focus on what you learn from the differences (and discuss the lessons in your code review).

## Method `contains`
This is a straight forward traversal of a string array. Early in the assignment, you may have wrote a full array traversal, using the for-loop:

```java
int i = 0
while (i < this.foundation.length && !found) {...}
```

After we introduced `this.occupancy`, we should change the loop to

```java
int i = 0
while (i < this.occupancy && !found) {...}
```
That's because the element 
```java
this.foundation[this.occupancy-1]
```

is the most recently added element in the underlying array; there is no need to search any further.

## Method `get`
It is important to protect the method from *bad* index values. For example, `get(-1)` should not be allowed. Also `get(n)` where $n\geq\texttt{this.foundation.length}$ should not be allowed either. That's why we need to check first:
```java
if (index >= 0 && this.foundation != null && index < this.foundation.length) 
```
Such if-statements are called **guard statements** because they protect the method from preventable errors. Notice that in order to check `this.foundation.length` we must first make sure that `this.foundation!=null`.

## Methods `remove` and `delete`
These two methods are very similar, so I discuss them together here.

Initially, we may have written `remove` with a basic guard statement like

```java
if (index >=0 && this.foundation != null && index < this.foundation.length)
```

Once an element is removed, it is also a good idea to close the gap. For example, if `this.foundation` has the following contents
```java
["Java", "Python", "C", "C++", "Fortran"]
``` 
and we cause its object to `remove(1)`, the array will be in the following state:
```java
["Java", null, "C", "C++", "Fortran"]
``` 
It will make life significantly easier if we closed the gap by moving every element following the one removed, one position to the left:
```java
["Java", "C", "C++", "Fortran", null]
``` 
We can achieve that with a simple for-loop starting from the position of the removed item and working its way to *nearly* the end of the array:
```java
for (int i = index; i < this.foundation.length -1; i++) {
    this.foundation[i] = this.foundation[i+1];
}
```
and immediately after the loop make sure that the last element of the array is set to null:
```java
this.foundation[this.foundation.length - 1] = null;
```

After the introduction of `this.occupancy` we do not have to traverse all the way to the end of the array, just up to the most recently placed item. The loop becomes:
```java
for (int i = index; i < this.occupancy -1; i++) {
    this.foundation[i] = this.foundation[i+1];
}
this.foundation[this.occupancy - 1] = null;
```

We must also adjust the occupancy value after we remove an element by reducing it by one:
```java
this.occupancy--;
```

The `delete` method is based on the `remove` method. There is no need to write redundant code; `delete` is just a version of `remove` without a `return` statement.


## Methods `insert` and `resize`

For these two methods we introduced a new object attribute,

```java
private int occupancy;
```
This new variable tells us precisely how many elements we have inserted in the underlying array; therefore: 
$$
0 \leq \texttt{this.occupancy} < \texttt{this.foundation.length}
$$

Every time we insert a string in the `DynamicArray` object, we must incremenrt occupancy. 

In addition to counting how many strings have been inserted in the underlying array, `this.occupancy` points to the first available position for the next insertion. And when the boolean expression
```java
this.occupacy == this.foundation.length
```
evaluates to `true`, there is no room in the array to add a new element. In this case, we must resize the underlying array. The structure of the `insert(string)` method can be quite simple:

```java
if (this.occupacy == this.foundation.length) {
    resize()
}
this.foundation[this.occupancy] = string;
this.occupation++;
```

Finally, `resize` is based on work we have done before. In my solution, I increase the size of the underlying array by just one. If you double the size of the array, remember that the operation
```java
... = new String[2*this.foundation.length];
```
contains a magic value and it should be replaced with a variable or a constant.


## Assessment guidelines

### Red-level issues

* Program does not compile/execute.
* Program has minimal or no comments.
* Program has non descriptive variable names, such as single-letter names -- ok to use them for loop indices though.
* Program does not return an integer array.
* Any violation of the Programmer's Pact is a red issue.

### Yellow level issues

* No Javadoc (In the next assignment the omission of Javadoc will become a yellow issue).
* Program executes but results are not as expected and significantly different from specs.
* Program has magic values.

### Green level issues

* Output is close to specified but not identical
