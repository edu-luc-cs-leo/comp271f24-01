# Technical note: SillyActions interface

This assignment implements the interface [`SillyActions](./SillyActions.java).

## Overall remarks

The assignment appears simple and, to a great extent it is. However, the details are in the implementation and specifically in the compliance with the Programmer's Pact or similar coding style guides. Let's take method `makeRandomSound`, for example:

```java
/**
 * Make a random sound. Actually, produce a random word and print it (no need to
 * find how to make an actual sound)
 */
void makeRandomSound();
```

The method is specified `void`. Therefore the method can print. (Any method can print, but in general we limit printing to void methods and avoid printing from non-void methods). But print what? Where do the random words come from? You can words the array `PoemWords.words` or you can introduce a sound-like array. In either case, you'll need to be able to select an array element at random. You'll need an instance of `Random`. You may create such instance inside the method. I use a single instance of `Random` for the entire program, assigning it to a class constant.

Your code does not have to be as parametric and randomized as mine. But it should be a more more sophisticated than writing a plain vanilla method like
```java
public void makeRandomSound() {
    System.out.println("boo"); // "boo" is magic value :-(
}
```



## Assessment guidelines

### Red-level issues

* Program does not compile/execute.
* Program has minimal or no comments.
* Program has non descriptive variable names, such as single-letter names -- ok to use them for loop indices though.
* Any violation of the Programmer's Pact is a red issue.
* No Javadoc.
* **Code has magic values**. Any string that is not the empty string (`""`) or the space string (`" "`) is considered a magic value. Any number than is not a 0 or 1 (or -1) is a magic value.

### Yellow level issues

* Program executes but results are not as expected and significantly different from specs.
* Your code could be a bit more creative.


### Green level issues

* Output is close to specified but not identical
