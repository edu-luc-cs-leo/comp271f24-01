import java.util.Arrays;
import java.util.Random;

public class Person implements Comparable<Person>, SillyActions {

    private static final String DEFAULT_LAST_NAME = "LNU";
    private static final String DEFAULT_FIRST_NAME = "FNU";
    private static final int DEFAULT_YEAR_BORN = 1800;
    private final String[] sounds = {"Bark", "Meow", "Moo", "Toot", "Burp"};
    private final String[] moves = {"Left", "Right", "Forward", "Backward"};

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


    /**
     * Selects a random sound word from sounds array and prints it.
     */
    @Override
    public void makeRandomSound() {
        System.out.println(sounds[(int) (Math.random() * 5)]);

    } // Method makeRandomSound

    @Override
    public void performSillyDance() {
        String[] sequence = new String[5];
        sequence[0] = sounds[(int) (Math.random() * 5)];
        sequence[1] = moves[(int) (Math.random() * 5)];
        sequence[2] = moves[(int) (Math.random() * 5)];
        sequence[3] = moves[(int) (Math.random() * 5)];
        sequence[4] = moves[(int) (Math.random() * 5)];
        System.out.println(Arrays.toString(sequence));

    } // Method performSillyDance

    /**
     * Prints the alphabet backwards.
     * @return String Alphabet Backwards
     */
    @Override
    public String reciteAlphabetBackwards() {
        return "Z, Y, X, W, V, U, T, S, R ,Q, P, O, N, M, L, K, J, I, H, G, F, E, D, C, A ";

    } // Method reciteAlphabetBackwards

    /**
     * Prints the numbers 1 through ten in an odd manner (skipping one number).
     */
    @Override
    public void countToTenWeirdly() {
        System.out.println("One, too, tree, 4, fyve, 6, seiben, ate, nine, t3n");

    } // Method countToTenWeirdly

    /**
     * Selects several random words from PoemWords.words and prints them along with @param topic
     * @param topic String: User defined topic
     * @return String: Whimsical Poem
     */
    @Override
    public String createWhimsicalPoem(String topic) {
        return topic + " " + PoemWords.words[(int) (Math.random() * 50)] + " for " + PoemWords.words[(int) (Math.random() * 50)] + " " + PoemWords.words[(int) (Math.random() * 50)] + " " + PoemWords.words[(int) (Math.random() * 50)] + (" and to ") + PoemWords.words[(int) (Math.random() * 50)] + " " + PoemWords.words[(int) (Math.random() * 50)] + ".";

    } // Method createWhimsicalPoem

    /**
     * Uses Java.util.random to select 6 random numbers between 1 and 50, as per Illinois Lottery regulations.
     */
    @Override
    public void winStateLottery() {
        Random rand = new Random();
        System.out.println(rand.nextInt(50) + " " + rand.nextInt(50) + " " + rand.nextInt(50) + " " + rand.nextInt(50) + " " + rand.nextInt(50) + " " + rand.nextInt(50));
    } // Method winStateLottery

    // Test method
//    public static void main(String[] args) {
//        Person person = new Person(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);
//        person.winStateLottery();
//        System.out.println(person.createWhimsicalPoem("Hello"));
//        person.countToTenWeirdly();
//        person.reciteAlphabetBackwards();
//    }
}
