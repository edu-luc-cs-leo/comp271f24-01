/*
 * Interface is named Comparable271 to emphasize its use in COMP 271 and to 
 * avoid any confusion with Java's industry-standard Comparable interface. 
*/
public interface Comparable271<X> {
    /**
     * The method shall return a negative if the invoking is smaller in the
     * established natural ordering than the passed object. The specifics of the
     * natural ordering are determimed in the implementing class, based on available
     * information about the objects.
     * 
     * @param other Person to compare present object with
     * @return a value > 0 if this.object is greater than the other.object in the
     *         established natural ordering, a value < 0 if this.person is less than
     *         the other.person, or 0 if this.object identical to other.object.
     */
    public int compareTo(X o);
}
