/**
 * A simple binary search tree
 */
public class BST {

    /** The entry point to the tree */
    private TreeNode root;
    /** Count of nodes in the tree */
    private int nodesCount;

    /** Default constructor */
    public BST() {
        this.root = null;
        this.nodesCount = 0;
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

    public void add(TreeNode node) {
    } // method add
}