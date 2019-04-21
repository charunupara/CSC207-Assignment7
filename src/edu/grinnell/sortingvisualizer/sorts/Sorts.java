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

  public static <T extends Comparable<T>> void merge(T[] arr, int low, int middle, int high) {
    int length = (high - low) + 1;

    ArrayList<T> temp = new ArrayList<T>(length);

    int i = low;
    int j = middle + 1;
    T lowValue = null;
    T highValue = null;

    for (int k = 0; k < length; k++) {

    }


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
