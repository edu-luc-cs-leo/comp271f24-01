public class TrainLine {

    /**
     * The name of the trainline
     */
    private String name;
    /**
     * Points to the first station in the trainline
     */
    private TrainStation head;
    /**
     * Points to the last station in the trainline
     */
    private TrainStation tail;
    /**
     * Keeps a running tally of train stations in the trainline
     */
    private int numberOfStations;


    /**
     * Full constructor
     */
    public TrainLine(String name, TrainStation head) {
        this.name = name;
        this.head = head;
        this.numberOfStations = 0;
        if (this.head != null) {
            // If head is not null, there is one station in the line
            this.numberOfStations = 1;
        }
        // At initialization head and tail point to the same station even if null
        this.tail = null;
    } // full constructor

    /**
     * Basic constructor
     */
    public TrainLine(String name) {
        this(name, null);
    } // basic constructor

    /**
     * Creates a new station with the given name and adds it to the end of the line.
     */
    public void add(String name) {
        // Create the new station to add
        TrainStation newStation = new TrainStation(name);
        // Determine where to place the new station
        if (this.head == null) {
            // Trainline is empty, make new station the head of the line
            this.head = newStation;
        } else {
            // When there is a head station already, add the new station after the last
            // station in the line.
            this.tail.setNext(newStation);
        }
        // The new station becomes the tail station of the line
        this.tail = newStation;
        // Update station count
        this.numberOfStations++;
    } // method add

    /**
     * Returns the number of stations in the line >= 0
     */
    public int getNumberOfStations() {
        return numberOfStations;
    } // method getNumberOfStations

    public TrainStation remove(int position) {
        TrainStation removedStation = null;
        if (position >= 1 && position <= this.numberOfStations) {
            // Commence safe operations
            if (position == 1) {
                // Remove head
                removedStation = this.head;
                this.head = this.head.getNext();
            } else {
                // Find the station prior to the one to be removed
                TrainStation cursor = this.head;
                for (int i = 1; i < position - 1; i++) {
                    cursor = cursor.getNext();
                }
                // cursor should be at the prior station
                if (cursor.getNext() == this.tail) {
                    this.tail = cursor;
                }
                removedStation = cursor.getNext();
                cursor.setNext(cursor.getNext().getNext());
            }
            this.numberOfStations--;
            removedStation.setNext(null);
        }
        return removedStation;
    }

    /**
     *
     * Inserts a nwe station with the given name at the specified position in the train line.
     * Position must be between 1 and the number of stations plus one.
     *
     * The method works as follows:
     * - Validate the position to ensure it is within the valid range
     * - If inserting at the head, set new station's next pointer to the current head
     *   and update the head to the new station
     * - If inserting at any other position, traverse the list to find the station before the
     *   insertion point
     * - Set the new station's next pointer to the next station of the current station and update
     *   current station's next pointer to the new station
     * - If inserting at the end, update the tail to the new station
     * - Finally, increment num stations in TrainLine
     *
     * @param name: The name of the station to be inserted
     * @param position: Position at which to insert new station
     * @throws IllegalArgumentException if the position is out of the valid range
     */
    public void insert(String name, int position) throws IllegalArgumentException {
        TrainStation newStation = new TrainStation(name);

        // Validate position
        if (position < 1 || position > this.numberOfStations + 1) {
            throw new IllegalArgumentException("Position must be between 1 and " + (this.numberOfStations + 1));
        }

        // Inserting at the head
        if (position == 1) {
            newStation.setNext(this.head);
            this.head = newStation;
            if (this.tail == null) { // If the list was empty, update tail as well
                this.tail = newStation;
            }
        } else {
            TrainStation current = this.head;
            for (int i = 1; i < position - 1; i++) {
                if (current != null) { // Ensure current is not null to avoid NullPointerException
                    current = current.getNext();
                }
            }

            // Insert the new station
            newStation.setNext(current.getNext());
            current.setNext(newStation);

            // Update tail if inserting at the end
            if (newStation.getNext() == null) {
                this.tail = newStation;
            }
        }

        // Update the number of stations
        this.numberOfStations++;
    }


    /**
     * Formatting Strings for method toString()
     */
    public static final String rArrow = " --> ";
    public static final String lArrow = " <-- ";
    public static final String rPlus = " --+";
    public static final String lPlus = "+-- ";
    public static final String rPArrow = "+--> ";
    public static final String lPArrow = " <--+";
    public static final String bar = "|";
    public static final int LINELENGTH = 80;
    public static String padding = " ";
    public static final String error = " has no stations!";
    public static final String end = "null";

    /**
     * Returns a string representation of the trainline. The string follows a snaking pattern,
     * where each line can be at most 80 characters. The direction alternates depending on the
     * line number. The padding of lines does not work. I could not for the life of me figure it out. However,
     * the snaking pattern is correct, with correctly oriented arrows and reversed orders for right to left lines.
     *
     * The method works as follows:
     * - It starts with the first station and appends its name to the StringBuilder
     * - It then moves to the next station and checks if it can be added to the current line
     * - If it can be added, it appends the station name with an arrow and updates the line length
     * - If it cannot be added, it ends the current line with a plus sign and moves to the next line
     *
     * The method also handles the left to right (visually right to left) lines. It collects the stations
     * in reverse order and appends them to the StringBuilder. It then appends the line transition and moves
     * to the next line.
     *
     *
     * I am going to keep working on this because I really do not know what I am missing here, but as it stands
     * it is almost there.
     * @return String: A string representation of the trainline
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.head != null) {
            TrainStation cursor = this.head;
            boolean leftToRight = true;
            int lineLength = 0;
            int currentStation = 1;
            int lineCount = 1;

            // Start with the first station
            sb.append(cursor.getName());
            cursor = cursor.getNext();
            currentStation++;
            lineLength += sb.length();

            while (cursor != null) {
                String nextStationName = cursor.getName();
                // Check if we can add the next station to the current line
                if (leftToRight) {
                    if (lineLength + rArrow.length() + nextStationName.length() < LINELENGTH) {
                        if (lineLength == 0) {
                            sb.append(rPArrow);
                        } else {
                            sb.append(rArrow);
                        }

                        sb.append(nextStationName);
                        lineLength += rArrow.length() + nextStationName.length();
                        cursor = cursor.getNext();
                        currentStation++;
                    } else {
                        // End the current line
                        sb.append(rPlus).append("\n").append(bar).append("\n");
                        lineLength = 0; // Reset line length

                        leftToRight = !leftToRight; // Toggle the direction (left to right and vice versa)
                    }
                } else {
                    // Left to right (visually right to left) logic
                    StringBuilder tempLine = new StringBuilder();  // Temporary line to hold the stations in reverse order
                    boolean firstStation = true;                  // To check if it's the first station in the line

                    // Collect the stations and prepend them, maintaining arrow and transition formatting
                    while (cursor != null && lineLength + lArrow.length() + cursor.getName().length() < LINELENGTH) {
                        if (firstStation) {
                            // For the first station, start with the lPlus transition
                            tempLine.append(cursor.getName());  // Collect the first station, add arrows later
                            firstStation = false;
                        } else {
                            // For subsequent stations, prepend the station with lArrow at the start
                            tempLine.insert(0, cursor.getName() + lArrow);  // Prepend station with lArrow
                        }

                        // Update the line length and move to the next station
                        lineLength += lArrow.length() + cursor.getName().length();
                        cursor = cursor.getNext();
                        currentStation++;
                    }

                    // After collecting the stations, prepend the lPlus and append the final transition
                    tempLine.insert(0, lPlus);  // Prepend lPlus at the very start
                    tempLine.append(lPArrow);   // Append the final <--+

                    // Append the constructed line to the main StringBuilder
                    sb.append(tempLine);

                    // If the line is full or we switch direction, handle the transition
                    if (cursor != null) {
                        sb.append("\n").append(bar).append("\n");
                        lineLength = 0;
                        leftToRight = !leftToRight;  // Toggle the direction (left to right and vice versa)
                    }
                }
            }

            // Handle the last line and its ending
            sb.append(rPlus).append("\n"); // Finish the last line
        } else {
            sb.append(this.name).append(error);
        }

        return sb.toString();
    } // method toString




    public static void main(String[] args) {
        // A few station names
        String[] stationNames = CTA.RED_LINE_SB_NAMES;
        // A populated trainline
        TrainLine redLineSB = new TrainLine("Red Line SB");
        for (String station : stationNames) {
            redLineSB.add(station);
        }
        // An empty trainline
        TrainLine brownLineSB = new TrainLine("Brown Line SB");

        // A random station name
        String randomName = "Oak Park";
        redLineSB.insert("Hello", 2);
        System.out.println(redLineSB);
    } // method main
} // class TrainLine