/**
 * A simple class to simulate a train station. The object has only two fields:
 * the name of the station and a pointer to the next station object.
 */
public class TrainStation {

    /** Name of the station */
    private String name;
    /** Pointer to the next station object */
    private TrainStation next;

    /**
     * Basic constructor. All stations are created without a station to point to;
     * i.e, their next field is set to null. This allows us to create stations
     * first, link them later. Otherwise we'll run into a chicken-egg problem
     * 
     * @param name String with name of station to create
     */
    public TrainStation(String name) {
        this.name = name;
        this.next = null;
    } // basic constructor

    /** 
     * Setter for a station's next station.
     */
    public void setNext(TrainStation next) {
        this.next = next;
    } // method setNext

    public String getName() {
        return this.name;
    }

    /** Predicate accessor */
    public boolean hasNext() {
        return this.next != null;
    }

    /** Plain accessor (getter) for next*/
    public TrainStation getNext() {
        return this.next;
    }

} // class TrainStation
