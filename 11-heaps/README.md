# Assignment 11

## Part I: code review of previous assignment

Using the [solution](../10-trees/bstSolution.java) and [technical note](../10-trees/TechNote.md) for the previous assignment, conduct a code review for your implementation of your performance testig method(s). In your review:

* describe any red, yellow, or green level issues with your code. For red and yellow issues, discuss what led to them;
* suggest how the code could be improved;
* reflect if the quality of your code is related to time management and how to mitigate things.
* propose how Leo's code can be improved.

Your review must exude professionalism: few (ideally no) typos, and nicely organized. You may produce it as a PDF file to attach to Sakai, or as plain text typed straight in the Sakai textbox. It may be a good idea if you used an editor to compose your review, then past the text in Sakai to avoid loss of data.
 


## Part II: Huffman encoding with a minimum heap

For this assignment, you get the following classes

* `HuffmanNode.java` that provides binary nodes with two data fields: a `char` and an `int` to capture symbols or frequencies and points for up to two children. In addition to the expected constructors, getters, and setters, the class implements the `Comparable` interface and a `toString` method. Comparisons are based on the `int` contents of the nodes.

* `MinHeap.java` that builds a minimum heap storage using a dynamic array (aka, an ArrayList). The class works with any object that implements the comparable interface, for example `String`. Notice that class `HuffmanNode` also implements `Comparable` and therefore we can use it in `MinHeap`, e.g.
<ul>

```java
MinHeap<HuffmanNode> myHeap = new MinHeap()<>;
HuffmanNode newNode = new HuffManNode('E', 1);
myHeap.insert(newNode); // etc
```
</ul>

* `HuffmanEncoding.java` is a program that compresses a string using Huffman encoding. The tasks required for this compression are used in method `encode`. Basically, the class has a method to find the frequencies of the symbols in the message we wish to compress, then encapsulate symbos and their frequency in a `HuffmanNode`, then add these nodes to an ArrayList, then apply the Huffman method removing the nodes with the least frequency from the list, combining them, and adding the new node back in the list. When there is only one node left, that's our Huffman tree. Method `createEncodingTable` produces the encoding table based on the three.<br/><br/>

**Your assignment:** using `HuffmanEncoding.java` as a template, write a new class called `HuffmanEncodingWithHeap.java` that uses a `MinHeap` in methods `buildForest` and `buildTree`. Your `HuffmanEncoding.java` *should not* have the method `findSmallest`.

The objective of your `HuffmanEncodingWithHeap.java` is to construct a Huffman tree. This is the binary tree with symbol nodes as its leaves. These nodes contain symbols and their frequencies, e.g., `'E':1`, `'H':1`, `'L':3`, etc. The tree also contains frequency-only nodes, i.e., nodes that have no symbol data but only a frequency value that corresponds to the sum of frequencies of their children. Every node in this tree that is not a leaf node, is a frequency-only node.

In the given `HuffmanEncoding.java`, the Huffman tree is the remaining element in an arraylist of `HuffmanNode` objects. We remove two nodes at a time from that arraylist, combine them under a new node, and place that node back to the arraylist.

In your `HuffmanEncodingWithHeap`, your HuffmanNodes must be stored as a `MinHeap`. You'll use the appropriate method from class `MinHeap` to remove the smallest nodes, then combine them under a new node, and that node will be added to the MinHeap. It is up to you to determine how to manage this tree that is no longer represented as `ArrayList forest`.

## Reading material
 
* [Leo's slide deck from Friday 11/15/24](https://docs.google.com/presentation/d/1kSXEB7mzumoUm4pw7dhtxJxX7xckzjpUDyWlGfAxzAI/edit?usp=sharing).

* [Heaps](https://learning.oreilly.com/library/view/data-structures-and/9780134849775/ch12.xhtml) from *Data Structures and Algorithms in Java* by Robert Lafore.

* D. Huffman's original paper: [A Method for the Construction of Minimum-Redundancy Codes](../misc/huffman_1952_minimum-redundancy-codes.pdf)

* Scientific American's [profile on David Huffman](https://www.huffmancoding.com/my-uncle/scientific-american).