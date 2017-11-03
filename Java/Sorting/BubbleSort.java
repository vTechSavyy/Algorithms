import java.util.Scanner;

class BubbleSort{

  // Method to swap two elements of an array:
  public static void swap(int[] inputArr , int i , int j){

    int temp;
    temp = inputArr[i];
    inputArr[i] = inputArr[j];
    inputArr[j] = temp;
  }

  // Main function to test the program:
  public static void main(String[] args) {

    // Get the elements as inputs from the user:
      // Create a Scanner element to get the user input:
      Scanner sc = new Scanner(System.in);

      // String to store the user input line:
      String inputArrStr;


      System.out.println("Please enter the elements of the unsorted array separated by a comma ");

      inputArrStr = sc.nextLine();

      String[] elementsStr = inputArrStr.split(",");

      // Convert the array of Strings to array of integers:
      int arrLength = elementsStr.length;

      int[] inputArr = new int[arrLength];

      for (int k=0;k < arrLength;k++){
        inputArr[k] = Integer.parseInt(elementsStr[k]);
      }




  // Perform Bubble sort: Time Complexity = 0(n^2) : Auxiliary space = O(1)
    // Outer loop: Going over all elements:
    for (int i =0 ; i < arrLength; i++){

        // Inner loop : Going from the start of the array upto 'end of array - current i' :
        for (int j= 0 ; j< arrLength - i - 1 ; j++){

          if (inputArr[j] >  inputArr [j+1]){
            swap(inputArr , j , j +1 );
          }

        }
    }

    // Display the sorted array:
    System.out.println(" The sorted array using Bubble Sort is");
    for (int p =0;p<arrLength;p++){
    System.out.print(inputArr [p] + " , ");
    }

    System.out.println(" ");

  }



};
