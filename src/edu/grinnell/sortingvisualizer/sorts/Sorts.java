package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.List;

public class Sorts<T extends Comparable<T>> {

  public static <T extends Comparable<T>> void selectionSort(T[] arr) {
    int length = arr.length;

    int minIndex;


    for (int i = 0; i < length - 1; i++) {
      minIndex = i;
      for (int j = i + 1; j < length; j++) {
        if (arr[j].compareTo(arr[minIndex]) < 0) {
          minIndex = j;
        } // if
      } // for

      T temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;

    } // for
  } // selectionSort(T[] arr)

  /*
   * 
   * 
   * 
   * 
   */
  
  public static <T extends Comparable<T>> void insertionSort(T[] arr) {
    int length = arr.length;

    for (int i = 0; i < length; i++) {
      T key = arr[i];
      int j = i - 1;
      
      while (j >= 0 && (arr[j].compareTo(key)) > 0) {
        arr[j + 1] = arr[j];
        --j;
      } // while
      arr[j + 1] = key;
    } // for
  } // insertionSort(T[] arr)


  /*
   * 
   * 
   * 
   * 
   */
  
  public static<T extends Comparable<T>> void mergeSort(T[] arr, int l, int r) {
    
  }
  
  public static <T extends Comparable<T>> void merge(T[] arr, int low, int middle, int high) {
    int length = (high - low) + 1;
    
    ArrayList<T> temp = new ArrayList<T>(length);
    
    int i = low;
    int j = middle + 1;
    T lowValue = null;
    T highValue = null;
    
    
  }
  
  /*
   * 
   * 
   * 
   * 
   */
  
  public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
    if (low < high) {
      int index = partition(arr, low, high);
      quickSort(arr, low, index - 1);
      quickSort(arr, index + 1, high);
    } // if
  } // quickSort(T[] arr, int low, int high)

  public static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
    T pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      if ((arr[j].compareTo(pivot) == 0) || (arr[j].compareTo(pivot) > 0)) {
        i++;
        // swap
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      } // if
    } // for

    // swap pivot
    T temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
  } // partition(T[] arr, int low, int high)
  
  
  
  /*
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   */

  public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - i - 1; j++)
        if (arr[j].compareTo(arr[j + 1]) > 0) {
          T temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
    }
  }

} // Sorts
