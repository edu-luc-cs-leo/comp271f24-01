# Assignment 08

## Part I: code review of previous assignment

Using the [solution](../07-testing/FastQ.java) and [technical note](../07-testing/TechNote.md) for the previous assignment, conduct a code review for your implementation of ``add`` and ``remove`` methods. In your review:

* describe any red, yellow, or green level issues with your code. For red and yellow issues, discuss what led to them;
* suggest how the code could be improved;
* reflect if the quality of your code is related to time management and how to mitigate things.
* propose how Leo's code can be improved.

Your review must exude professionalism: few (ideally no) typos, and nicely organized. You may produce it as a PDF file to attach to Sakai, or as plain text typed straight in the Sakai textbox. It may be a good idea if you used an editor to compose your review, then past the text in Sakai to avoid loss of data.
 

## Part II: $\mathcal O(n^2)$ and $\mathcal O(n\log_2n)$ sorting

Class `Sorting` implements brute-force sorting with method `insertionSort` and a more effective technique with method `mergeSort`. In class, we discussed how to experiment with running and comparing the two methods to establish their performance characteristics.

Using [`System.nanoTime()`](https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/System.html) we can measure the time it takes for a method to execute.

To get a good understanding of the performance characteristics of the two methods, we discussed testing them with arrays of various lengths: 2, 4, 8, etc. It's a good idea to use power-of-2 array lengths.

Using the results from your experiments illustrate and discuss the performance characteristics of the two sorting methods.

You may do your work in `Sorting.main`. However a *good programmer* most likely will write a separate method, for example `Sorting.experiment` to conduct and return the necessary measurements. Data can be plotted easily with Microsoft Excel or Google Sheet to provide a compeling illustration.

This is a simple example of a research assignment, asking you to run experiments, obtain measurement data, illustrate results, and discuss your findings.


## Reading material
 
* The most complete treatment of sorting algorithms is [Chapter 5](https://learning.oreilly.com/library/view/art-of-computer/9780321635792/ch05.xhtml) from Donald Knuth's *Art of Computer Programming: Volume 3: Sorting and Searching.* Section 5.2.4 deals with merge sort. Knuth's work takes some getting used to. Pseudocode is written in *assembly* for a fictitious computer called [MIX](https://en.wikipedia.org/wiki/MIX_(abstract_machine)).

* [Merge sort](https://learning.oreilly.com/library/view/40-algorithms-every/9781789801217/ed8567a5-2400-4e0b-8e22-5b55ee653ca9.xhtml) from Imran Ahmad's *40 Algorithms Every Programmer Should Know*.
