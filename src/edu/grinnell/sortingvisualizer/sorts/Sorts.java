package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.Arrays;
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

  public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(T[] arr) {
    List<SortEvent<T>> result = new ArrayList<>();

    if (arr == null) {
      return result;
    }

    for (int i = 1; i < arr.length; i++) {
      for (int j = i; j > 0 && arr[j - 1].compareTo(arr[j]) > 0; j--) {
        result.add(new CompareEvent<T>(j - 1, j));
        swap(arr, j, j - 1);
        result.add(new SwapEvent<T>(j - 1, j));
      }
    }

    return result;
  } // insertionSort



  /*
   * 
   * 
   * 
   * 
   */


  public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(T[] arr) {
    List<SortEvent<T>> eventList = new ArrayList<>();
    if (arr.length == 0) {
      return eventList;
    }
    mergeSortHelper(arr, 0, arr.length, eventList);
    return eventList;
  }

  /*
   * Procedure to perform merge for mergeSort
   */

  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>> void merge(T[] arr, int lo, int hi, int mid,
      List<SortEvent<T>> events) {
    int i = lo;
    int j = mid, k = 0;


    Object[] temp = new Object[hi - lo];
    while (i < mid && j < hi) {
      events.add(new CompareEvent<T>(i, j));
      if (arr[i].compareTo(arr[j]) <= 0) {
        temp[k++] = arr[i++];
      } else {
        temp[k++] = arr[j++];
      }
    } // while


    while (i < mid) {
      temp[k++] = arr[i++];
    }
    while (j < hi) {
      temp[k++] = arr[j++];
    }

    for (int n = 0; n < hi - lo; n++) {
      arr[n + lo] = (T) temp[n];
      events.add(new CopyEvent<T>(n + lo, (T) temp[n]));
    }
  }


  public static <T extends Comparable<T>> void mergeSortHelper(T[] arr, int lo, int hi,
      List<SortEvent<T>> events) {
    if (hi - lo > 1) {
      int mid = lo + (hi - lo) / 2;
      mergeSortHelper(arr, lo, mid, events);
      mergeSortHelper(arr, mid, hi, events);
      merge(arr, lo, hi, mid, events);
    }
  }



  public static <T> void swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


  public static <T extends Comparable<T>> ArrayList<SortEvent<T>> quickSort(T[] arr, int low,
      int high, ArrayList<SortEvent<T>> events) {


    int i = low;
    int j = high;

    int pivotIndex = i + (j - i) / 2;
    T pivot = arr[pivotIndex];

    while (i <= j) {

      while (arr[i].compareTo(pivot) < 0) {
        events.add(new CompareEvent<T>(i, pivotIndex));
        i++;
      }


      while (arr[j].compareTo(pivot) > 0) {
        events.add(new CompareEvent<T>(j, pivotIndex));
        j--;
      }

      if (i <= j) {
        swap(arr, i, j);
        events.add(new SwapEvent<T>(i, j));
        i++;
        j--;
      }
    }

    if (low < j) {
      quickSort(arr, low, j, events);
    }

    if (i < high) {
      quickSort(arr, i, high, events);
    }

    return events;
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
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j].compareTo(arr[j + 1]) > 0) {
          result.add(new CompareEvent<T>(j, j + 1));
          T temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;

          result.add(new SwapEvent<T>(j, j + 1));

        }
      }
    }

    return result;
  }

  public static <T extends Comparable<T>> void eventSort(T[] arr, ArrayList<SortEvent<T>> events) {
    for (SortEvent<T> event : events) {
      event.apply(arr);
    } // for
  } // eventSort

  public static void main(String[] args) {
    Integer[] vals = {8, 4, 1, 5, 2, 3, 0, 6, 7};
    Integer[] spare = vals.clone();

    ArrayList<SortEvent<Integer>> events = selectionSort(spare);
    System.err.println(Arrays.toString(spare));

    spare = vals.clone();
    eventSort(spare, events);
    System.err.println(Arrays.toString(spare));

    Integer[] test = {1, 4, 3, 2, 5, 7, 6};

    ArrayList<SortEvent<Integer>> test2 = new ArrayList<SortEvent<Integer>>();
    quickSort(test, 0, test.length - 1, test2);

    for (int i = 0; i < test.length; i++) {
      System.out.println(test[i]);
    }


  }
} // Sorts
