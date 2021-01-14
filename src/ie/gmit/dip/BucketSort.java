package ie.gmit.dip;

public class BucketSort implements ISortingAlgorithm {

	@Override
	public void Execute(int[] input) {
		bucketSort(input, maxValue(input));
	}

	@Override
	public String GetName() {
		return "BucketSort";
	}

	// This is Bucket Sort.
	// https://www.codespeedy.com/bucket-sort-in-java/

	public void bucketSort(int[] arr, int max_value) {
		//Create a counter for every possible value in the array. 
		int[] bucket = new int[max_value + 1];
        // count the occurrence of each unique value in the array.
		for (int i = 0; i < arr.length; i++)
			bucket[arr[i]]++;
        //assign the values of the sorted array by writing the index of each bucket (sorted by definition) as many times
		// as the index appears in the input array (non appearing values are skipped)
		int pos = 0;
		for (int i = 0; i < bucket.length; i++)
			for (int j = 0; j < bucket[i]; j++)
				arr[pos++] = i;

	}
    // Get the max value from an array of ints
	int maxValue(int[] arr) {
		int max_value = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] > max_value)
				max_value = arr[i];
		return max_value;
	}

}
