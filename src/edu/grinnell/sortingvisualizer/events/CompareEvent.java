package edu.grinnell.sortingvisualizer.events;

import java.util.List;

public class CompareEvent<T> implements SortEvent<T>{

  
  @Override
  public void apply(T[] arr) {
    
  }
  
  
  @Override
  public List<Integer> getAffectedIndices() {
    return null;
  }
  
  
  @Override
  public boolean isEmphasized() {
    return true;
  }
  
  
  
  
  
  
}
