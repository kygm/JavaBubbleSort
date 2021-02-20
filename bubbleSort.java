import java.util.*;
import java.util.concurrent.TimeUnit;
public class bubbleSort
{
  public static void main(String[] args)
  {
    //var declarations
    String input;
    int delay = ((3)*(1000));
    int sizeOf = 15;
    int searchNum = 5;
    
    //object declarations
    Scanner kb = new Scanner(System.in);
    Timer timer = new Timer();
    Random randInt = new Random();
    
    //array declaration
    int[] array = new int[sizeOf];
    int[] sortedArray = new int[sizeOf];
    
    do
    {
      //filling the array
      for(int x = 0; x < sizeOf; x++)
      {
        array[x] = randInt.nextInt(sizeOf);
      }
      
      //showing unsorted array
      ShowArray(array);
      try
      {
        Thread.sleep(delay);
      }
      catch(InterruptedException e)
      {
        //catching the exception
      }
      System.out.println();
      //sorting array with bubble sort
      sortedArray = SortBubble(array);
      
      //showing sorted array
      ShowArray(sortedArray);
      
      System.out.println("Searching for " + searchNum + " using binary search");
      int index = BinarySearch(sortedArray, searchNum);
      if(index == -1)
      {
        System.out.println(searchNum + " does not exist in the array");
      }
      else
      {
      System.out.println(searchNum + " found in index " + index + "/" + sizeOf);
      }
      
      System.out.println("Searching for " + searchNum + " using the slow search");
      int nindex = SlowSearch(array, searchNum);
      if(index == -1)
      {
        System.out.println(searchNum + " does not exist in the array");
      }
      else
      {
        System.out.println(searchNum + " found in index " + nindex + "/" + sizeOf);
      }
      
      
      System.out.println("Enter n to stop prog or any" +
      " or any other key to continue");
      input = kb.next();
    }while (!input.equals("n"));
  }
  /*
    This method prints the array
  */
  private static void ShowArray(int[] array)
  {
    for(int x = 0; x<array.length; x++)
    {
      System.out.println(array[x]);
    }
  }
  
  /*
    This method sorts the array using the bubble sort
  */
  private static int[] SortBubble(int[] array)
  {
    for(int x = 0; x < array.length -1; x++)
      {
        for(int y = 0; y < array.length - x - 1; y++)
        {
          if(array[y]>array[y+1])
          {
            int temp = array[y];
            array[y] = array[y+1];
            array[y+1] = temp;
          }
        }
      }
      return array;
  }
  /*
    This method does a binary search.
    It takes in an integer array, an 
    integer to be searched, and returns
    the array position.
  */
  private static int BinarySearch(int[] array, int searched)
  {
    int left = 0;
    int right = array.length - 1;
    
    while(left <= right)
    {
      int middle = (left + right) / 2;
      if(searched < array[middle]) //too high
      {
        right = middle - 1;
      }
      else if(searched > array[middle]) //too low
      {
        left = middle + 1;
      }
      else //correct index
      {
        return middle;
      }
    }
    return -1;
  }
  
  private static int SlowSearch(int[] array, int searched)
  {
    int position = 0;
    for(int x = 0; x < array.length; x++)
    {
      if(array[x] == searched)
      {
        position = x;
        return position;
      }

    }
    return position;
    
  }
  
}