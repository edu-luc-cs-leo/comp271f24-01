public class BST {

    private Node root;

    public void add(String word) {
        this.add(new Node(word));
    }

    public void add(Node node) {
        if (node!=null) {
        if (this.root == null) {
            this.root = node;
        } else {
            Node cursor = this.root;
            while (cursor != null) {
                if (node.compareTo(cursor) < 0) {
                    cursor = cursor.getLeft();
                } else if (node.compareTo(cursor) > 0) {
                    cursor = cursor.getRight;
                }
            }
        }
    }
}

}
