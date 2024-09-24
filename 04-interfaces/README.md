# Assignment 04

## Part I: code review of previous assignment

Using the [solution](../03-wow-more-dynamic-arrays/DynamicArray_Solution.java) and the [technical note](../03-wow-more-dynamic-arrays/TechNote.md) for the previous assignment, conduct a code review for your **improved DynamicArray** program. In your review:

* describe any red, yellow, or green level issues with your code. For red and yellow issues, discuss what led to them;
* suggest how the code could be improved;
* reflect if the quality of your code is related to time management and how to mitigate things.
* propose how Leo's code can be improved.

Your review must exude professionalism: few (ideally no) typos, and nicely organized. You may produce it as a PDF file to attach to Sakai, or as plain text typed straight in the Sakai textbox. It may be a good idea if you used an editor to compose your review, then past the text in Sakai to avoid loss of data.

## Part I extended: re-review of assignments 02 and 03
*Added on 9/23/24, also due on 9/27/24.*

Please go back to your assignments 02 and 03 and count the following:

* How many **void** methods have a return statement
* How many *non void* methods have more than one return statement.
* How many times you use the calls `Arrays.copyOf` or `System.arraycopy`.

If the total of these counts is greater than 2 and you did not discuss the issue in your code reviews, reply to the email with subject `Red issues are more frequent that we think` and let me know, no later than Friday 9/27/24.


## Part II: implementing interfaces

For this assignment you'll work with the following files:

* [`SillyActions.java`](./SillyActions.java), an interface.
* [`Person.java`](./Person.java), an object class implementing the `Comparable` interface ([the real one](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Comparable.html)) and the `SillyActions` interface.
* [`PoemWords.java`](./PoemWords.java), a class with an array full of poetic words. You may access this array from other classes as `PoemWords.words`.

Write your most creative code in Person, to deliver the methods specified in `SillyActions`.

## Reading material

Our work for far is based on chapters 3, 4, 7, and 8 of the textbook used in COMP 170. The book is *not* required however for COMP 271. Instead, you may review the following material. And if you require additional reading resources, please let me know.

* [Interfaces tutorial](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)  from the Java documentation project.

* [Classes and Objects tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html) from the Java documentation project. Skip the material for nested classes and enum(eration)s for now.

* [Java in a Nutshell](https://learning.oreilly.com/library/view/java-in-a/9781098130992/), avaiable from the O'Reilly platform at no cost when you use your LUC email to login.