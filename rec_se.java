public class RecursiveSelectionSort {

    // Recursive selection sort function
    public static void selectionSort(int[] arr, int start) {
        // Base case
        if (start >= arr.length - 1)
            return;

        // FindWS the index of the minimum element
        int minIndex = start;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        // Swap the found minimum element with the first element
        int temp = arr[start];
        arr[start] = arr[minIndex];
        arr[minIndex] = temp;

        // Recursive call for the remaining array
        selectionSort(arr, start + 1);
    }

    // Main function to test the sort
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        selectionSort(arr, 0); // start from index 0

        System.out.println("\nSorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
