/*
Implements a simple method to fully-justify text.
*/

public class JustifyText {

    /**
     * Take a string of arbitrary length and returns a multiline string that is
     * fully justify to the line width specified in the parameters.
     * 
     * @param text      string to convert to multiline string fully justified
     * @param lineWidth width of justified lines
     * @return a multiline string with each line at exactly the specified width
     */
    public static String justifyText(String text, int lineWidth) {

        // Constants, just for readability
        final char SPACE = (char) 32;
        final char NEWLINE = (char) 10;

        // Guard statements. Because the actual code after them is a bit challenging,
        // it's ok to suspend the ban on multiple returns and make things a bit more
        // readable.
        if (text == null || lineWidth == 0)
            return null;

        if (text.length() < lineWidth)
            return text;

        /*
         * We use StringBuilder to assemble the final product from partial lines. Each
         * partial line is populated with content from the input string until we reach
         * the width limit. At that point we add the necessary number of inter-words
         * spaces in the partial line to bring its width to exactly the specified width.
         * Then we add the partial line to the final product, reset the local variables,
         * and continue.
         */
        StringBuilder finalProduct = new StringBuilder();
        StringBuilder currentLine = new StringBuilder();
        /*
         * Parse the input string into an array of strings; in principle we don't need
         * the array. Parsing the words straight out of the string will complicate the
         * code a bit more and distract us from the core mission to produce a multiline
         * output of exact width.
         */
        String[] words = text.split(" ");
        // Width of current line
        int currentWidth = 0;
        // Principal loop to process every word in the input string
        for (String word : words) {
            // Check if adding this word violates our width requirement
            if (currentWidth + word.length() > lineWidth) {
                /*
                 * Adding this word violates our width requirement. Therefore, the current line
                 * is as wide as it can get without running over the specified width. We now
                 * need to make sure that the current line's width is exactly the specified one.
                 * We pad the line with spaces until it reaches the desired width. StringBuilder
                 * allows us to insert characters in specific positions in the object; these
                 * positions are found with indexOf looking for the next space in the current
                 * line.
                 */
                int spaceIndex = 0;
                while (currentLine.length() <= lineWidth) {
                    // StringBuilder.indexOf requires a string so ... valueOf(char)
                    spaceIndex = currentLine.indexOf((String.valueOf(SPACE)), spaceIndex);
                    currentLine.insert(spaceIndex, SPACE);
                    spaceIndex += 2; // MAGIC VALUE -- fix later
                }
                // The current line is now fully justified. Add it to the output, add a newline,
                // reset the local variables and continue
                finalProduct.append(currentLine);
                finalProduct.append(NEWLINE);
                currentLine = new StringBuilder();
                currentWidth = 0;
            }
            // Add the current word to the current line and update the current lines length.
            // We are adding +1 for the space following the newly added word.
            currentLine.append(word + SPACE);
            currentWidth += (1 + word.length());
        }
        // Done!
        return finalProduct.toString();
    } // method justifyText

    public static void main(String[] args) {
        // Opening line from Richard III by Richard Shakespeare
        String test = "Now is the winter of our discontent made glorious " +
                "by this son of York and all the clouds that lourd " +
                "over our house now in the deep bosom of the ocean lay";
        System.out.println(justifyText(test, 20));

        // Last sentence from Cien Años de Soledad by Gabriel García Márquez
        test = "Sin embargo, antes de llegar al verso final ya había comprendido " +
                "que no saldría jamás de ese cuarto,pues estaba previsto que la " +
                "ciudad de los espejos (o los espejismos) sería arrasada por el " +
                "viento y desterrada de la memoria de los hombres en el instante " +
                "en que Aureliano Babilonia acabara de descifrar los pergaminos, " +
                "y que todo lo escrito en ellos era irrepetible desde siempre y " +
                "para siempre porque las estirpes condenadas a cien años de soledad " +
                "no tenían una segunda oportunidad sobre la tierra";
        System.out.println(justifyText(test, 50));
    }
}
