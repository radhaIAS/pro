package dia;

import java.util.Scanner;

public class MergeSort {
     public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArray[i++];
        }

        while (j < n2) {
            arr[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take input for array size
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        // Take input for array elements
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Perform merge sort
        mergeSort(arr, 0, arr.length - 1);

        // Print sorted array
        System.out.println("Sorted array:");
        for (int val : arr) {
            System.out.print(val + " ");
        }

        sc.close();
    }
    
}








// FUNCTION MergeSort(array)
//     IF size of array > 1 THEN
//         Divide array into two halves: left and right
//         MergeSort(left)
//         MergeSort(right)
//         Merge left and right into sorted array
//     END IF
// END FUNCTION

// FUNCTION Merge(left, right, array)
//     i ← 0   // index for left
//     j ← 0   // index for right
//     k ← 0   // index for array

//     WHILE i < size of left AND j < size of right DO
//         IF left[i] < right[j] THEN
//             array[k] ← left[i]
//             i ← i + 1
//         ELSE
//             array[k] ← right[j]
//             j ← j + 1
//         END IF
//         k ← k + 1
//     END WHILE

//     WHILE i < size of left DO
//         array[k] ← left[i]
//         i ← i + 1
//         k ← k + 1
//     END WHILE

//     WHILE j < size of right DO
//         array[k] ← right[j]
//         j ← j + 1
//         k ← k + 1
//     END WHILE
// END FUNCTION

// // MAIN PROGRAM
// Read n
// Create array of size n
// Read n elements into array
// Call MergeSort(array)
// Print sorted array
