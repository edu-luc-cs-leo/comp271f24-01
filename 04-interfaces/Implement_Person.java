public class Implement_Person {
    public static void main(String[] args) {
        Person frodo = new Person("Frodo", "Baggins", 2968);
        Person bilbo = new Person("Bilbo", "Baggins", 2890);

        // Direct demonstration of compareTo in blatant violation
        // of the Programmer's Pact

        if (frodo.compareTo(bilbo) > 0) {
            System.out.println("Frodo is older than Bilbo");
        } else if (frodo.compareTo(bilbo) < 0) {
            System.out.println("Frodo is younger than Bildo");
        } else {
            System.out.println("Frodo is same age as Bilbo");
        }

        // Fully paramerized implementation
        // (compliant with the Pact)

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
            // Assuming present object lesser
            comparison = COMPARE_TO_NEGATIVE;
            if (diff > 0) {
                // Update if present object is greater
                comparison = COMPARE_TO_POSITIVE;
            }
        }
        // Report findings
        System.out.printf(FMT_STRING,
                frodo.getFirstName(),
                comparison,
                subordinatingConjuction,
                bilbo.getFirstName());
    }
}
