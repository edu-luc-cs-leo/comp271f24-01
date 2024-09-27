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

    @Override
    public int compareTo(Person other) {
        return other.getYearBorn() - this.yearBorn;
    } 

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", yearBorn=" + yearBorn + "]";
    }

    // Getter and Setter methods

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

    // Implementing SillyActions methods

    @Override
    public void makeRandomSound() {
        String[] sounds = {"Buzz", "Meow", "Whistle", "Bloop", "Zap"};
        Random rand = new Random();
        String sound = sounds[rand.nextInt(sounds.length)];
        System.out.println("Random sound: " + sound);
    }

    @Override
    public void performSillyDance() {
        String[] danceMoves = {"Step left", "Hop right", "Spin around", "Slide back", "Wiggle forward"};
        Random rand = new Random();
        System.out.println("Silly Dance:");
        for (int i = 0; i < 5; i++) {
            System.out.println(danceMoves[rand.nextInt(danceMoves.length)]);
        }
    }

    @Override
    public String reciteAlphabetBackwards() {
        String alphabet = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        Random rand = new Random();
        int letterToForget = rand.nextInt(alphabet.length());
        StringBuilder backwards = new StringBuilder();
        for (int i = 0; i < alphabet.length(); i++) {
            if (i != letterToForget) {
                backwards.append(alphabet.charAt(i));
            }
        }
        return "Reciting alphabet backwards (but forgot one letter): " + backwards.toString();
    }

    @Override
    public void countToTenWeirdly() {
        Random rand = new Random();
        int numberToSkip = rand.nextInt(10) + 1;
        System.out.print("Counting to ten weirdly: ");
        for (int i = 1; i <= 10; i++) {
            if (i != numberToSkip) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    @Override
    public String createWhimsicalPoem(String topic) {
        Random rand = new Random();
        StringBuilder poem = new StringBuilder("A whimsical poem about " + topic + ":\n");
        for (int i = 0; i < 4; i++) {
            int randomWordIndex = rand.nextInt(PoemWords.words.length);
            poem.append(PoemWords.words[randomWordIndex]).append(" ");
        }
        poem.append("\n");
        return poem.toString();
    }

    @Override
    public void winStateLottery() {
        Random rand = new Random();
        System.out.print("Your lucky lottery numbers: ");
        for (int i = 0; i < 6; i++) {
            System.out.print((rand.nextInt(49) + 1) + " ");
        }
        System.out.println();
    }
}
