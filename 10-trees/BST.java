/**
 * A simple binary search tree
 */
public class BST {

    /**
     * Constants
     */
    private static final String LONGEST = "";
    private static final String SHORTEST = " ".repeat(1024);
    /**
     * The entry point to the tree
     */
    private TreeNode root;

    /**
     * Count of nodes in the tree
     */
    private int numberOfNodes;

    /**
     * Longest and shortest words stored in the tree
     */
    private String longest;
    private String shortest;

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    /**
     * Default constructor
     */
    public BST() {
        this.root = null;
        this.numberOfNodes = 0;
        this.shortest = SHORTEST;
        this.longest = LONGEST;
    } // default constructor

    /**
     * Overloaded add to take a string, wrap it into a TreeNode object, and invoke
     * the principal method that adds a note to the tree.
     *
     * @param word String to add, as a node, to the tree
     */
    public void add(String word) {
        TreeNode newNode = new TreeNode(word);
        add(newNode);

    } // method add

    /**
     * Add method adapted from provided ChatGPT code.
     * After creating a new node containing the word to be
     * added in method add above, we send it to this method.
     * First, we check if the tree has no elements. If this
     * is the case, the new node is the root. Otherwise, we
     * create two new nodes: one to represent the root (where
     * we start our traversal) and parent which represents
     * the node we are operating on. In this sense, since we
     * are adding a node, this new node will be the child of
     * the node we are currently looking at (parent). We then
     * determine which element to swap by comparing current
     * to the nodes to the left and right. Finally, we
     * set parent's left or right node depending on
     * the comparison.
     *
     * @param node TreeNode: The node to add
     */
    public void add(TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root; // Start at the top of the tree
            TreeNode parent = null;

            while (current != null) {
                parent = current; // set parent to current as we are working top down
                if (node.compareTo(current) < 0) { // determine if new node should go left
                    current = current.getLeft();
                } else if (node.compareTo(current) > 0) { // determine if new node should go right
                    current = current.getRight();
                } else {
                    current = current; // Adaptation without using a return statement
                }
            }
            // update the left or right node of parent
            if (node.compareTo(parent) < 0) {
                parent.setLeft(node);
            } else {
                parent.setRight(node);
            }
            numberOfNodes++;
            if (node.getWord().length() > longest.length()) {
                longest = node.getWord();
            } else if (node.getWord().length() < shortest.length()) {
                shortest = node.getWord();
            }

        }

    } // method add

    /**
     * Method to check if the binary search tree contains a specific String within a node.
     * Since a BST is sorted top down, we can walk down the tree, comparing the given
     * value with each string, moving left if it would be to the left of the current node,
     * and moving right if it would be to the right.
     *
     * @param target String: string to search for
     * @return boolean: true if found, false otherwise
     */
    public boolean contains(String target) {
        boolean found = false;
        if (root != null && target != null) {
            TreeNode current = this.root;
            while (current != null && !found) {
                int comparison = target.compareTo(current.getWord());
                if (comparison < 0) {
                    current = current.getLeft();
                } else if (comparison > 0) {
                    current = current.getRight();
                } else {
                    found = true;
                }
            }
        }
        return found;

    } // method contains

    /**
     * Overloaded remove method that supplies the principal method with
     * the string to remove and the root of the BST.
     *
     * @param target String: target string to remove
     * @return TreeNode: the removed node
     */
    public TreeNode remove(String target) {
        return remove(target, this.root);
    }

    /**
     * Principal remove method. This method removes a node containing a target string and
     * re-balances the tree depending on the number of children. We handle 3 cases:
     * if the node to delete has no children, we simply nullify the parent's pointer
     * that links to the target node
     * if the node to delete has one child, we point the target's parent to the next node
     * down from the target, either left or right depending on the results of a
     * comparison
     * if the node to delete has two children, we minimize the problem into one of
     * the prior cases using the inorder successor method.
     * The first step in this process is to walk the tree to find where the target
     * resides, if it does. By the end of the first half of this method, we have a variable
     * link to both the target node and its parent. Then, we simply check which case
     * that node falls under (0, 1, or 2 children) and operate accordingly.
     *
     * @param target  String: the string to search all nodes for
     * @param current TreeNode: where to start our search
     * @return TreeNode: node containing target
     */
    public TreeNode remove(String target, TreeNode current) {
        TreeNode removed = null;
        if (target != null && current != null && this.root != null) {
            TreeNode cursor = this.root;
            TreeNode parent = null;
            boolean found = false;
            while (!found && cursor != null) {
                if (target.compareTo(cursor.getWord()) == 0) {
                    found = true;
                } else if (target.compareTo(cursor.getWord()) < 0) {
                    parent = cursor;
                    cursor = cursor.getLeft();
                } else {
                    parent = cursor;
                    cursor = cursor.getRight();
                }
            } // target has either been found or not found.
            if (found && parent != null && parent.getLeft() != null) {
                removed = cursor;
                if (cursor.numChildren() == 0) { // case for zero children
                    if (parent.getLeft().getWord().compareTo(target) == 0) { // node to left of parent contains target
                        parent.setLeft(null); // remove pointer to node
                    } else {
                        parent.setRight(null); // remove pointer to node
                    }
                } else if (cursor.numChildren() == 1) { // case for one child
                    if (parent.getLeft().getWord().compareTo(target) == 0) { // node to left of parent contains target
                        if (cursor.getLeft() != null) { // if the node to remove has nothing to the left
                            parent.setLeft(cursor.getLeft());
                        } else {
                            parent.setLeft(cursor.getRight());
                        }
                    } else { // node to right of parent contains target
                        if (cursor.getRight() != null) {
                            parent.setRight(cursor.getLeft());
                        } else {
                            parent.setRight(cursor.getRight());
                        }
                    }
                } else { // case for two children
                    TreeNode successor = cursor.getRight();
                    while (successor.getLeft() != null) {
                        successor = successor.getLeft();
                    } // found successor
                    cursor.setRight(successor);
                    remove(successor.getWord(), cursor.getRight());
                }
            }

        } // guard statement

        return removed;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Binary Search Tree:\n");
        sb.append("Total Nodes: ").append(numberOfNodes).append("\n");
        sb.append("Longest Word: ").append(longest).append("\n");
        sb.append("Shortest Word: ").append(shortest).append("\n");
        return sb.toString();
    }

    /*
    Testing
     */
    public static void main(String[] args) {
        BST bst = new BST();

        bst.add("Hello");
        bst.add("World");
        bst.add("green");
        bst.add("a");
        System.out.println(bst.contains("Hello"));
        ;
        System.out.println(bst.toString());
        bst.remove("World");
        System.out.println(bst.toString());
    }

}