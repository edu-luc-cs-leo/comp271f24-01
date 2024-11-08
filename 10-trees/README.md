# Assignment 09

## Part I: code review of previous assignment

Using the [solution](../08-sorting/DemoSorting.java) and [technical note](../08-sorting/TechNote.md) for the previous assignment, conduct a code review for your implementation of your performance testig method(s). In your review:

* describe any red, yellow, or green level issues with your code. For red and yellow issues, discuss what led to them;
* suggest how the code could be improved;
* reflect if the quality of your code is related to time management and how to mitigate things.
* propose how Leo's code can be improved.

Your review must exude professionalism: few (ideally no) typos, and nicely organized. You may produce it as a PDF file to attach to Sakai, or as plain text typed straight in the Sakai textbox. It may be a good idea if you used an editor to compose your review, then past the text in Sakai to avoid loss of data.
 

## Part II: Building a binary search tree with the help of AI

In class last week, we used chatGPT to write a [method that adds a note to a binary search tree](https://chatgpt.com/share/67261841-62fc-8000-bc24-7b5b99c8f36a). We had to re-prompt before we got code that is compliant with our style restrictions (aka the [Programmer's Pact](../misc/ProgrammerPact.pdf)).

Review the code from chatGPT (by the first link above) and try to implement it in class `BST.java` here. Your code should have sufficient comments explaining what's the role of variable `parent`. Those comments should reflect your understanding of what `parent` does.

## Part III (will be assigned 11/8; due 11/15/24): delete a node.

Class `BST.java` comes with methods that add data to a binary search tree and perform in-order traversals of the tree.

Improve `BST.java` by adding the following methods.

* `boolean contains(String target)` that returns true if `target` is present in the tree and false otherwise.

* `String toString()` to provide a *descriptive* text representation of the object.

* `TreeNode remove(String target)` that removes the node with `target` from the tree and returns it. If the node is not present, the method will return null. This method require significant work. To begin with, it requires an overloaded version `TreeNode remove(String target, TreeNode belowNode)`. The simple version functions as a helper method, an initial call to the more complex method, e.g.,
```java
public TreeNode remove(String target) {
    TreeNode removed = null;
    if (target != null && this.root != null) {
        removed = this.remove(target, this.root);
    }
    return removed;
} // helper method remove
```

As always, your code must be in compliance with the [Programmer's Pact](../misc/ProgrammerPact.pdf).

## Reading material
 
* [Binary Search Trees](https://learning.oreilly.com/library/view/data-structures-the/9781098156602/c05.xhtml#h1-502604c05-0001) from Jeremy Kubica's * Data Structures the Fun Way*.

* [Speeding Up All the Things with Binary Search Trees](https://learning.oreilly.com/library/view/a-common-sense-guide/9781680508048/f_0143.xhtml) from Jay Wengrow's *A Common-Sense Guide to Data Structures and Algorithms*.
