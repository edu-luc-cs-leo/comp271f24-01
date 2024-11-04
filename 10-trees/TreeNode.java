public class TreeNode implements Comparable<TreeNode> {

    /** The data payload of the node */
    private String word;
    /** Its left and right pointers */
    private TreeNode left;
    private TreeNode right;

    /**
     * Basic constructor creates a simple node with a payload and two null children.
     * 
     * @param word
     */
    public TreeNode(String word) {
        this.word = word;
        this.left = null;
        this.right = null;
    } // basic constructor

    public String getWord() {
        return word;
    }

    /** Implementation of Comparable using the nodes' content strings as basis for comparison. */
    public int compareTo(TreeNode other) {
        int result = 1;
        if (other != null)
            result = this.getWord().compareTo(other.getWord());
        return result;
    } // method compareTo
    
}