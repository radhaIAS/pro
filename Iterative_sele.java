Function SelectionSort(arr):
    For i = 0 to length of arr - 2:
        min_index = i
        For j = i + 1 to length of arr - 1:
            If arr[j] < arr[min_index]:
                min_index = j
        Swap arr[i] with arr[min_index]


