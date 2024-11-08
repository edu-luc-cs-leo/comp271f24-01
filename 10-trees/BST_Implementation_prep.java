public class BST_Implementation_prep {

    public static void main(String[] args) {
        BST_prep demo = new BST_prep();
        String[] words = {
                "now", "is", "the", "winter", "of", "our", "discontent",
                "made", "glorious", "by", "this", "son", "of", "york",
                "and", "all", "the", "clouds", "that", "lourd", "upon",
                "our", "house", "in", "the", "deep", "bosom", "of",
                "the", "ocean", "buried", "now", "are", "our", "brows",
                "bound", "with", "victorious", "wreaths", "our",
                "bruised", "arms", "hung", "up", "for", "monuments",
                "our", "stern", "alarums", "changed", "to",
                "merry", "meetings", "our", "dreadful", "marches",
                "to", "delightful", "measures"
        };
        for (String word : words) {
            demo.add(word);
        }
        demo.traverseInOrder();
        System.out.println(demo.contains("Leo"));
        System.out.println(demo.contains("winter"));
        System.out.println(demo);
        System.out.println(demo.remove("now"));
    }
}
