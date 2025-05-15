package dia;
public class SimpleQuickSort{

    // Quick Sort function
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // Find pivot index
            quickSort(arr, low, pi - 1);  // Sort left part
            quickSort(arr, pi + 1, high); // Sort right part
        }
    }

    // Partition function
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in the correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return pivot index
    }

    // Main function to run the program
    public static void main(String[] args) {
        int[] arr = { 5, 2, 9, 1, 7 };

        quickSort(arr, 0, arr.length - 1);

        // Print the sorted array
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}



// QUICKSORT(arr, low, high):
//     if low < high:
//         pivotIndex = PARTITION(arr, low, high)
//         QUICKSORT(arr, low, pivotIndex - 1)
//         QUICKSORT(arr, pivotIndex + 1, high)

// PARTITION(arr, low, high):
//     pivot = arr[high]
//     i = low - 1
//     for j = low to high - 1:
//         if arr[j] < pivot:
//             i = i + 1
//             swap arr[i] with arr[j]
//     swap arr[i + 1] with arr[high]
//     return i + 1
