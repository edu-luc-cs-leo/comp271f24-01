import java.util.ArrayList;;

/**
 * A simple binary search tree
 */
public class bstSolution {

    /** The entry point to the tree */
    private TreeNode root;
    /** Count of nodes in the tree */
    private int numberOfNodes;
    /** Longest and shortest words stored in the tree */
    private String longest;
    private String shortest;

    /** Default constructor */
    public BST() {
        this.root = null;
        this.numberOfNodes = 0;
        this.shortest = null;
        this.longest = null;
    } // default constructor

    /**
     * Overloaded add to take a string, wrap it into a TreeNode object, and invoke
     * the principal method that adds a note to the tree.
     * 
     * @param word String to add, as a node, to the tree
     * 
     */
    public void add(String word) {
        this.add(new TreeNode(word));
    } // method add

    /**
     * Insert a new node into the tree; the method takes no action if a node with
     * the same payload already exists in the tree.
     * 
     * @param newNode node to insert
     */
    public void add(TreeNode newNode) {
        if (this.root == null) {
            this.root = newNode;
            this.numberOfNodes = 1;
            this.shortest = newNode.getWord();
            this.longest = newNode.getWord();
        } else {
            TreeNode cursor = this.root;
            TreeNode parent = null;
            boolean duplicate = false;
            while (cursor != null && !duplicate) {
                parent = cursor;
                duplicate = newNode.compareTo(cursor) == 0;
                if (newNode.compareTo(cursor) < 0) {
                    cursor = cursor.getLeft();
                } else {
                    cursor = cursor.getRight();
                }
            }
            // The while loop ends when it finds a spot for the new node or when discovering
            // a duplicate entry. If there is a duplicate entry, there will be no insertion.
            if (!duplicate) {
                if (newNode.compareTo(parent) < 0) {
                    parent.setLeft(newNode);
                } else {
                    parent.setRight(newNode);
                }
                this.numberOfNodes++;
                if (newNode.getWord().length() > this.longest.length()) {
                    this.longest = newNode.getWord();
                }
                if (newNode.getWord().length() < this.shortest.length()) {
                    this.shortest = newNode.getWord();
                }
            }
        }
    } // method add

    /**
     * In order traversal of a tree
     * 
     * @return a String[] with the contents of the tree as they appear
     */
    public void traverseInOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.println(node.getWord());
            traverseInOrder(node.getRight());
        }
    } // method traverseInOrder

    /**
     * Helper method to start in-order traversal
     */
    public void traverseInOrder() {
        if (this.root != null) {
            this.traverseInOrder(this.root);
        }
    } // helper method traverseInOrder

    /**
     * Finds a string in the tree
     * 
     * @param target String to search for
     * @return true if found, false otherwise
     */
    public boolean contains(String target) {
        boolean found = false;
        if (this.root != null && target != null) {
            TreeNode cursor = this.root;
            while (!found && cursor != null) {
                found = cursor.getWord().equals(target);
                if (target.compareTo(cursor.getWord()) < 0) {
                    cursor = cursor.getLeft();
                } else {
                    cursor = cursor.getRight();
                }
            }
        }
        return found;
    } // method contains

    /**
     * Helper method to initiate removal of a node from the tree The node is
     * identified by its content.
     * 
     * @param target String content of node to remove.
     * @return removed node or null if node with specified content not present in
     *         tree.
     */
    public TreeNode remove(String target) {
        TreeNode removed = null;
        if (target != null && this.root != null) {
            removed = this.remove(target, this.root);
        }
        return removed;
    } // helper method remove

    /**
     * Removes a node from the tree and returns it. If target node doesn't exist the
     * method returns a null.
     *
     * @param target Contents of node to remove
     * @return removed note
     */
    public TreeNode remove(String target, TreeNode underNode) {
        TreeNode removed = null;
        // First find the node
        TreeNode cursor = underNode;
        TreeNode parent = null;
        boolean found = false;
        while (cursor != null && !found) {
            parent = cursor;
            found = target.equals(cursor.getWord());
            if (target.compareTo(cursor.getWord()) < 0) {
                cursor = cursor.getLeft();
            } else if (target.compareTo(cursor.getWord()) > 0) {
                cursor = cursor.getRight();
            }
        }
        if (found) {
            // cursor is node to delete; parent is its parent node.
            // Prepare the return variable
            removed = cursor;
            // Determine if we are removing a node with no children or a node with only one
            // child or a node with two children
            if (cursor.numberOfChildren() == 0) {
                // node to delete has no children, just nullify it
                if (parent.hasLeft()) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            } else if (cursor.numberOfChildren() == 1) {
                // node to delete has only one child; connect it to its grandparent
                if (parent.hasLeft()) {
                    if (cursor.hasLeft()) {
                        parent.setLeft(cursor.getLeft());
                    } else {
                        parent.setLeft(cursor.getRight());
                    }
                } else {
                    if (cursor.hasLeft()) {
                        parent.setRight(cursor.getLeft());
                    } else {
                        parent.setRight(cursor.getRight());
                    }
                }
                // Update shortest, longest, just in case
                this.findLongestShortest();
            } else {
                // Node to delete has two children; first find its successor
                TreeNode succesor = cursor.getRight();
                while (succesor.hasLeft()) {
                    succesor = succesor.getLeft();
                }
                // Copy contents
                cursor.setWord(succesor.getWord());
                // Now remove the successor from the right subtree
                this.remove(target, cursor.getRight());
            }
        }
        return removed;
    } // method remove

    /**
     * Traverses the entire tree in search of the longest and shortest string and
     * updates the corresponding fields accordingly.
     */
    private void findLongestShortest() {
        ArrayList<TreeNode> stack = new ArrayList<>();
        stack.add(this.root);
        while (stack.size() > 0) {
            TreeNode cursor = stack.remove(0);
            if (cursor.hasLeft())
                stack.add(0, cursor.getLeft());
            if (cursor.getWord().length() < this.shortest.length())
                this.shortest = cursor.getWord();
            if (cursor.getWord().length() > this.longest.length())
                this.longest = cursor.getWord();
            if (cursor.hasRight())
                stack.add(0, cursor.getRight());
        }
    } // method findLongestShortest

    /**
     * Descriptive text representation; it returns information about the contents of
     * the tree and not the actual contents. For the actual contents we can use the
     * in-order traversal of the tree.
     */
    public String toString() {
        // Local constants
        final String EMPTY = "*The tree is empty.*";
        final String NODES_FMT = "There are %d nodes in the tree.\n";
        final String ROOT_FMT = "The tree is rooted at \"%s\".\n";
        final String SHORTEST_FMT = "The shortest entry is \"%s\" with %d characters.\n";
        final String LONGEST_FMT = "The longest entry is \"%s\" with %d characters.\n";
        final String LEX_FMT = "Range of contents: [%s]-[%s]";
        StringBuilder sb = new StringBuilder();
        if (this.root == null) {
            sb.append(EMPTY);
        } else {
            sb.append(String.format(NODES_FMT, this.numberOfNodes));
            sb.append(String.format(ROOT_FMT, this.root.getWord()));
            sb.append(String.format(SHORTEST_FMT, this.shortest, this.shortest.length()));
            sb.append(String.format(LONGEST_FMT, this.longest, this.longest.length()));
            // Find the lexigographically smallest word
            TreeNode cursor = this.root;
            while (cursor.hasLeft()) {
                cursor= cursor.getLeft();
            }
            String lexMin = cursor.getWord();
            // Find the lexicographically largest word
            cursor = this.root;
            while (cursor.hasRight()) {
                cursor = cursor.getRight();
            }
            String lexMax = cursor.getWord();
            sb.append(String.format(LEX_FMT, lexMin, lexMax));
        }
        return sb.toString();
    } // method toString

    /* Accessors */

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public String getLongest() {
        return longest;
    }

    public String getShortest() {
        return shortest;
    }
}