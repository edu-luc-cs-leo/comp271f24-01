# Assignment 01

## Part I: code review of previous assignment

Using the solution and the technical note for the [previous assignment](../00-perpetual-calendar/), conduct a code review for your Calendar program. In your review:

* describe any red, yellow, or green level issues with your code. For red and yellow issues, discuss what led to them;
* suggest how the code could be improved;
* reflect if the quality of your code is related to time management and how to mitigate things.
* propose how Leo's code can be improved.

Your review must exude professionalism: few (ideally no) typos, and nicely organized. You may produce it as a PDF file to attach to Sakai, or as plain text typed straight in the Sakai textbox. It may be a good idea if you used an editor to compose your review, then past the text in Sakai to avoid loss of data.

## Part II: grade school multiplication

Using the starter code in ``GradeSchoolMultiplication.java``, write a method with header:
```java
public static int[] multiply(int[] x, int[] y, int base)
```
that multiplies two integer numbers represented as arrays of single digits and returns their product as a single digit array. For example, the code:
```java
int[] x = {1,2,3,4};
int[] y = {5,6,7,8};
int base = 10;
int[] product = multiply(x,y,base)
System.out.println(Arrays.toString(product));
```
will display the following array
```
[7,0,0,6,6,5,2]
```
which corresponds to the product $1234\times 5678=7006652$.

For this assignment you cannot use the convenient techniques shown in class [`EasyMultiplications`](./EasyMultiplications.java). In other words, we cannot convert the arrays into integers, multiply them, and convert the product back into an array.

Instead, we can only perform single-digit arithmetic, i.e., additions, multiplications, division, and module between single digit numbers. We can use a carry; for example:
$$\begin{align*}
6\times 7&:\\ &\textsf{carry digit}=4,\\& \textsf{product digit}=2, \ \text{or} \\ \\
6+ 7&:\\ &\textsf{carry digit}=1,\\& \textsf{sum digit}=3, \ \text{etc}
\end{align*}
$$

The challenge in this problem is how to handle the partial products and their sum, for example:
```
  1024
 x  16
 -----
  6144 \   partial
 1024  /   products ...
 -----
 16384     ... and their sum
```
<br/>

**Further requirements:**

* No imports, except for `java.util.Arrays` and only for use of `Arrays.toString()` when/if needed.
* No use of `Math` except for `Math.log10` when absolutely necessary.
* No use of `valueOf()` calls for `String` or `Integer`. For that matter, no use of boxed classes like `Integer`.
* No use of any `System` modules except for `System.out.println`, `System.out.printf`, and `System.out.print`.
* Code must be in compliance with the Programmers Pact ([PDF](../misc/ProgrammerPact.pdf)).

Submit your work on Sakai. You may paste a link to a repository or you may upload ``.java`` file(s). If you **paste a link** make sure it's the correct link and not a link to your CodeSpace, for example. Links ending in ``github.dev`` are CodeSpace links and cannot be shared. A *proper* repository link typical starts with ``https://github.com/`` and ends with ``.java``.