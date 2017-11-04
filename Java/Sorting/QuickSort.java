import java.util.Scanner;

// Time Complexity: Each partition operation time is linear in the number of input elements. The number of times this is happeneing is equal to the depth of the call stack
// which is log n. Thus, O(n logn)
// Auixiliary Space Complexity: O(1)
class QuickSort {


// Recursive function that implements the divide strategy:
public static void quickRec(int[] inputArr, int l, int r){

        // Stopping condition: If l is no longer less than r:
        if (l <r) {

                // Partition the current sub-array:
                int pIndex = partition(inputArr, l, r);

                // Recursively call quickRec for the smaller and bigger sub- arrays:
                quickRec(inputArr, l , pIndex -1);
                quickRec(inputArr, pIndex +1 , r);


        }
}

// Utility function that partitions a sub array using the last element as the pivot:
public static int partition(int[] inputArr, int l, int r){


// Algorithm: Start from the lowest element: Keep an index for:
// a. All the elements in the sub-array:
// b. Elements in the sub-array less than the pivot:
// Move forward in the array and if:
//                               element < pivot:
//                                     swap it with current index of elements less than pivot && increment this index

int ind_less = l-1;
int pivot = inputArr[r];

for (int j= l; j< r;j++){

  if (inputArr[j] <pivot){
    ind_less++;
    swap(inputArr, j, ind_less);
  }

}

// Finally swap the last element i.e the pivot with the element just after ind_less:
swap(inputArr, r,ind_less +1);

return ind_less +1;

}

// Method to swap two elements of an array:
public static void swap(int[] inputArr, int i, int j){

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

        for (int k=0; k < arrLength; k++) {
                inputArr[k] = Integer.parseInt(elementsStr[k]);
        }


        // Perform MergeSort:
        quickRec(inputArr, 0, inputArr.length - 1);

// Display the sorted array:
        System.out.println(" The sorted array using QuickSort is");
        for (int p =0; p<arrLength; p++) {
                System.out.print(inputArr [p] + " , ");
        }

        System.out.println(" ");

}



};
