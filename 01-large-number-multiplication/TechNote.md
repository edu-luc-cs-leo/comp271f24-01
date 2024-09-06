# Technical note: large number multiplication

In this problem we must reconcile our intuitive understanding of multiplication with programming practicalities. If I were to sum up the purpose of data structures in one sentence, that would be it: the bridging of our intuition with the practical limitations of computing machines.

In class, we discuss the basic assumptions of multiplying two integer numbers represented by arrays `int[] x` and `int[] y`. We begin traversing the arrays from back to front. This necessitates us to write flipped loops, i.e., instead of the vanilla-flavored `for (int i=0; i<someArray.length; i++)`, we write
```java
for (int i = someArray.length - 1; i >= 0; i--) { ... }
```
Of course we have to write two loops -- nested loops to be specific -- one for each array:

```java
for (int i = x.length-1; i >= 0; i--) {
    for (int j = y.length-1; j >= 0; j--) {
        // magic happens here!
    }
}
```

 The algorithm we learned in grade school creates partial products that correspond to powers of 10:

 ```
     1234
   x 5678 <----------+
  -------            |
     9872 ... 1234 x 8 x 10^0
    8638 .... 1234 x 7 x 10^1
   7404 ..... 1234 x 6 x 10^2
  6170 ...... 1234 x 5 x 10^3
 ```

 In the partial products above, the trailing zeros are omitted because the product is shifted to the left. Effectively we add the partial products as if they had trailing zeros:

 ```
     9872 ... 1234 x 8 x 10^0
    86380 ... 1234 x 7 x 10^1
   740400 ... 1234 x 6 x 10^2
  6170000 ... 1234 x 5 x 10^3
  -------
  7006652 ... sum of partial products
```

The sum of partial products above, can be written with leading zeros as well:


 ```
  00009872 ... partial[0] = [0,0,0,0,9,8,7,2]
  00086380 ... partial[1] = [0,0,0,8,6,3,8,0]
  00740400 ... partial[2] = [0,0,7,4,0,4,0,0]
  06170000 ... partial[3] = [0,6,1,7,0,0,0,0]
```
The leading zeros do not change the value of the numbers, but they make the partial products look more uniform. So uniform that maybe we could use an array with $n$ rows and $m+n$ columns to store them.

Adding these arrays, column-by-column, from the right to left, is then trivial.

## Assessment guidelines

### Red-level issues

* Program does not compile/execute.
* Program has minimal or no comments.
* Program has non descriptive variable names, such as single-letter names -- ok to use them for loop indices though.
* Program does not return an integer array.

### Yellow level issues

* Any violation of the Programmer's Pact is a yellow issue. (Notice that in the next assignment any **repeat violation** of the pact will become a red issue).
* Program executes but results are not as expected and significantly different from specs.
* Program has magic values.

### Green level issues

* No Javadoc (In the next assignment the omission of Javadoc will become a yellow issue).
* Output is close to specified but not identical
