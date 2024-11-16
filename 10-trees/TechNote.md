# Technical note: `remove` and other BST operations

## Method `contains`

The assignment asked for 

```java
boolean contains(String target)
```
 to return true if `target` is present in the tree and false otherwise. 
 
 To achieve this, we must traverse the tree in directions that get us closer to the `target` string. These directions are determined by the comparison between `target` and the contents of the current node we are looking at. If `target` is lexicographically smaller, we go left, otherwie to the right.



 ## Method `toString()` 
 
 The key here was to to provide a *descriptive* text representation of the tree. For example, how many nodes it has, what's the shortest string and what's the longest. Additionally, we can provide some information about the range of the contents stored in the tree. But we should *not* produce every word stored.



 ## Method `remove`

 Based on work we did in-class, the method has three parts:


 * remove a node with no children;
 * remove a node with one child only;
 * and remove a node with two children.

 The first two cases are relatively straight forward: find the parent of the node to be deleted and adjust the parent's child reference.

 The second case requires that we reduce the problem to one of the two "easier" cases. To do so we replace the contents of the node-to-delete with those of its *in-order successor.* Then we delete the successor which is *guaranteed* to have 1 child at most.

 Removing the successor requires that we call the `remove` method on the right subtree under the node-to-delete.

 After the deletion, we must traverse the tree and ensure the `shortest` and `longest` values are correct, just in case we just deleted the shortest or the longest string in the tree. This traversal must be complete. Because the longest (or shortest) string can be anywhere in the tree. Method `findLongestShortest` does this traversal and updates as necessary.
 


## method `TreeNode.countChildren()`

We worked this method in class. Essentially, it's two tandem if-statements updating a variable initially at 0.


# Assessment guidelines

## Red-level issues


* Program does not compile/execute.
* Program has minimal or no comments.
* Program has non-descriptive variable names, such as single-letter names -- ok to use them for loop indices though.
* Any violation of the Programmer's Pact is a red issue.
* No Javadoc.
* **Code has magic values**. 
* Assignment is incomplete (one or more of the three required methods are missing; ungrading reflection is missing).

## Yellow level issues

* Your `toString` method prints the entire contents of the tree. It should bring some *descriptive* information only. For example, how many nodes are in the tree, what's the shortest string, etc.

## Green level issues

* Output is close to specified but not identical
