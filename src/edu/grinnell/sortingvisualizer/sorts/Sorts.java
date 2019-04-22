package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.List;
import edu.grinnell.sortingvisualizer.events.CompareEvent;
import edu.grinnell.sortingvisualizer.events.CopyEvent;
import edu.grinnell.sortingvisualizer.events.SortEvent;
import edu.grinnell.sortingvisualizer.events.SwapEvent;

public class Sorts<T extends Comparable<T>> {

  public static <T extends Comparable<T>> ArrayList<SortEvent<T>> selectionSort(T[] arr) {

    ArrayList<SortEvent<T>> result = new ArrayList<SortEvent<T>>();

    int length = arr.length;

    int minIndex;


    for (int i = 0; i < length - 1; i++) {
      minIndex = i;
      for (int j = i + 1; j < length; j++) {
        result.add(new CompareEvent<T>(j, minIndex));
        if (arr[j].compareTo(arr[minIndex]) < 0) {
          minIndex = j;
        } // if
      } // for

      result.add(new CompareEvent<T>(i, minIndex));


      T temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;

      result.add(new SwapEvent<T>(i, minIndex));
    } // for

    return result;
  } // selectionSort(T[] arr)

  /*
   * 
   * 
   * 
   * 
   */

  public static <T extends Comparable<T>> ArrayList<SortEvent<T>> insertionSort(T[] arr) {

    ArrayList<SortEvent<T>> result = new ArrayList<SortEvent<T>>();

    int length = arr.length;

    for (int i = 0; i < length; i++) {
      T key = arr[i];
      int j = i - 1;

      while (j >= 0 && (arr[j].compareTo(key)) > 0) {
        result.add(new CompareEvent<T>(j, i));
        arr[j + 1] = arr[j];
        result.add(new CopyEvent<T>(j + 1, j));
        --j;
      } // while
      arr[j + 1] = key;
      result.add(new CopyEvent<T>(j + 1, i));
    } // for

    return result;
  } // insertionSort(T[] arr)


  /*
   * 
   * 
   * 
   * 
   */

  public static <T extends Comparable<T>> void mergeSort(T[] arr, int l, int r) {

  }
  
  public static <T extends Comparable<T>> T[] mergeSortHelper(T[] arr, int low, int high) {
    if (high-low > 1) {
      int mid = low + (high-low) / 2;
      mergeSortHelper(arr, low, mid);
      mergeSortHelper(arr, mid + 1, high);
      merge(arr, low, high, mid);
    }
    return arr;
  }
  
  public static <T extends Comparable<T>> T[] merge(T[] arr, int low, int high, int mid) {
    Object[] merged = new Object[high - low + 1];
    
  }

  

  /*
   * 
   * 
   * 
   * 
   */
  
  public static <T> void swap(T[] array, int i, int j) {
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static <T extends Comparable<T>> ArrayList<SortEvent<T>> quickSort(T[] arr, int low, int high) {
    ArrayList<SortEvent<T>> result = new ArrayList<SortEvent<T>>();
    
    int i = low;
    int j = high;
    
    int pivotIndex = i + (j - i)/2;
    T pivot = arr[pivotIndex];
    
    while (i <= j) {
      while (arr[i].compareTo(pivot) < 0) {
        result.add(new CompareEvent<T>(i,pivotIndex));
        i++;
      }
      
      while(arr[i].compareTo(pivot) > 0) {
        result.add(new CompareEvent<T>(i,pivotIndex));
        j--;
      }
      
      if( i <= j) {
        swap(arr, i, j);
        result.add(new SwapEvent<T>(i,j));
        i++;
        j--;
      }
    }
    
    if(low < j) {
      quickSort(arr, low, j);
    }
    
    if (i < high) {
      quickSort(arr, i, high);
    }
    
    return result;
  }



  /*
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   */

  public static <T extends Comparable<T>> ArrayList<SortEvent<T>> bubbleSort(T[] arr) {

    ArrayList<SortEvent<T>> result = new ArrayList<SortEvent<T>>();

    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - i - 1; j++)
        if (arr[j].compareTo(arr[j + 1]) > 0) {
          result.add(new CompareEvent<T>(j,j+1));
          T temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          
          result.add(new SwapEvent<T>(j,j+1));

        }
    }

    return result;
  }

} // Sorts
