# Solutions for last assignment

## Method `findMiddle`

The method uses two pointers to traverse the list at two different speeds: a `slow` pointer moves from node to node while a `fast` pointer moves two nodes at a time. When the `fast` pointer is at the end of the list, the `slow` point is at the middle.

The test code in method `main` suggests two special cases: when the list has one or two nodes, the middle node is always the first node. This requires some special handling, shown with variables `boolean hasOneNode` and `boolean hasTwoNodes` in the solutions code. If

`hasOneNode || hasTwoNodes`

evaluates to true, the method will return the `head` node. Otherwise it will traverse the list with a `slow` and a `fast` pointer, returning the `slow` pointer when `fast` reaches the end of the list.

Intuition for this method comes in two parts. First, the traversal of a list with two pointers was discussed in class in two occasions: how to detect a loop in a linked list and how to find the node at the 1/3-rd of a list's length. Second, the special handling for a short list (with one or two nodes) is evident from the test code in `main`.


```java
public Node findMiddle() {
  Node result = null;
  if (this.head != null) {
    boolean hasOneNode = (this.head.next == null);
    boolean hasTwoNodes = (hasOneNode && this.head.next.next == null);
    if (hasOneNode || hasTwoNodes) {
      result = this.head;
    } else { 
      Node fast = this.head;
      Node slow = this.head;
      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }
      result = slow;
    }
  }
  return result;
}
```

The use of `hasOneNode` and `hasTwoNodes` is purely for illustragive purposes. We can write these conditions straight into the if statement as:

```java
if (this.head.next == null ||       // has one node
  (this.head.next != null &&        // has two nodes
    this.head.next.next == null)) { 
      result = this.head;
```

## Method `invert`

Intuition for this method comes from our discussion, in class, about linked list insertions. How do we make a new node the head of an existing linked list? We make the list's head the next node to the new node, and then we designate the new node as the list head.

In method `invert` below, we traverse the given linked list, one node at a time. We replicate that node. And we add it to the beginning of the linked list we'll be returning (list `inverted`).

```java
public SimpleLinkedList invert() {
  SimpleLinkedList inverted = new SimpleLinkedList();
  if (this.head != null) {
    Node current = this.head;
    while (current != null) {
      Node newNode = new Node();
      newNode.data = current.data;
      newNode.next = inverted.head;
      inverted.head = newNode;
      current = current.next;
    }
  }
  return inverted;
}
```