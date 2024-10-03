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

    /**
     * Checks if given String is present in the TrainStation object by traversing the list
     * and performing a check for each station. Safe operation space is created in
     * the while loop evaluating this.isEmpty to check if TrainLine is empty.
     * If the name is either null or does not exist in the TrainLine, False is returned.
     *
     * @param name String: name to search for
     * @return found: boolean. True if station found, False if not.
     */
    public boolean contains(String name) {
        boolean found = false;

        int i = 0;
        TrainStation cursor = this.head;
        while (i < this.getNumberOfStations() && !found && !this.isEmpty()) {
            if (cursor.getName().equals(name)) {
                found = true;
            }
            cursor = cursor.getNext();
            i++;

        }
        return found;
    } // methodContains

    /**
     * Given a name to search for, returns the index of that station by traversing
     * the TrainLine and checking if the cursor (initialized to this.head to start
     * at the first station) equals the desired name.
     * Safe operation space is created in
     * the while loop by Safe operation space is created in
     * the while loop evaluating this.isEmpty to check if TrainLine is empty.
     * Index is initialized to -1, so if the name is null or not present, -1 is returned.
     *
     * @param name String: name of station to search for
     * @return int: the index of the station
     */
    public int indexOf(String name) {
        int index = -1;

        int i = 0;
        TrainStation cursor = this.head;
        while (i < this.getNumberOfStations() && !this.isEmpty()) {
            if (cursor.getName().equals(name)) {
                index = i;
            }
            cursor = cursor.getNext();
            i++;

        }
        return index;
    } // method indexOf

    /**
     * Reverses the TrainLine and returns a String representing the names
     * of each station in reverse order. This is achieved by creating a
     * temporary list (reverseHead) that stores the stations in their
     * reverse order. We traverse the original linked list, creating
     * a new TrainStation object for each station. My original implementation
     * (commented out) used two for loops, iterating through the list
     * front to back and back to front.
     * Safe operation space is created by evaluating if !this.isEmpty().
     * If it is not, the rest of the code executes. If it is null, "" is returned
     * to signify that the TrainLine is empty.
     *
     * @return String: reversed list
     */
    public String reverseList() {
        // Original implementation using 2 for loops (bad)
//        String list = ""; // If trainLine has no stations, return empty String
//        if (this.head != null) {
//            // Iterate trainLine backwards
//            for (int i = this.getNumberOfStations() - 1; i >= 0; i--) {
//                TrainStation cur = this.head;
//                // Traverse to the ith station
//                for (int j = 0; j < i; j++) {
//                    cur = cur.getNext(); // Move to the next station
//                }
//                list += (cur.getName() + "\n"); // Add station to String
//            }
//        }
//
//        return list;
        // New implementation using 2 using 2 while loops (slightly better)
        String list = "";
        if (!this.isEmpty()) {
            TrainStation cursor = this.head;

            TrainStation reverseHead = null;

            while (cursor != null) {
                TrainStation newStation = new TrainStation(cursor.getName());
                newStation.setNext(reverseHead);
                reverseHead = newStation;
                cursor = cursor.getNext();
            }

            TrainStation reverseCursor = reverseHead;

            while (reverseCursor != null) {
                list += reverseCursor.getName() + "\n";
                reverseCursor = reverseCursor.getNext();

            }
        }

        return list;
    } // method reverseList

    /**
     * @return boolean: True if TrainStation is empty, False if it is not.
     */
    public boolean isEmpty() {
        return this.head == null;
    } // method isEmpty

    /*******************************************************************************
     * DO NOT REMOVE TESTS FROM THE CODE BELOW. YOU MAY **ADD** YOUR OWN TESTS BUT *
     * YOU MAY NOT REMOVE ANY OF THE EXISTING TEST CODE. *
     ******************************************************************************/
    public static void main(String[] args) {
        // A few station names
        String[] stationNames = {"Howard", "Jarvis", "Morse", "Loyola", "Granville", "Thorndale"};
        // A populated trainline
        TrainLine redLineSB = new TrainLine("Red Line SB");
        for (String station : stationNames) {
            redLineSB.add(station);
        }
        // An empty trainline
        TrainLine brownLineSB = new TrainLine("Brown Line SB");
        // A random station name
        String randomName = "Oak Park";
        // Guard tests
        redLineSB.indexOf(null);
        redLineSB.contains(null);
        // Test indexOf on existing values
        boolean indexOfTestExisting = true;
        for (int i = 0; i < stationNames.length; i++) {
            indexOfTestExisting = (indexOfTestExisting && (redLineSB.indexOf(stationNames[i]) == i));
        }
        // Test indexOf for non existing station
        boolean indexOfTestNotExisting = (redLineSB.indexOf(randomName) == -1);
        // Test indexOf on empty line
        boolean indexOfTestingEmpty = (brownLineSB.indexOf(stationNames[0]) == -1);
        // Test contains for existing stations
        boolean containsTestExisting = true;
        for (String station : stationNames) {
            containsTestExisting = (containsTestExisting && redLineSB.contains(station));
        }
        // Test contains for non existing values
        boolean containsTestNonExisting = (!redLineSB.contains(randomName));
        // Test reverse list
        String expectedReverseList = "";
        for (int i = stationNames.length - 1; i >= 0; i--) {
            expectedReverseList = expectedReverseList + stationNames[i] + "\n";
        }
        boolean reverseListTest = redLineSB.reverseList().equals(expectedReverseList);
        // Reporting strings
        final String PASS = "Pass";
        final String FAIL = "Fail";
        String reportIndexOfTestExisting = (indexOfTestExisting) ? PASS : FAIL;
        String formatIndexOfTestExisting = "\n\nindexOf test for existing values: ......... %s";
        String reportIndexOfTestNonExisting = (indexOfTestNotExisting) ? PASS : FAIL;
        String formatIndexOfTestNonExisting = "\nindexOf test for non existing values: ..... %s";
        String reportIndexOfTestEmpty = (indexOfTestingEmpty) ? PASS : FAIL;
        String formatIndexOfTestEmpty = "\nindexOf test for empty object: ............ %s";
        String reportContaisTestExisting = (containsTestExisting) ? PASS : FAIL;
        String formatContainsTestExisting = "\ncontains test for existing values: ........ %s";
        String reportContainsTestNonExisting = (containsTestNonExisting) ? PASS : FAIL;
        String formatContainsTestNonExisting = "\ncontains test for non existing values: .... %s";
        String reportReverseListTest = (reverseListTest) ? PASS : FAIL;
        String formatReverseListTest = "\nreverseList test: ......................... %s\n\n";
        System.out.printf(formatIndexOfTestExisting, reportIndexOfTestExisting);
        System.out.printf(formatIndexOfTestEmpty, reportIndexOfTestEmpty);
        System.out.printf(formatIndexOfTestNonExisting, reportIndexOfTestNonExisting);
        System.out.printf(formatContainsTestExisting, reportContaisTestExisting);
        System.out.printf(formatContainsTestNonExisting, reportContainsTestNonExisting);
        System.out.printf(formatReverseListTest, reportReverseListTest);
        // ----------- YOU MAY ADD YOUR OWN TESTS BELOW THIS COMMENT LINE ---------------
        String[] names = {"one", "two", "three", "four"};
        TrainLine nathansTrain = new TrainLine("Nathans Train");
        for (String s : names) {
            nathansTrain.add(s);
        }
        System.out.println(nathansTrain.reverseList());
        System.out.println(redLineSB.reverseList());
        TrainStation cursor = nathansTrain.head;
        for (int i = 0; i < nathansTrain.numberOfStations; i++) {
            System.out.println(cursor.getName());
            cursor = cursor.getNext();
        }
    } // method main
} // class TrainLine
