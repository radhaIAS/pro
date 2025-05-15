package dia;

public class RecursiveInsertionSort {
    
    // Recursive insertion sort function
    static void recursiveInsertionSort(int[] arr, int n) {
        // Base case
        if (n <= 1) {
            return;
        }

        // Sort first n-1 elements
        recursiveInsertionSort(arr, n - 1);

        // Insert last element at its correct position
        int last = arr[n - 1];
        int j = n - 2;

        // Move elements greater than last
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = last;
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
        int[] arr = {5, 2, 4, 6, 1, 3};
        recursiveInsertionSort(arr, arr.length);
        System.out.print("Sorted array: ");
        printArray(arr);
    }
}




// Function RecursiveInsertionSort(arr, n)
//     if n <= 1
//         return

//     // Sort first n-1 elements
//     RecursiveInsertionSort(arr, n-1)

//     // Insert last element at its correct position in sorted array
//     last = arr[n-1]
//     j = n - 2

//     // Move elements of arr[0..n-1], that are greater than 'last', to one position ahead
//     while j >= 0 and arr[j] > last
//         arr[j+1] = arr[j]
//         j = j - 1

//     arr[j+1] = last
