package edu.grinnell.sortingvisualizer.sorts;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Sam's tests for Quicksort.
 */
class SamQuicksortTests {

  // +-----------+---------------------------------------------------
  // | Utilities |
  // +-----------+

  /**
   * Test Quicksort, given an expected result and an input array.
   */
  void checkQuicksort(int expected[], int[] values) {
    eventSort.sort(values);
    assertArrayEquals(expected, values);
  } // checkQuicksort
  
  /**
   * Permute an already sorted array, 
   */
  void checkQuicksort(int[] sorted) {
    int[] copy = sorted.clone();
    TestUtils.randomlyPermute(copy);
    checkQuicksort(sorted, copy);
  } // checkQuicksort

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  void testEmpty() {
    checkQuicksort(new int[0]);
  } // testEmpty

  @Test
  void testOrdered() {
    for (int size = 1; size < 20; size++) {
      int[] sorted = new int[size];
      for (int i = 0; i < size; i++) {
        sorted[i] = i;
      } // for
      checkQuicksort(sorted, sorted.clone());
    } // for
  } // testOrdered

  @Test
  void testBackwards() {
    for (int size = 1; size < 20; size++) {
      int[] sorted = new int[size];
      int[] backwards = new int[size];
      for (int i = 0; i < size; i++) {
        backwards[i] = size-i;
        sorted[i] = i+1;
      } // for
      checkQuicksort(sorted, backwards);
    } // for
  } // testBackwards

  @Test
  void testRandom() {
    for (int trials = 0; trials < 5; trials++) {
      // Some comparatively small ones
      for (int size = 1; size < 20; size++) {
        checkQuicksort(TestUtils.randomInts(size));
      } // for size
      // Some larger ones
      for (int size = 30; size < 1000; size = size*2 + 1) {
        checkQuicksort(TestUtils.randomInts(size));
      } // for size
    } // for trials
  } // testRandom()
} // SamQuicksortTests
