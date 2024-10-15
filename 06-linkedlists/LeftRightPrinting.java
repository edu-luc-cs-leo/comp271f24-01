public class LeftRightPrinting {
        public static void main(String[] args) {
            String[] names = CTA.RED_LINE_SB_NAMES;
            final String LINE = "--";
            final String LEFT = "<";
            final String RIGHT = ">";
            final String TURN = "+";
            final String VBAR = "|";
            final String SPACE = " ";
            final String NEWLINE = "\n";
            final int COL_LIMIT = 80;
            int effectiveColLimit = COL_LIMIT - (SPACE + LINE + RIGHT + SPACE).length();
            String shortSnake = names[0] + SPACE + LINE + RIGHT + SPACE;
            String longSnake = "";
            int lineCounter = 0;
            for (int i = 1; i < names.length - 1; i++) {
                int testLength = shortSnake.length() + SPACE.length() + names[i].length() + LINE.length() + 1;
                if (testLength >= effectiveColLimit) {
                    // Adjust formatting when the current line reaches the column limit
                    String padding = SPACE.repeat(COL_LIMIT - shortSnake.length());
                    shortSnake = padding + shortSnake.substring(0, shortSnake.length() - 1) + TURN;
                    String verticalRoute = (lineCounter % 2 == 0) 
                        ? SPACE.repeat(COL_LIMIT - 1) + VBAR 
                        : VBAR + SPACE.repeat(COL_LIMIT - 1);
                    longSnake += shortSnake + NEWLINE + verticalRoute + NEWLINE;
                    // Switch direction for the next line
                    shortSnake = (lineCounter % 2 == 0) 
                        ? SPACE + LEFT + LINE + TURN 
                        : TURN + LINE + RIGHT + SPACE;
                    lineCounter++;
                }
                // Build the zig-zag direction based on lineCounter
                if (lineCounter % 2 == 0) {
                    shortSnake += SPACE + names[i] + SPACE + LINE + RIGHT;
                } else {
                    shortSnake = SPACE + LEFT + LINE + SPACE + names[i] + shortSnake;
                }
            }
            System.out.println();
            System.out.println(longSnake);
        } // method main     
}