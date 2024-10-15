# Technical note: `insert`, `toString`, and `isEmpty` for `TrainLine`

This was the midterm assignment for the course.

## method ``insert``
This method may require a traversal of the train line. But first it's worth discussing its three distinct possibilities:

* `insert(this.numberOfStations-1, ...)` inserts a new station after the last station in the line. We already have a method that does that and we can use it without needing to write any (dublicate) code.
* `insert(0, ...)` inserts a new station right after the head of the line. There is no need to traverse the line.
* `insert(n, ...)` when `n` is neither 0 nor `this.numberOfStations-1`. In this case, we traverse to find the station after which we insert a new station.


```java
public void insert(String name, int after) {
    if (after > -1 && after < this.numberOfStations-1 && this.head != null) {
        if (after == this.numberOfStations) {
            // We are inserting after the last station, so we might as well
            // call the add method to do this for us
            this.add(name);
        } else {
            // Prep the station object to add
            TrainStation newStation = new TrainStation(name);
            // Prepare to find which statio to add after
            TrainStation priorStation = this.head;
            // Where is the prior station if not at the head?
            if (after > 0) {
                priorStation = this.head;
                int i = 0;
                while (i < after) {
                    priorStation = priorStation.getNext(); 
                    i++;
                }
            }
            newStation.setNext(priorStation.getNext());
            priorStation.setNext(newStation);
            this.numberOfStations++;
        }
    } // guard if
} // method insert
```


## method `toString`

This was the most difficult part of the assignment. It seems easy at the beginning, but without substantial planning and analysis, we can easily end up with cumbersone code and incorrect results.

[My solution](./LeftRightPrinting.java) is only partially completed to showcase the challenges of this method. The key aspects of this method are:

* Changing direction every other line.
* Aligning the end of each line with the "U-turn" that moves to the next line of content.
* Arranging constants for everything
* Measuring the length of each line proactively to ensure compliance with the 80-character limit.

Many of you have arrived to similar partial solutions: your left and right arrows were printing correctly, and the lines were within limits. Then things started getting messy, as you tried to improve vertical alignment.

If your partial solution is comparable to the partial solution I have posted here, it is fine. Of course we will make this perfect at some point.



## Assessment guidelines

### Red-level issues

* Program does not compile/execute.
* Program has minimal or no comments.
* Program has non descriptive variable names, such as single-letter names -- ok to use them for loop indices though.
* Any violation of the Programmer's Pact is a red issue.
* No Javadoc.
* **Code has magic values**. 
* Assignment is incomplete (one or more of the three required methods are missing; ungrading reflection is missing).

### Yellow level issues

* You are not using the keyword `this` when handling object fields in your code.
* Program executes but results are not as expected and significantly different from specs.
* Your code could be a bit more creative.


### Green level issues

* Output is close to specified but not identical
