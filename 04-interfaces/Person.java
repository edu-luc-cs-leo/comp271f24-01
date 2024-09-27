import java.util.Random;

public class Person implements Comparable<Person>, SillyActions {

    /** Default object values */
    private static final String DEFAULT_LAST_NAME = "LNU";
    private static final String DEFAULT_FIRST_NAME = "FNU";
    private static final int DEFAULT_YEAR_BORN = 1800;

    /** Object fields: name of person and year in which they were born */
    private String firstName;
    private String lastName;
    private int yearBorn;

    /** Full constructor */
    public Person(String firstName, String lastName, int yearBorn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBorn = yearBorn;
    } // full constructor

    /** Basic constructor, first name only */
    public Person(String firstName) {
        this(firstName, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);
    } // basic constructor

    /** Default constructor */
    public Person() {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);
    } // default constructor

    /**
     * Implements the Comparable interface to determine the relative order of two
     * persons based on their age.
     * 
     */
    public int compareTo(Person other) {
        return other.getYearBorn() - this.yearBorn;
    } // method compareTo

    /**
     * Textual representation of the object
     */
    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", yearBorn=" + yearBorn + "]";
    } // method toString

    // ------------------- IMPLEMENTATION OF INTERFACE: SILLYACTIONS -----------

    /*
     * Constants used for SillyActions -- eventually we'll move them to the top of
     * the class, for for clarity we'll keep them close to the methods of the
     * interface for now.
     */

    /** Random sounds */
    private static final String[] RANDOM_SOUNDS = { "beep", "boop", "buzz", "whirr",
            "clang", "ding", "honk", "chirp", "zap", "pop" };
    private static final String RANDOM_SOUND_PREAMBLE = "Random sound:";

    /** Random generator */
    private static final Random RAND = new Random();

    /** Dance directions, steps, and preamble */
    private static final String[] DANCE_DIRECTION = { "left", "right", "forward", "backwards" };
    private static final int MINIMUM_DANCE_STEPS = 5;
    private static final int MAXIMUM_DANCE_STEPS = 30;
    private static final int BREAK_LINE_AFTER = 5;
    private static final String DANCE_PREAMBLE = "Dancing";

    /** Alphabet constants */
    private static final int FIRST_LETTER = (int) 'a';
    private static final int NUMBER_OF_LETTERS = 26;

    /** Unusual counting */
    private static final int UPTO = 10;

    /** Poetry */
    private static final int SMALLEST_POEM = 10;
    private static final int LARGEST_POEM = 100;
    private static final String POEM_TITLE = "An ode to";

    /**
     * Lottery; Players choose 6 numbers from a range of 1 to 50 in Illinois LOTTO
     */
    private static final int LOTTERY_NUMBERS = 6;
    private static final int MAX_LOTTERY_VALUE = 50;
    private static final String LOTTERY_MESSAGE = "Your winning numbers:";

    /**
     * Make a random sound. Actually, produce a random word and print it (no need to
     * find how to make an actual sound). The method selects, at random, a
     * sound-like word from an array and prints it.
     */
    public void makeRandomSound() {
        System.out.printf("\n%s: %s\n",
                RANDOM_SOUND_PREAMBLE,
                RANDOM_SOUNDS[RAND.nextInt(RANDOM_SOUNDS.length)]);
    } // method makeRandomSound

    /**
     * Perform a silly dance by describing it as a sequence of a few steps left,
     * right, backwards, and forward. The method first determines the number of
     * steps in the dance; an upper and lower limit is set via constants. Then the
     * method prints a preamble to the dance (e.g., "Dancing"), following by random
     * steps in the specified directions. Every so many steps, the method prints a
     * new line to avoid long lines.
     */
    public void performSillyDance() {
        int numberOfSteps = MINIMUM_DANCE_STEPS + RAND.nextInt(MAXIMUM_DANCE_STEPS - MINIMUM_DANCE_STEPS);
        System.out.printf("\n%s: ", DANCE_PREAMBLE);
        int stepCounter = 0;
        for (int step = 0; step < numberOfSteps; step++) {
            System.out.printf("%s ", DANCE_DIRECTION[RAND.nextInt(DANCE_DIRECTION.length)]);
            stepCounter++;
            if (stepCounter % BREAK_LINE_AFTER == 0) {
                System.out.println();
            }
        }
        System.out.println();
    } // method performSillyDance

    /**
     * Recite the alphabet backwards (but forget one letter). The omitted letter is
     * selected at random and in its place we print a space.
     */
    public String reciteAlphabetBackwards() {
        String alpha25 = "";
        int omittedLetter = FIRST_LETTER + RAND.nextInt(NUMBER_OF_LETTERS);
        int letter = FIRST_LETTER + NUMBER_OF_LETTERS - 1;
        while (letter >= FIRST_LETTER) {
            if (letter != omittedLetter) {
                alpha25 += String.valueOf((char) letter);
            } else {
                alpha25 += " ";
            }
            letter--;
        }
        return alpha25;
    } // method reciteAlphabetBackwards

    /**
     * Count to ten in an unusual way (maybe skip a number). The skipped number is
     * selected at random.
     */
    public void countToTenWeirdly() {
        int skippedNumber = RAND.nextInt(UPTO);
        System.out.println();
        for (int i = 0; i <= UPTO; i++) {
            if (i != skippedNumber) {
                System.out.printf("%d ", i);
            }
        }
        System.out.println();
    } // method countToTenWeirdly

    /**
     * Create a whimsical poem about a topic of your choice. Could be a few words at
     * random, as long as string topic is included in the first line
     */
    public String createWhimsicalPoem(String topic) {
        int numberOfWords = SMALLEST_POEM + RAND.nextInt(LARGEST_POEM - SMALLEST_POEM);
        StringBuilder poem = new StringBuilder();
        poem.append(String.format("\n%s %s\n\n", POEM_TITLE, topic));
        for (int i = 0; i < numberOfWords; i++) {
            String word = PoemWords.words[RAND.nextInt(PoemWords.words.length)];
            poem.append(String.format("%s ", word));
            if (i % BREAK_LINE_AFTER == 0) {
                poem.append(String.format("\n"));
            }
        }
        return poem.toString();
    } // method createWhimsicalPoem

    /**
     * Produce numbers for the state lottery. The method is based on the Illinois
     * lottery where 6 numbers are drawn from 1 to 50.
     */
    public void winStateLottery() {
        System.out.printf("\n%s: ", LOTTERY_MESSAGE);
        for (int i = 0; i < LOTTERY_NUMBERS; i++) {
            System.out.printf("%d ", 1 + RAND.nextInt(MAX_LOTTERY_VALUE));
        }
        System.out.println();
    } // method winStateLottery

    // ------------------- AUTO GENERATED METHODS ------------------------------

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

    /** DRIVER CODE */
    public static void main(String[] args) {
        Person test = new Person();
        String poemTopic = "Java";
        test.makeRandomSound();
        test.performSillyDance();
        System.out.printf("\n%s\n", test.reciteAlphabetBackwards());
        test.countToTenWeirdly();
        System.out.println(test.createWhimsicalPoem(poemTopic));
        test.winStateLottery();
    }
}
