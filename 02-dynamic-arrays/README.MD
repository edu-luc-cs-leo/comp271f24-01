# Assignment 02

## Part I: code review of previous assignment

Using the solution and the technical note for the [previous assignment](../01-large-number-multiplication/), conduct a code review for your Calendar program. In your review:

* describe any red, yellow, or green level issues with your code. For red and yellow issues, discuss what led to them;
* suggest how the code could be improved;
* reflect if the quality of your code is related to time management and how to mitigate things.
* propose how Leo's code can be improved.

Your review must exude professionalism: few (ideally no) typos, and nicely organized. You may produce it as a PDF file to attach to Sakai, or as plain text typed straight in the Sakai textbox. It may be a good idea if you used an editor to compose your review, then past the text in Sakai to avoid loss of data.

## Part II: creating a data structure object

Using the Java class `DynamicArray` provided here, write the following two methods:

* `public boolean contains(String target)` that returns `true` if `target` is present in the underlying array and `false` if it isn't.
* `public String get(int index)` that returns the string in position `[i]` in the underlying array or null if something wrong.

Notice that the methods are *not static.*  

Except for the contents of these two methods, you cannot modify the code provided here. 

Your code must be in full compliance with the [Programmer's Pact](../misc/ProgrammerPact.pdf). You may not import any package except of `Arrays` and only to use ``Arrays.toString`` (not actually needed for this assignment). Also you may not use any `System` utilities except for `System.out` print statetements.

Once you have the specified methods working properly, the code will compile and execute a few tests as shown below:

```
Test for contains(null): ............... Pass
Test for contains on null foundation: .. Pass
Test for contains (existing): .......... Pass
Test for contains (non existing): ...... Pass
Test for get(-1): ...................... Pass
Test for get(0): ....................... Pass
Test for get(out of bounds): ........... Pass
```