# Assignment 03

## Part I: code review of previous assignment

Using the solution and the technical note for the [previous assignment](../02-dynamic-arrays/DynamicArray_Week02.java) (also available in this folder as [`DynamicArray.java`](./DynamicArray.java)), conduct a code review for your **DynamicArray** program. In your review:

* describe any red, yellow, or green level issues with your code. For red and yellow issues, discuss what led to them;
* suggest how the code could be improved;
* reflect if the quality of your code is related to time management and how to mitigate things.
* propose how Leo's code can be improved.

Your review must exude professionalism: few (ideally no) typos, and nicely organized. You may produce it as a PDF file to attach to Sakai, or as plain text typed straight in the Sakai textbox. It may be a good idea if you used an editor to compose your review, then past the text in Sakai to avoid loss of data.

## Part II: improving a data structure object

Using the posted solution for [`DynamicArray`](./DynamicArray.java), add the following **three** methods:

* `String toString()` that creates a textual representation of the object. For this method, you **cannot use** `Arrays.toString()` or any other imported utilities. ([Item 13](https://learning.oreilly.com/library/view/effective-java-3rd/9780134686097/ch3.xhtml#lev12) from *Effective Java* is some good reading about `toString`; we illustrate a simple `toString` in class [`Person`](./Person.java) as well). <br/></br> The exact format and content of your `toString` method is up to you. Consider what the `DynamicArray` contains and how would you like to present to the world.

* `int index(String string)` that returns the array position of `string` in the underlying array. If there are multiple occurences of `string` in `this.foundation`, the method returns the position of the first occurrence. If there are none, the method shall return -1.

* `double usage()` that returns the percentage of the underlying array elements that are current not null. The number returned by the method must have at most 2 decimal digits. For example, if the underlying array has a length of 10 but occupancy is 3, the usage is 0.3333333333. Your method should return just 0.33. (Hint: `Math.round`)

Except for the contents of these three methods, you cannot modify the code provided here. 

Your code must be in full compliance with the [Programmer's Pact](../misc/ProgrammerPact.pdf). You may not import any package. Also you may not use any `System` utilities except for `System.out` print statetements.

Once you have the specified methods working properly, the code will compile and execute a few tests that will be provided on Monday 9/16.


## Reading material

Our work for far is based on chapters 3, 4, 7, and 8 of the textbook used in COMP 170. The book is *not* required however for COMP 271. Instead, you may review the following material. And if you require additional reading resources, please let me know.

* [Classes and Objects tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html) from the Java documentation project. Skip the material for nested classes and enum(eration)s for now.

* [Java in a Nutshell](https://learning.oreilly.com/library/view/java-in-a/9781098130992/), avaiable from the O'Reilly platform at no cost when you use your LUC email to login.