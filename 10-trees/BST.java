/**
 * A simple binary search tree
 */
public class BST {

    /** Constants */
    private static final String LONGEST = "";
    private static final String SHORTEST = " ".repeat(1024);
    /** The entry point to the tree */
    private TreeNode root;

    /** Count of nodes in the tree */
    private int numberOfNodes;

    /** Longest and shortest words stored in the tree */
    private String longest;
    private String shortest;

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    /** Default constructor */
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
     *
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

        }

    } // method add
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

    public TreeNode remove(String target) {
        return remove(target, this.root);
    }

    // use num children method
    public TreeNode remove(String target, TreeNode node) {
        TreeNode removed = null;
        if (target != null && node != null) {
            TreeNode cursor = this.root;
            TreeNode parent = null;
            boolean found = false;
            while (!found || cursor != null) {
                if (target.equals(cursor.getWord())) {
                    found = true;
                } else if (target.compareTo(cursor.getWord()) < 0) {
                    parent = cursor;
                    cursor = cursor.getLeft();
                } else {
                    parent = cursor;
                    cursor = cursor.getRight();
                }
            } // target has either been found or not found
            if (found) {
                removed = cursor; // we are at the correct node
                if (cursor.numChildren() == 0) { // case for 0 children
                    if (parent.getLeft().getWord().compareTo(target) == 0) { // if the node to the left of parent contains target
                        parent.setLeft(null); // remove the node
                    } else { // if the node to the right of parent contains target
                        parent.setRight(null);
                    }
                } else if (cursor.numChildren() == 1) { // case for 1 child
                    if (parent.getLeft().getWord().compareTo(target) == 0) { // if node to the left of parent contains target
                        if (cursor.getLeft() != null) { // if the node to remove has nothing to the left
                            parent.setLeft(cursor.getLeft());
                        } else {
                            parent.setLeft(cursor.getRight());
                        }
                    } else {
                        if (cursor.getLeft() != null) {
                            parent.setRight(cursor.getLeft());
                        } else {
                            parent.setRight(cursor.getRight());
                        }
                    }
                } else {
                    TreeNode successor = cursor.getRight();
                    while (successor.getLeft() != null) {
                        successor = successor.getLeft();
                    } // found successor
                    cursor.setRight(successor);
                    remove(successor.getWord(), cursor.getRight());
                }
            } else {
                removed = null;
            }

        } // check statement
        return removed;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Binary Search Tree:\n");
        sb.append("Total Nodes: ").append(numberOfNodes).append("\n");
        sb.append("Longest Word: ").append(longest).append("\n");
        sb.append("Shortest Word: ").append(shortest).append("\n");
        sb.append("Array representation: [").append(root.getWord()).append(", ");
        return sb.toString();
    }


}