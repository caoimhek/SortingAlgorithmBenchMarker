package ie.gmit.dip;

public class QuickSort implements ISortingAlgorithm {

	@Override
	public void Execute(int[] input) {
		quickSort(input, 0, input.length - 1);
	}

	@Override
	public String GetName() {
		return "QuickSort";
	}

	// This is Quick Sort.
	// https://www.programcreek.com/2012/11/quicksort-array-in-java/

	public void quickSort(int[] arr, int start, int end) {
        // call the partition  in a range that covers the start to end.
		int partition = partition(arr, start, end);
        // the element at position of partition is sorted.
		// do a recursive call for the elements from start until before the partition index
		if (partition - 1 > start) {
			quickSort(arr, start, partition - 1);
		}
		//Do a recursive call for the elements from the element after the partition until the end.
		if (partition + 1 < end) {
			quickSort(arr, partition + 1, end);
		}
	}

	private int partition(int[] arr, int start, int end) {
		//select the pivot as the last element 
		int pivot = arr[end];
        //for each element in the range 
		for (int i = start; i < end; i++) {
			// if the element is less than the pivot value
			// ensure that the element is on the left side of the partition index 
			if (arr[i] < pivot) {
				int temp = arr[start];
				arr[start] = arr[i];
				arr[i] = temp;
				start++;
			}
		}
		//The value at the partition index is the value of the pivot.
		int temp = arr[start];
		arr[start] = pivot;
		arr[end] = temp;

		return start;
	}

}
