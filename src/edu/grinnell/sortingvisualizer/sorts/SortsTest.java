package edu.grinnell.sortingvisualizer.sorts;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Random;
import org.junit.jupiter.api.Test;
import edu.grinnell.sortingvisualizer.events.SortEvent;

class SortsTest {
  
  @Test
  public void selectionSortTest() {
    
    //Test with empty array
    Integer[] arr1 = {};
    Integer[] arr2 = {};
    Sorts.selectionSort(arr1);
    assertArrayEquals(arr1, arr2);
    
    //Test with a single element
    Integer[] arr3 = {63};
    Integer[] arr4 = {63};
    Sorts.selectionSort(arr3);
    assertArrayEquals(arr3, arr4);
    
    //Already sorted array
    Integer[] arr5 = {1, 2, 3, 4, 5};
    Integer[] arr6 = {1, 2, 3, 4, 5};
    Sorts.selectionSort(arr5);
    assertArrayEquals(arr5, arr6);
    
    //Descending array, worst case scenario
    Integer[] arr7 = {5, 4, 3, 2, 1};
    Integer[] arr8 = {1, 2, 3, 4, 5};
    Sorts.selectionSort(arr7);
    assertArrayEquals(arr7, arr8);
    
    //Permute array, then sort
    Integer[] arr9 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Integer[] arr10 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    shuffleArray(arr9);
    Sorts.selectionSort(arr9);
    assertArrayEquals(arr9, arr10);
    
  }
  
  @Test
  public void insertionSortTest() {
    //Test with empty array
    Integer[] arr1 = {};
    Integer[] arr2 = {};
    Sorts.insertionSort(arr1);
    assertArrayEquals(arr1, arr2);
    
    //Test with a single element
    Integer[] arr3 = {63};
    Integer[] arr4 = {63};
    Sorts.insertionSort(arr3);
    assertArrayEquals(arr3, arr4);
    
    //Already sorted array
    Integer[] arr5 = {1, 2, 3, 4, 5};
    Integer[] arr6 = {1, 2, 3, 4, 5};
    Sorts.insertionSort(arr5);
    assertArrayEquals(arr5, arr6);
    
    //Descending array, worst case scenario
    Integer[] arr7 = {5, 4, 3, 2, 1};
    Integer[] arr8 = {1, 2, 3, 4, 5};
    Sorts.insertionSort(arr7);
    assertArrayEquals(arr7, arr8);
    
    //Permute array, then sort
    Integer[] arr9 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Integer[] arr10 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    shuffleArray(arr9);
    Sorts.insertionSort(arr9);
    assertArrayEquals(arr9, arr10);
  }
  
  @Test
  public void mergeSortTest() {
    //Test with empty array
    Integer[] arr1 = {};
    Integer[] arr2 = {};
    Sorts.mergeSort(arr1);
    assertArrayEquals(arr1, arr2);
    
    //Test with a single element
    Integer[] arr3 = {63};
    Integer[] arr4 = {63};
    Sorts.mergeSort(arr3);
    assertArrayEquals(arr3, arr4);
    
    //Already sorted array
    Integer[] arr5 = {1, 2, 3, 4, 5};
    Integer[] arr6 = {1, 2, 3, 4, 5};
    Sorts.mergeSort(arr5);
    assertArrayEquals(arr5, arr6);
    
    //Descending array, worst case scenario
    Integer[] arr7 = {5, 4, 3, 2, 1};
    Integer[] arr8 = {1, 2, 3, 4, 5};
    Sorts.mergeSort(arr7);
    assertArrayEquals(arr7, arr8);
    
    //Permute array, then sort
    Integer[] arr9 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Integer[] arr10 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    shuffleArray(arr9);
    Sorts.mergeSort(arr9);
    assertArrayEquals(arr9, arr10);
  }
  
  @Test
  public void quickSortTest() {
    
    ArrayList<SortEvent<Integer>> events = new ArrayList<SortEvent<Integer>>();
    
    
    //Test with a single element
    Integer[] arr3 = {63};
    Integer[] arr4 = {63};
    Sorts.quickSort(arr3, 0, arr3.length -1,events);
    assertArrayEquals(arr3, arr4);
    
    //Already sorted array
    Integer[] arr5 = {1, 2, 3, 4, 5};
    Integer[] arr6 = {1, 2, 3, 4, 5};
    Sorts.quickSort(arr5, 0, arr5.length-1,events);
    assertArrayEquals(arr5, arr6);
    
    //Descending array, worst case scenario
    Integer[] arr7 = {5, 4, 3, 2, 1};
    Integer[] arr8 = {1, 2, 3, 4, 5};
    Sorts.quickSort(arr7, 0, arr7.length-1,events);
    assertArrayEquals(arr7, arr8);
    
    //Permute array, then sort
    Integer[] arr9 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Integer[] arr10 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    shuffleArray(arr9);
    Sorts.quickSort(arr9, 0, arr9.length-1, events);
    assertArrayEquals(arr9, arr10);
  }
  
  @Test
  public void bubbleSortTest() {
    //Test with empty array
    Integer[] arr1 = {};
    Integer[] arr2 = {};
    Sorts.bubbleSort(arr1);
    assertArrayEquals(arr1, arr2);
    
    //Test with a single element
    Integer[] arr3 = {63};
    Integer[] arr4 = {63};
    Sorts.bubbleSort(arr3);
    assertArrayEquals(arr3, arr4);
    
    //Already sorted array
    Integer[] arr5 = {1, 2, 3, 4, 5};
    Integer[] arr6 = {1, 2, 3, 4, 5};
    Sorts.bubbleSort(arr5);
    assertArrayEquals(arr5, arr6);
    
    //Descending array, worst case scenario
    Integer[] arr7 = {5, 4, 3, 2, 1};
    Integer[] arr8 = {1, 2, 3, 4, 5};
    Sorts.bubbleSort(arr7);
    assertArrayEquals(arr7, arr8);
    
    //Permute array, then sort
    Integer[] arr9 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Integer[] arr10 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    shuffleArray(arr9);
    Sorts.bubbleSort(arr9);
    assertArrayEquals(arr9, arr10);
  }
  
  static void shuffleArray(Integer[] ar)
  {
    Random rnd = new Random();
    for (int i = ar.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);

      int j = ar[index];
      ar[index] = ar[i];
      ar[i] = j;
    }
  }
}


