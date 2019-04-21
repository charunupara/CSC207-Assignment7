package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class CompareEvent<T> implements SortEvent<T> {

  int index1;

  int index2;

  public CompareEvent(int index1, int index2) {
    this.index1 = index1;
    this.index2 = index2;
  }

  @Override
  public void apply(T[] arr) {
    return;
  }


  @Override
  public List<Integer> getAffectedIndices() {
    ArrayList<Integer> result = new ArrayList<Integer>();
    result.add(this.index1);
    result.add(this.index2);
    return result;

  }

  @Override
  public boolean isEmphasized() {
    return false;
  }

}
