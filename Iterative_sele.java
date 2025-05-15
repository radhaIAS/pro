// Function SelectionSort(arr):
//     For i = 0 to length of arr - 2:
//         min_index = i
//         For j = i + 1 to length of arr - 1:
//             If arr[j] < arr[min_index]:
//                 min_index = j
//         Swap arr[i] with arr[min_index]

public class IterativeSelectionSort {

    // Iterative selection sort function
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Traverse the array
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the current element
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Main function to test the sort
    public static void main(String[] args) {
        int[] arr = {29, 10, 14, 37, 13};

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        selectionSort(arr); // Call the sort function

        System.out.println("\nSorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

