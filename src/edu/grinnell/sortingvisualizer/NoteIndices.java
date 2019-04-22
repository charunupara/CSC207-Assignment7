package edu.grinnell.sortingvisualizer;

import java.util.ArrayList;
import java.util.Random;

/**
 * A collection of indices into a Scale object. These indices are the subject of the various sorting
 * algorithms in the program.
 */
public class NoteIndices {


  ArrayList<Integer> highlights;

  Integer[] indices;

  /**
   * @param n the size of the scale object that these indices map into
   */
  public NoteIndices(int n) {
    highlights = new ArrayList<Integer>();

    this.indices = new Integer[n];

    for (int i = 0; i < n; i++) {
      indices[i] = i;
    }
  }

  /**
   * Reinitializes this collection of indices to map into a new scale object of the given size. The
   * collection is also shuffled to provide an initial starting point for the sorting process.
   * 
   * @param n the size of the scale object that these indices map into
   */
  public void initializeAndShuffle(int n) {
    highlights = new ArrayList<Integer>();

    this.indices = new Integer[n];

    for (int i = 0; i < n; i++) {
      indices[i] = i;
    }
    
    int rand1,rand2;
    
    Random rand = new Random();
    
    for (int i = 0; i < n; i++) {
      rand1 = rand.nextInt(n);
      rand2 = rand.nextInt(n);
      
      int temp = this.indices[rand1];
      this.indices[rand1] = this.indices[rand2];
      this.indices[rand2] = temp;
    }
  }

  /** @return the indices of this NoteIndices object */
  public Integer[] getNotes() {
    return this.indices;
  }

  /**
   * Highlights the given index of the note array
   * 
   * @param index the index to highlight
   */
  public void highlightNote(int index) {
    highlights.add(index);
  }

  /** @return true if the given index is highlighted */
  public boolean isHighlighted(int index) {
    return this.highlights.contains(index);
  }

  /** Clears all highlighted indices from this collection */
  public void clearAllHighlighted() {
    highlights.clear();
  }
}
