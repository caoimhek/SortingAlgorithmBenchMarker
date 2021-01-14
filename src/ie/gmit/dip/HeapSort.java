package ie.gmit.dip;

public class HeapSort implements ISortingAlgorithm {

	@Override
	public void Execute(int[] input) {
		sort(input);
	}

	@Override
	public String GetName() {
		return "HeapSort";
	}

	// This is Heap Sort.
	// https://www.geeksforgeeks.org/heap-sort/

	public void sort(int arr[]) {
		int n = arr.length;

		// Build a heap tree  by swapping elements in the array 
		for (int i = n / 2 - 1; i >= 0; i--)
			heapSort(arr, n, i);

		// flatten the hierarchy of the heap tree
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapSort(arr, i, 0);
		}
	}

	
	// given a binary tree described as the part of an array and the index of the root of the tree in that array
	// reorder the elements of the array so that the tree is a heap tree.
	public void heapSort(int arr[], int n, int i) {
		//calculate the indices of the left and right child 
		int l = 2 * i + 1; 
		int r = 2 * i + 2; 
		// find the index of the largest element between the root and the two children.
		int largest = i; 

		if (l < n && arr[l] > arr[largest])
			largest = l;

		if (r < n && arr[r] > arr[largest])
			largest = r;

		// If the root is not the largest element replace the largest element with the root 
		// do recursive call for subtree under largest element 
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			heapSort(arr, n, largest);
		}
	}

}
