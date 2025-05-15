package dia;

public class IterativeInsertionSort {
        // Iterative insertion sort function
        static void insertionSort(int[] arr) {
            int n = arr.length;
    
            for (int i = 1; i < n; i++) {
                int key = arr[i];
                int j = i - 1;
    
                // Move elements greater than key to one position ahead
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
    
                arr[j + 1] = key;
            }
        }
    
        // Helper function to print array
        static void printArray(int[] arr) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    
        // Main method
        public static void main(String[] args) {
            int[] arr = {9, 5, 1, 4, 3};
            insertionSort(arr);
            System.out.print("Sorted array: ");
            printArray(arr);
        }
    
}


// Function InsertionSort(arr, n)
    // for i from 1 to n-1
    //     key = arr[i]
    //     j = i - 1

    //     // Move elements greater than key one position ahead
    //     while j >= 0 and arr[j] > key
    //         arr[j + 1] = arr[j]
    //         j = j - 1

    //     arr[j + 1] = key
