import java.util.Scanner;

class MergeSort {


// Recursive function that implements the divide strategy:
public static void mergeRec(int[] inputArr, int l, int r){

        // Stopping condition: If l is no longer less than r:
        if (l <r) {
                // Compute the median element index:
                int m = (l+r)/2;

                // Recursively call mergeRec for the left and right sub- arrays:
                mergeRec(inputArr, l , m);
                mergeRec(inputArr, m+1, r);

                // At each recursion level : After left and right sub-arrays have been sorted merge them:
                merge(inputArr, l,r,m);

        }
}

// Utility function that merges two sorted arrays: But takes up auxiliary space that is linear in the input size  :-(
public static void merge(int[] inputArr, int l, int r, int m){

  // Get the size of the left and right sub-arrays at this recursion level:
  int l_size = m -l + 1;
  int r_size = r - m;

  // Create temporary arrays to store the elements of left and right sub-arrays:
  int[] l_array = new int[l_size];
  int[] r_array = new int[r_size];

  // Copy the elements of original array into the temporary arrays:
  for (int i=0;i< l_size;++i){
    l_array[i] = inputArr[l+i];
  }

  for (int j = 0;j<r_size;++j){
    r_array[j] = inputArr[m+ 1+j];
  }

  // Cursor for inputArr:
  int k = l;
  // Cursor for left array:
  int lc =0;
  //Cursor for right array:
  int rc =0;

  // Loop through and merge the elements:
  while (lc<l_size && rc <r_size){

    if (l_array[lc] < r_array[rc]){
      inputArr[k] = l_array[lc];
      lc++;
    }
    else{
      inputArr[k] = r_array[rc];
      rc++;
    }

    k++;
  }

  // If left array is still remaining :
  while (lc < l_size){
    inputArr[k] = l_array[lc];
    lc++;
    k++;
  }

  // If right array is still remaining:
  while (rc< r_size){
    inputArr[k] = r_array[rc];
    rc++;
    k++;
  }

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
        mergeRec(inputArr, 0, inputArr.length - 1);

// Display the sorted array:
        System.out.println(" The sorted array using MergeSort is");
        for (int p =0; p<arrLength; p++) {
                System.out.print(inputArr [p] + " , ");
        }

        System.out.println(" ");

}



};
