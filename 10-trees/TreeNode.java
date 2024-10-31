public class TreeNode implements Comparable<TreeNode> {

    private String word;
    private TreeNode left;
    private TreeNode right;

    public String getWord() {
        return word;
    }

    public int compareTo(TreeNode other) {
        int result = 1;
        if (other != null)
            result = this.getWord().compareTo(other.getWord());
        return result;
    }
    
}