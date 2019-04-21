package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class SwapEvent<T> implements SortEvent<T> {

  
  int index1;
  
  int index2;
  
  public SwapEvent(int index1, int index2) {
    this.index1 = index1;
    this.index2 = index2;
  }
  @Override
  public void apply(T[] arr) {
    T temp = arr[this.index1];
    arr[this.index1] = arr[this.index2];
    arr[this.index2] = temp;
  }
  
  @Override
  public List<Integer> getAffectedIndices() {
    List<Integer> result = new ArrayList<Integer>();
    result.add(index1);
    result.add(index2);
    return result;
  }
  
  @Override
  public boolean isEmphasized() {
    return true;
  }
  
}
