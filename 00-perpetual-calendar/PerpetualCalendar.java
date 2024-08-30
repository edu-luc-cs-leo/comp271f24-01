/**
 * The program divides a month into five printable parts: the black cells in the
 * the first week, the filled date cells in the first week, the rows of full
 * weeks, the filled date cells of the last week, and the empty cells of the
 * last week.
 * 
 * +---------------------------+----------------------------+
 * | blank cells in first week | filled cells in first week |
 * +---------------------------+----------------------------+
 * | . . . . . . . . . . 2-3 full week rows . . . .. . . . .|
 * | . . . . . . . . every cell is filled . . . . . . . . . |
 * +------------------------------+-------------------------+
 * | filled cells in last week. | blank cells in last week. |
 * +------------------------------+-------------------------+
 * 
 * Each part is delegated to a method for printing.
 */
public class PerpetualCalendar {

    // ------------------------------ CONSTANTS ---------------------------------

    private static final int DAY_BORDER_LENGTH = 7;
    private static final int DAY_CELL_WIDTH = 5;
    private static final int DAYS_IN_WEEK = 7;

    private static final String WEEK_HEADER = "  Sun    Mon    Tue    Wed    Thu    Fri    Sat   ";
    private static final String CORNER_SYMBOL = "+";
    private static final String DAY_HORIZONTAL_BORDER = CORNER_SYMBOL + "-".repeat(DAY_BORDER_LENGTH - 1);
    private static final String VERTICAL_BORDER = "|";
    private static final String SPACES = " ".repeat(DAY_BORDER_LENGTH - 1);
    private static final String BAR_BLANK_DAY_FILL = VERTICAL_BORDER + SPACES;
    private static final String BLANK_DAY_FILL_BAR = SPACES + VERTICAL_BORDER;

    /** Driver code */
    public static void main(String[] args) {
        // A month that starts on Tuesday has 2 blanks in first week
        printCalendarMonth(6, 30);
        // A month that starts on Friday has 5 blanks in first week
        printCalendarMonth(3, 31);
        // A month that starts on Sunday has NO blanks in first week
        printCalendarMonth(1, 28);
        // A month that starts on Friday and has 30 days has no blanks in last week
        printCalendarMonth(3, 30);
        // A month that starts on Monday has 1 blank in first week
        printCalendarMonth(7, 31);
    } // method main

    /**
     * Prints the calendar given the firstSunday and numberOfDays in the month.
     * 
     * @param firstSunday  int date of first Sunday in the month
     * @param numberOfDays int number of days in the month
     */
    public static void printCalendarMonth(int firstSunday, int numberOfDays) {
        printHeader();
        printFirstWeekBlankCells(firstSunday);
        printFirstWeekFilledCells(firstSunday);
        printFullWeeks(firstSunday, numberOfDays);
        printLastWeekFilledCells(firstSunday, numberOfDays);
        printLastWeekBlankCells(firstSunday, numberOfDays);
        printFooter();
    } // method printCalendarMonth

    /**
     * Prints the week header and a line of - and +
     */
    public static void printHeader() {
        System.out.println(WEEK_HEADER);
        printFooter();
    } // method printHeader

    /**
     * Prints a line of - and +
     */
    public static void printFooter() {
        System.out.println(DAY_HORIZONTAL_BORDER.repeat(DAY_BORDER_LENGTH) + CORNER_SYMBOL);
    } // method printFooter

    /**
     * Computing the blank cells of the first week is based on a basic observation:
     * 
     * First Sunday falls on day: 1 2 3 4 5 6 7
     * Blank cells in first week: 0 6 5 4 3 2 1
     * 
     * When the first Sunday falls on the first day of the month, we begin printing
     * date cells immediately: there are no blanks.
     * 
     * When the first Sunday is the 2nd of the month, it means that there are 6
     * empty cells in the first week: we skip the first row's Sun, Mon, Tue, Wed,
     * Thu, and Fri, then mark Sat as the 1st of the month, Sunday in the second
     * row as 2nd of the month, etc.
     * 
     * When the first Sunday is the 3nd of the month, it means that there are 5
     * empty cells in the first week: we skip the first row's Sun, Mon, Tue, Wed,
     * and Thu, then mark Friday as the 1st of the month, Saturday as 2nd of the
     * month,
     * Sunday in the second row as 3rd of the month etc. And so on.
     * 
     * What mathematical formula can yield the pattern?
     * 
     * (input) First Sunday: 1 2 3 4 5 6 7
     * (output) Blank cells: 0 6 5 4 3 2 1
     * 
     * If we suspect that it has something to do with the cyclical pattern of the
     * week, i.e., it's some function based on modulo 7, we can write it as a simple
     * equation:
     * 
     * y = f(x) % 7
     * 
     * such that
     * 
     * when x = 1, y = 0;
     * when x = 2, y = 6;
     * when x = 3, y = 5; etc. Therefore:
     * 
     * 0 = f(1) % 7 ==> f(1) = 7 (or 14 or 21 or 28, etc)
     * 6 = f(2) % 7 ==> f(2) = 6 (or 13 or 20 or 27, etc)
     * 5 = f(3) % 7 ==> f(3) = 5 (or 12 or 19 or 26, etc), and so on
     * 
     * We now solve the equations above, finding that f(x) = 8-x, or in terms of
     * variables related to the problem:
     * 
     * f = (1 + number of days in a week) - date of first Sunday
     * 
     * Thus the desired formula will be:
     * 
     * f % (number of days in a week)
     * 
     * @param firstSunday int date of first Sunday in the month
     */
    public static void printFirstWeekBlankCells(int firstSunday) {
        // Implement f % (number of days in a week)
        int blanksAtBeginning = ((1 + DAYS_IN_WEEK) - firstSunday) % DAYS_IN_WEEK;
        // Print 1 or 0 more vertical bars unless first Sundas is on first day of the
        // month. In this case, the first row is a full week and this method
        // prints nothing (blanksAtBeginning=0 and min(1 - 1, 1) = 0).
        System.out.print(BAR_BLANK_DAY_FILL.repeat(blanksAtBeginning)
                + VERTICAL_BORDER.repeat(Math.min(firstSunday - 1, 1)));
    } // method printFirstWeekBlankCells

    /**
     * Prints the first week, taking into account the number of blanks at the
     * beginning of the month
     * 
     * @param firstSunday int date of first Sunday in the month
     */
    public static void printFirstWeekFilledCells(int firstSunday) {
        // Prints squares with dates in them, continuing on the same line as
        // printFirstWeekBlankCells
        for (int day = 1; day <= firstSunday - 1; day++) {
            System.out.print(padded(day, DAY_CELL_WIDTH) + " " + VERTICAL_BORDER);
        }
        /*
         * Only go to a new line if we printed anything in the first loop.
         * If not, our first week stars on Sunday and it will be taken care of by
         * printFullWeeks. The loop decrement j = j - (DAYS_IN_WEEK + 1) guarantees
         * that the loop will run only once, at most.
         */
        for (int j = firstSunday; j > 1; j = j - (DAYS_IN_WEEK + 1)) {
            System.out.println();
        }
    } // method printFirstWeekFilledCells

    /**
     * Prints fully filled weeks
     * 
     * @param firstSunday  int date of first Sunday in the month
     * @param numberOfDays int number of days in the month
     */
    public static void printFullWeeks(int firstSunday, int numberOfDays) {
        /*
         * Tells us the number of remaining weeks in the month -- we have already
         * covered the first week with methods printFirstWeekBlankCells and
         * printFirstWeekFilledCells. All but one of the remaining weeks will be full
         * rows, i.e., every date cell will be filled. The last of the remaining rows
         * may be a partial week.
         */
        int numberOfRows = (int) Math.ceil((numberOfDays - firstSunday + 1) / (double) DAYS_IN_WEEK);
        for (int week = 0; week < numberOfRows - 1; week++) {
            // Adds 7 to firstSunday to give us the first day of each week in the loop
            int firstDayOfWeekDate = firstSunday + (week * DAYS_IN_WEEK);
            /*
             * The last day of the week is whichever is smaller, the total numberOfDays in
             * the month or the Saturday of that week. This takes care of what happens if
             * the month ends in the middle of a week.
             */
            int lastDayOfWeekDate = Math.min(
                    (firstSunday + (week * DAYS_IN_WEEK) + (DAYS_IN_WEEK - 1)),
                    numberOfDays);
            // left edge formatting
            System.out.print(VERTICAL_BORDER);
            // Print the days in padded formatting
            for (int date = firstDayOfWeekDate; date <= lastDayOfWeekDate; date++) {
                System.out.print(padded(date, DAY_CELL_WIDTH) + " " + VERTICAL_BORDER);
            }
            System.out.println();
        }
    } // method printFullWeeks

    /**
     * Prints the final week of the calendar
     * 
     * @param firstSunday  int date of first Sunday in the month
     * @param numberOfDays int number of days in the month
     */
    public static void printLastWeekFilledCells(int firstSunday, int numberOfDays) {
        int numberOfRows = (int) Math.ceil((numberOfDays - firstSunday + 1) / (double) DAYS_IN_WEEK);
        System.out.print(VERTICAL_BORDER); // left edge formatting
        for (int day = firstSunday + ((numberOfRows - 1) * DAYS_IN_WEEK); day <= numberOfDays; day++) {
            System.out.print(padded(day, DAY_CELL_WIDTH) + " " + VERTICAL_BORDER);
        }
    } // method printLastWeekFilledCells

    /**
     * Prints the blank days at the end of the calendar.
     * 
     * @param firstSunday  int date of first Sunday in the month
     * @param numberOfDays int number of days in the month
     */
    public static void printLastWeekBlankCells(int firstSunday, int numberOfDays) {
        int blanksAtBeginning = (((DAYS_IN_WEEK + 1) - firstSunday) % DAYS_IN_WEEK);
        /*
         * This is just like our other int numberOfRows used earlier, except for the
         * Math.min statement at the end which adds an additional row iff we have any
         * blanks at the beginning. We need it to do this otherwise it will print one
         * extra row at the bottom if the firstSunday is 1.
         */
        int numberOfRows2 = (int) Math.ceil((numberOfDays - firstSunday + 1) / (double) DAYS_IN_WEEK)
                + Math.min(blanksAtBeginning, 1);
        /*
         * The repeat statement comes from the fact that the total number of squares in
         * the calendar (numberOfRows2 * 7)
         * minus the total numberOfDays and blanksAtBeginning will tell us how many
         * leftover squares we have at the end
         * that need to be printed blank.
         */
        System.out.println(
                BLANK_DAY_FILL_BAR.repeat((numberOfRows2 * DAYS_IN_WEEK)
                        - (numberOfDays + blanksAtBeginning)));
    } // method printLastWeekBlankCells

    /** Method provided by the assignment to surround a number with padding */
    public static String padded(int n, int width) {
        String s = String.valueOf(n);
        for (int i = s.length(); i < width; i++) {
            s = " " + s;
        }
        return s;
    } // method padded

} // class PerpetualCalendar
