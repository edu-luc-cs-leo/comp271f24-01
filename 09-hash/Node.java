public class Node {

    private String payload;
    private Node next;

    public Node(String payload) {
        this.payload = payload;
        this.next = null;
    } // partial constructor

    public Node() {
        this(null);
    } // default constructor

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public String getPayload() {
        return this.payload;
    }

    public int hashCode() {
        return this.payload.hashCode();
    }

    public boolean equals(Node other) {
        return this.payload.equals(other.getPayload());
    }
}
