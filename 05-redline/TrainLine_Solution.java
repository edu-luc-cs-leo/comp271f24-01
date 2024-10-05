public class TrainLine_Solution {

    private TrainStation head;
    private TrainStation tail;
    private String name;
    private int numberOfStations;

    /** Full constructor */
    public TrainLine_Solution(String name, TrainStation head) {
        this.head = head;
        this.tail = head;
        this.name = name;
        this.numberOfStations = (head == null) ? 0 : 1;
    } // full constructor

    /** Basic constructor */
    public TrainLine_Solution(String name) {
        this(name, null);
    } // basic constructor

    /** Adds a station to the end of the line */
    public void add(String name) {
        // Create new station with given name
        TrainStation newStation = new TrainStation(name);
        if (this.head == null) {
            // Line is empty; make new station the head station
            this.head = newStation;
        } else {
            // Line is not empty; add new station after last station
            this.tail.setNext(newStation);
        }
        // Update last station to newly added station
        this.tail = newStation;
        // Update count of stations
        this.numberOfStations++;
    } // method add

    /**
     * Returns the position of a station with specified name. First station is 0. If
     * station is not found method returns -1
     */
    public int indexOf(String name) {
        int index = -1;
        if (name != null) {
            int i = 0;
            TrainStation cursor = this.head;
            while (cursor != null && index < 0) {
                if (name.equals(cursor.getName())) {
                    index = i;
                }
                i++;
                cursor = cursor.getNext();
            }
        }
        return index;
    } // method indexOf

    /**
     * Returns true if station with given name exists in the train line, false
     * otherwise. Method is based on indexOf.
     */
    public boolean contains(String name) {
        return this.indexOf(name) > -1;
    } // method contains

    /** Returns a string with all the stations in reverse order */
    public String reverseList() {
        String list = "";
        TrainStation cursor = this.head;
        while (cursor != null) {
            list = cursor.getName() + "\n" + list;
            cursor = cursor.getNext();
        }
        return list;
    } // method reverseList

    public static void main(String[] args) {
        // A few station names
        String[] stationNames = { "Howard", "Jarvis", "Morse",
                "Loyola", "Granville", "Thorndale" };
        // A populated trainline
        TrainLine_Solution redLineSB = new TrainLine_Solution("Red Line SB");
        for (String station : stationNames) {
            redLineSB.add(station);
        }
        // An empty trainline
        TrainLine_Solution brownLineSB = new TrainLine_Solution("Brown Line SB");
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
        System.out.printf(formatIndexOfTestExisting, reportIndexOfTestEmpty);
        System.out.printf(formatIndexOfTestNonExisting, reportIndexOfTestNonExisting);
        System.out.printf(formatIndexOfTestEmpty, reportIndexOfTestEmpty);
        System.out.printf(formatContainsTestExisting, reportContaisTestExisting);
        System.out.printf(formatContainsTestNonExisting, reportContainsTestNonExisting);
        System.out.printf(formatReverseListTest, reportReverseListTest);

    }
}
