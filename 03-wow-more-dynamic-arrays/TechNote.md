# Technical note: class `DynamicArray` (yes, more!)

This assignment builds on the existing DynamicArray and adds three more methods.


## Method `toString`

My solution is based on a `StringBuilder` object to demonstrate its use. It's ok if you used just strings. 

These are the things that you needed to pay attention to:

* Consider a special message if the underlying array has no actual content -- just nulls. Also, if you use any delimiters, such as commas, between values, you need to be aware of the ["fencepost" problem](https://en.wikipedia.org/wiki/Off-by-one_error).

* Avoid magic values (this is a red issue at this point).

* Discuss, in comments, why you need to traverse the area to `this.foundation.length` if that's how long you run the loop, instead of `this.occupancy`.

## Method `indexOf`

The most important thing here is the use of a while-loop. Use of a for-loop is a yellow-turning-red issue.

## Method `usage`

The most common mistake this is to attempt to return some form of the fraction 
```java
this.occupancy/this.foundation.length
```
It's important to cast at least one of them as a double, in order to produce a meaningful value:
```java
(double) this.occupancy/ (double) this.foundation.length
```
## Assessment guidelines

### Red-level issues

* Program does not compile/execute.
* Program has minimal or no comments.
* Program has non descriptive variable names, such as single-letter names -- ok to use them for loop indices though.
* Any violation of the Programmer's Pact is a red issue.
* No Javadoc.

### Yellow level issues

* Program executes but results are not as expected and significantly different from specs.
* Program has magic values.
* `usage` does not cast either component of the `occupancy/length` fraction, as a double number.
* Your code is excessively complicated. In your code review, discuss how you could write simpler code.

### Green level issues

* Output is close to specified but not identical
