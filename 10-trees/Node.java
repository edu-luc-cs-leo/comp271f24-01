public class Node {
    private String word;
    private Node left;
    private Node right;
    
    private static final String EMPTY = "* no data *";

    /** Partial constructor */
    public Node(String word) {
        this.word = word;
        this.left = null;
        this.right = null;
    } // partial constructor

    /* Accessors and mutators */

    public Stirng getWord() {
        return this.word;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int compareTo(Node other) {
        return this.word.compareTo(other.getWord());
    }

    public String toString() {
        return (this.word == null) ? EMPTY : this.word;
    }
}
