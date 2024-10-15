import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FastQTest {
   private FastQ test = new FastQ();

   @Test
   public void testRemoveEmpty() {
      assertNull(test.remove());
   }

   @Test
   public void testAdd() {
      assertTrue(test.add("A"));
      assertTrue(test.add("B"));
      assertTrue(test.add("C"));
      assertTrue(test.add("D"));
      assertFalse(test.add("E"));
   }

   @Test
   public void testRemove() {
      test.add("A");
      test.add("B");
      test.add("C");
      test.add("D");
      assertEquals(test.remove(), "A");
      assertEquals(test.remove(), "B");
      assertEquals(test.remove(), "C");
      assertEquals(test.remove(), "D");
      assertNull(test.remove());
   }

}