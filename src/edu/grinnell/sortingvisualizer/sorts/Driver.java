package edu.grinnell.sortingvisualizer.sorts;

public class Driver {
  public static void main(String[] args) {
    Integer[] arr = {3,9,2,5};
    
    printArray(arr);
    
    Sorts.insertionSort(arr);
    
    
    printArray(arr);
  }
  
  public static void printArray(Integer arr[]) 
  { 
      int n = arr.length; 
      for (int i=0; i<n; ++i) 
          System.out.print(arr[i]+" "); 
      System.out.println(); 
  } 
}
