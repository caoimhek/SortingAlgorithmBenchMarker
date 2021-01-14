package ie.gmit.dip;

import java.util.Arrays;

public class RadixSort implements ISortingAlgorithm {

	@Override
	public void Execute(int[] input) {
		radixSort(input);
		
	}

	@Override
	public String GetName() {
		return "RadixSort";
	}

	// Radix Sort
	// https://www.javatpoint.com/radix-sort
     
	
    // this returns the largest value in an int array.
	public int largest(int a[]) {
		int larger = a[0], i;
		for (i = 1; i < a.length; i++) {
			if (a[i] > larger)
				larger = a[i];
		}
		return larger;
	}

	public void radixSort(int a[]) {
		int bucket[][] = new int[10][a.length];
		int bucket_count[] = new int[10];
		int i, j, k, remainder, NOP = 0, divisor = 1, larger, pass; 
		// find the largest number in the input array
		larger = largest(a);
		//calculate the number of passes as the number of digits in the largest number .
		while (larger > 0) {
			NOP++;
			larger /= 10;
		}
		//perform as many passes as the number of digits in the largest number 
		for (pass = 0; pass < NOP; pass++) 
		{
			// Reinitialize the bucket count 
			for (i = 0; i < bucket_count.length; i++)
				bucket_count[i] = 0;
			//assign each number of the input into a bucket 
			for (i = 0; i < a.length; i++) {
				// extract the digit of the number 
				remainder = (a[i] / divisor) % 10;
				//assign the number to a bucket that contains numbers with the same digit 
				bucket[remainder][bucket_count[remainder]] = a[i];
				bucket_count[remainder] += 1;
			}
			// for each decimal digit value (sorted by definition)
			i = 0;
			for (k = 0; k < 10; k++) {
				// for each bucket that corresponds to that digit value  
				// the bucket is written to the output.
				for (j = 0; j < bucket_count[k]; j++) {
					a[i] = bucket[k][j];
					i++;
				}
			}
			//update the digit to be extracted.
			divisor *= 10;
		}
	}

}
