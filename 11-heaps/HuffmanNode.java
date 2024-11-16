public class HuffmanNode implements Comparable<HuffmanNode> {

    private char symbol;
    private int frequency;
    private HuffmanNode left;
    private HuffmanNode right;

    // Constructors

    public HuffmanNode(char symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
    }

    public HuffmanNode(int frequency) {
        this((char) 0, frequency);
    }

    // Setters and Getters

    public char getSymbol() {
        return symbol;
    }

    public int getFrequency() {
        return frequency;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    @Override
    /** Implementation of the comparable interface */
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.getFrequency();
    }

    @Override
    /** String representation */
    public String toString() {
        return String.format("'%s':%d", this.symbol, this.frequency);
    }
}
