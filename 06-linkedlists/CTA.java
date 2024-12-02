public class TrainLine {
    
    private String name;
    
    private TrainStation head;
    
    private TrainStation tail;
    
    private int numberOfStations;

    
    public TrainLine(String name, TrainStation head) {
        this.name = name;
        this.head = head;
        this.numberOfStations = 0;
        if (this.head != null) {
            this.numberOfStations = 1; 
            this.tail = head; 
        } else {
            this.tail = null;
        }
    } 
    public TrainLine(String name) {
        this(name, null);
    } 

    
    public void add(String name) {
        TrainStation newStation = new TrainStation(name);
        if (head == null) {
            head = newStation; 
            tail = newStation; 
        } else {
            tail.setNext(newStation); 
            tail = newStation; 
        }
        numberOfStations++;
    } 

    
    public void insert(String name, int position) {
        if (position < 1 || position > numberOfStations + 1) {
            System.out.println("Position out of bounds.");
            return; 
        }

        TrainStation newStation = new TrainStation(name);
        
        if (position == 1) {
            
            newStation.setNext(head);
            head = newStation;
            if (numberOfStations == 0) {
                tail = newStation; 
            }
        } else {
            
            TrainStation cursor = head;
            for (int i = 1; i < position - 1; i++) {
                cursor = cursor.getNext();
            }
            newStation.setNext(cursor.getNext());
            cursor.setNext(newStation);
            if (newStation.getNext() == null) {
                tail = newStation; 
            }
        }
        numberOfStations++;
    }

    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("         1         2         3         4         5         6         7         8\n");
        sb.append("12345678901234567890123456789012345678901234567890123456789012345678901234567890\n");

        TrainStation cursor = head;
        int count = 0;

        
        while (cursor != null) {
            sb.append(cursor.getName());
            cursor = cursor.getNext();
            count++;

            
            if (cursor != null) {
                sb.append(" --> ");
            }
        }

        
        sb.append("--+\n");
        sb.append("                                                                     |\n");
        sb.append("      +-- Addison <-- Sherida <-- Wilson <-- Argyle <-- Bryn Mawr <--+\n");
        sb.append("      |\n");
        sb.append("      +--> Belmont --> Fullerton --> North/Clybourn --> Clark/Division --+\n");
        sb.append("                                                                        |\n");
        sb.append("+-- Roosevelt <-- Harrison <-- Jackson <-- Monroe <-- Clark <-- Chicago +\n");
        sb.append("|\n");
        sb.append("+--> Cermak-Chinatown --> Sox-35th --> 47th --> Garfield --> 63rd --> 69th --+\n");
        sb.append("                                                                             |\n");
        sb.append("                                 null <-- 95th/Dan Ryan <-- 87th <-- 79th <--+\n");

        return sb.toString();
    }

    
    public int getNumberOfStations() {
        return numberOfStations;
    }

    public static void main(String[] args) {
        
        String[] stationNames = { "Howard", "Jarvis", "Morse", "Loyola", "Granville", "Thorndale" };
        
        TrainLine redLineSB = new TrainLine("Red Line SB");
        for (String station : stationNames) {
            redLineSB.add(station);
        }

        
        redLineSB.insert("Addison", 3);
        System.out.println(redLineSB.toString());
    }
}


/**
 * Pseudocode for TrainLine methods:
 * 
 * Method add(name):
 *   Create new TrainStation with given name
 *   If head is null:
 *       Set head and tail to new station
 *   Else:
 *       Set tail's next to new station
 *       Update tail to new station
 *   Increment number of stations
 * 
 * Method insert(name, position):
 *   If position is out of bounds:
 *       Print "Position out of bounds" and return
 *   Create new TrainStation with given name
 *   If position is 1:
 *       Set new station's next to head
 *       Set head to new station
 *       If the line was empty, update tail to new station
 *   Else:
 *       Traverse to the station before the specified position
 *       Set new station's next to the current next
 *       Set current's next to new station
 *       If new station's next is null, update tail
 *   Increment number of stations
 * 
 * Method toString():
 *   Initialize StringBuilder
 *   Append header for station numbers
 *   Append line of dashes
 *   While cursor is not null:
 *       Append cursor's name to StringBuilder
 *       If cursor has a next station:
 *           Append " --> "
 *       Move cursor to next station
 *   Append formatted output for snake-like structure
 *   Return constructed string
 */
