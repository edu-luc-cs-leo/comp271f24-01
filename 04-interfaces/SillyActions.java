public interface SillyActions {

    /**
     * Make a random sound. Actually, produce a random word and print it (no need to
     * find how to make an actual sound)
     */
    void makeRandomSound();

    /**
     * Perform a silly dance by describing it as a sequence of a few steps left,
     * right, backwards, and forward
     */
    void performSillyDance();

    /** Recite the alphabet backwards (but forget one letter) */
    String reciteAlphabetBackwards();

    /** Count to ten in an unusual way (maybe skip a number) */
    void countToTenWeirdly();

    /**
     * Create a whimsical poem about a topic of your choice. Could be a few words at
     * random, as long as string topic is included in the first line
     */
    String createWhimsicalPoem(String topic);

    /** Produce numbers for the state lottery */
    void winStateLottery();
}
