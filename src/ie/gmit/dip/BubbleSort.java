package ie.gmit.dip;

public class BubbleSort implements ISortingAlgorithm {

	@Override
	public void Execute(int[] input) {
		bubbleSort(input);
	}

	@Override
	public String GetName() {
		return "BubbleSort";
	}

	// This is Bubble Sort.
	// https://www.javatpoint.com/bubble-sort-in-java
	private void bubbleSort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		//for each element in the array 
		for (int i = 0; i < n; i++) {
			//iterate from the beginning of the array up to that element
			for (int j = 1; j < (n - i); j++) {
				// if two consecutive elements are not ordered, swap them.
				if (arr[j - 1] > arr[j]) {
					
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

}
