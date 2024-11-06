/**
 * A simple binary search tree
 */
public class BST {

    /* Constants */
    private static final String LONGEST = "";
    private static final String SHORTEST = " ".repeat(1024);

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
        this.add(new TreeNode(word));
    } // method add

    public void add(TreeNode node) {
        // After inserting a new node successfully,
        // increment numberOfNodes by 1.

        // Also when successful insertion update longest and shortest string based on
        // length comparison with node.getWord().length()

        // For shortest string exclude spaces.
        
    } // method add

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

}