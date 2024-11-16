import java.util.ArrayList;

public class HuffmanEncoding {

    private static final int ASCII8 = 256;
    private static final char LEFT = '0';
    private static final char RIGHT = '1';
    private static final String EMPTY = "";
    private static final int BITS_PER_BYTE = 8;

    /**
     * Parses a string and produce a frequency count for each of its symbols. Counts
     * are stored in an array with a place for each possible ASCII character -- all
     * 26 of them. Many elements in the array will have a frequency of 0 because
     * they correspond to not printable characters.
     * 
     * @param message String to parse, one character at a time.
     * @return array with frequency count for each possible ASCII value.
     */
    static public int[] countFrequency(String message) {
        int[] frequencies = new int[ASCII8];
        // Nothing to parse if message is null
        if (message != null) {
            for (int i = 0; i < message.length(); i++) {
                frequencies[(int) message.charAt(i)]++;
            }
        }
        return frequencies;
    } // method countFrequncy

    /**
     * Build an array of Huffman nodes, each a minimal tree containing a symbol and
     * its frequency as it appears in a string we wish to compress.
     * 
     * @param frequencies int[] with the frequency counts for each ASCII symbol
     * @return an ArrayList of HuffmanNodes, essentially a forest of minimal trees,
     *         ie, trees with one node each, and no children.
     */
    public static ArrayList<HuffmanNode> buildForest(int[] frequencies) {
        ArrayList<HuffmanNode> forest = new ArrayList<>();
        for (int asciiCode = 0; asciiCode < frequencies.length; asciiCode++) {
            // Process only characters that appear in the string we want to compress. The
            // frequency count of these characters will be greater than 0.
            if (frequencies[asciiCode] > 0) {
                forest.add(new HuffmanNode((char) asciiCode, frequencies[asciiCode]));
            }
        }
        return forest;
    } // method buildForest

    /**
     * Apply Huffman's algorithm to organize a forest of Huffman nodes into a
     * Huffman tree. To achive this, we remove the two nodes of least frequency from
     * the forest, make them left and right children for a new node with no symbol
     * and a combined frequency of its children and place it back to the forest. At
     * each iteration, the forest size is reduced by 1 node. When there is 1 node
     * left in the forest, it's the root of the Huffman tree.
     * 
     * @param forest ArrayList of HuffmanNodes with symbol and frequency data
     * @return a HuffmanNode which is the root of the Huffman tree
     */
    public static HuffmanNode buildTree(ArrayList<HuffmanNode> forest) {
        while (forest.size() > 1) {
            // Remove the two nodes with the least frequencies from the forest
            HuffmanNode t1 = findSmallest(forest);
            HuffmanNode t2 = findSmallest(forest);
            // Create a new node that has no symbol and its frequency is the total frequency
            // of the removed nodes.
            HuffmanNode combined = new HuffmanNode(t1.getFrequency() + t2.getFrequency());
            // Make the removed nodes the left and right children of the new node.
            combined.setLeft(t1);
            combined.setRight(t2);
            // Place the new node back into the forest.
            forest.add(combined);
        }
        // The only node remaining in the forest is the root of the Huffman tree
        return forest.get(0);
    } // method buildTree

    /**
     * Find and remove the lowest frequency node from an array of nodes.
     * 
     * @param forest Arraylist of Huffman nodes
     * @return the node with the lowest frequency
     */
    public static HuffmanNode findSmallest(ArrayList<HuffmanNode> forest) {
        // Assume that the first element in the arraylist is the smallest
        int smallestIndex = 0;
        // Greedy traversal of the arraylist in search for the smallest node
        for (int i = 1; i < forest.size(); i++) {
            if (forest.get(i).compareTo(forest.get(smallestIndex)) < 0) {
                smallestIndex = i;
            }
        }
        // remove and return the smallest node
        return forest.remove(smallestIndex);
    } // method findSmallest

    /**
     * Recursive traversal of a Huffman tree to produce an encoding table.
     * 
     * @param node  Huffman tree node to process
     * @param code  encoding value up to the current point in traversal
     * @param codes String[] with Huffman codes produced so far.
     */
    public static void createEncodingTable(HuffmanNode node, String code, String[] codes) {
        // Only process non-null nodes
        if (node != null) {
            // Base case when node has a symbol -- we've reach a leaf node in the tree
            if ((int) node.getSymbol() != 0) {
                codes[(int) node.getSymbol()] = code;
            } else {
                // Recursive case: intermediate nodes; explore their children updating the
                // corresponding code with left and right information
                createEncodingTable(node.getLeft(), code + LEFT, codes);
                createEncodingTable(node.getRight(), code + RIGHT, codes);
            }
        }
    } // method createEncodingTable

    /**
     * Helper method to launch the recursive traversal of the Huffman tree
     * 
     * @param node The root of the Huffman tree
     * @return String[] indexed by ASCII values (0-255) containing the Huffman code
     *         for the corresponding character
     */
    public static String[] createEncodingTable(HuffmanNode node) {
        String[] codes = new String[ASCII8];
        createEncodingTable(node, EMPTY, codes);
        return codes;
    } // method createEncodingTable

    /**
     * Prints out the Huffman codes for ASCII symbols in a given message
     * 
     * @param codes String[] the Huffman codes indexed by ASCII value
     */
    public static void displayCodes(String[] codes) {
        for (int i = 0; i < codes.length; i++) {
            if (codes[i] != null) {
                System.out.printf("\n '%s' --> %-10s", (char) i, codes[i]);
            }
        }
    } // method displayCodes

    /**
     * Computes the number of bits required for the compressed message
     * 
     * @param message String to compress
     * @param codes   Huffman codes for compression
     * @return int with length of compressed message
     */
    public static int computeCompressionLength(String message, String[] codes) {
        int compressionLength = 0;
        for (int i = 0; i < message.length(); i++) {
            compressionLength += codes[(int) message.charAt(i)].length();
        }
        return compressionLength;
    } // method computeCompressionLength

    /**
     * Prints a brief report about the length of the compressed message v. the
     * length of the uncompressed message.
     * 
     * @param message String to compress
     * @param codes   Huffman codes for compression
     */
    public static void reportEfficiency(String message, String[] codes) {
        System.out.printf("\nCompressed message requires %d bits versus %d bits for ASCII encoding.\n",
                computeCompressionLength(message, codes), message.length() * BITS_PER_BYTE);
    } // method reportEfficiency

    /**
     * Orchestate the Huffman encoding of a string
     * 
     * @param message String to encode/compress
     */
    static void encode(String message) {
        int[] frequencies = countFrequency(message);
        ArrayList<HuffmanNode> forest = buildForest(frequencies);
        HuffmanNode huffmanTreeRoot = buildTree(forest);
        String[] codes = createEncodingTable(huffmanTreeRoot);
        displayCodes(codes);
        reportEfficiency(message, codes);
    } // method encode

    /** Driver code */
    public static void main(String[] args) {
        String message = "now is the winter of our discontent made glorious by this son of york and all the clouds that lourd over our house in the deep bossom of the ocean lay";
        encode(message);
    } // method main

} // class Huffman