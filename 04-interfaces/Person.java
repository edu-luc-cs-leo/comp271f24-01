public class Person implements Comparable<Person>, SillyActions {

    private static final String DEFAULT_LAST_NAME = "LNU";
    private static final String DEFAULT_FIRST_NAME = "FNU";
    private static final int DEFAULT_YEAR_BORN = 1800;

    private String firstName;
    private String lastName;
    private int yearBorn;

    public Person(String firstName, String lastName, int yearBorn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBorn = yearBorn;
    }

    public Person(String firstName) {
        this(firstName, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);
    }

    /** Default constructor */
    public Person() {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);
    }

    /**
     * Implements the Comparable interface to determine the relative order of two
     * persons based on their age.
     * 
     */
    public int compareTo(Person other) {
        return other.getYearBorn() - this.yearBorn;
    } // method compareTo

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", yearBorn=" + yearBorn + "]";
    } // method toString

    //------------------- AUTO GENERATED METHODS ------------------------------
    
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getYearBorn() {
        return this.yearBorn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }

}
