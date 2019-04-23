package edu.grinnell.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T> implements SortEvent<T> {

  int destination;
  
  T source;
  
  
  public CopyEvent(int destination, T source) {
    this.destination = destination;
    this.source = source;
    
  }
  
  @Override
  public String toString() {
    return "copy(" + destination + "," + source + ")";
  }

  
  @Override
  public void apply(T[] arr) {
    arr[destination] = source;
  }
  
  @Override
  public List<Integer> getAffectedIndices() {
    ArrayList<Integer> result = new ArrayList<Integer>();
    result.add(this.destination);
    return result;
  }
  
  @Override
  public boolean isEmphasized() {
    return true;
  }
  
}
