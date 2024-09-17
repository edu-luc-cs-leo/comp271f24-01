public class Implement_Person {
    public static void main(String[] args) {

        // Two test objects
        Person frodo = new Person("Frodo", "Baggins", 2968);
        Person bilbo = new Person("Bilbo", "Baggins", 2890);

        // Direct demonstration of compareTo in blatant violation
        // of the Programmer's Pact. The code below has magic 
        // values and repeated content.

        if (frodo.compareTo(bilbo) > 0) {
            System.out.println("Frodo is older than Bilbo");
        } else if (frodo.compareTo(bilbo) < 0) {
            System.out.println("Frodo is younger than Bildo");
        } else {
            System.out.println("Frodo is same age as Bilbo");
        }

        /*
         * Fully paramerized implementation
         * (compliant with the Pact)
         * minimal (if any) redudancy in code
         * 
         * Based on the analysis of desired output. All three possible cases:
         * 
         * Frodo is younger than Bilbo
         * Frodo is older than Bilbo
         * Frodo is same as as Bilbo
         * 
         * The phrase pattern is more or less the same:
         * 
         * (invoking object) "is" (comparison outcome) (conjunction) (called object)
         * 
         * There are two possible conjunctions "than", for older-than and younger-than,
         * and "as" for same age-as. This leads to a formatting string for four strings:
         * 
         * "%s is %s %s %s"
         * 
         * where each %s corresponds to invoking object, comparison outcome,
         * conjunction, and called object respectively.
         * 
         */

        final String SUBORDINATING_CONJUCTION_SIMILAR = "as";
        final String SUBORDINATING_CONJUCTION_DIFFERENT = "than";
        final String DEFAULT_COMPARISON = "same age";
        final String COMPARE_TO_POSITIVE = "older";
        final String COMPARE_TO_NEGATIVE = "younger";
        final String FMT_STRING = "\n%s is %s %s %s\n";

        String comparison;
        String subordinatingConjuction;

        int diff = frodo.compareTo(bilbo);

        if (diff == 0) {
            // objects are similar
            comparison = DEFAULT_COMPARISON;
            subordinatingConjuction = SUBORDINATING_CONJUCTION_SIMILAR;
        } else {
            // objects are different
            subordinatingConjuction = SUBORDINATING_CONJUCTION_DIFFERENT;
            comparison = (diff > 0) ? COMPARE_TO_POSITIVE : COMPARE_TO_NEGATIVE;
        }
        // Report findings
        System.out.printf(FMT_STRING,
                frodo.getFirstName(),
                comparison,
                subordinatingConjuction,
                bilbo.getFirstName());
    } // method main
} // class Implement_Person
