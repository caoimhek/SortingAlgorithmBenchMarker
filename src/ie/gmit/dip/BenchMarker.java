package ie.gmit.dip;

import java.util.ArrayList;
import java.util.List; 

public class BenchMarker {

	private long startTime;

	private BubbleSort bubbleSort = new BubbleSort();
	private QuickSort quickSort = new QuickSort();
	private BucketSort bucketSort = new BucketSort();
	private RadixSort radixSort = new RadixSort();
	private HeapSort heapSort = new HeapSort();

	private void ResetTimer() {
		this.startTime = System.nanoTime();
	}

	private double GetTimeElapsed() {
		long endTime = System.nanoTime();
		long timeElapsedNanos = endTime - startTime;
		double timeElapsedMillis = timeElapsedNanos / 1000000.0;

		return timeElapsedMillis;
	}

	private double GetAverageExecutionTime(ISortingAlgorithm algorithm, int[] input, int repeats) {
		
		double counter = 0.0;
		
		for(int executions = 0; executions < repeats; executions++) 
		{
			int[] inputCopy = input.clone();
			counter += GetExecutionTime(algorithm, inputCopy);
		}
		
		double average = counter / repeats;
		
		return average;
	}
	
	private double GetExecutionTime(ISortingAlgorithm algorithm, int[] input) {
		
		ResetTimer();
		algorithm.Execute(input);
		double elpasedTime = GetTimeElapsed();
		
		return elpasedTime;
	}
	
	public List<Result> Run(int[] input, int repeats) {
		List<Result> result = new ArrayList<Result>();
		
		// BubbleSort
		result.add(new Result(bubbleSort, input, GetAverageExecutionTime(this.bubbleSort, input, repeats)));
		
		// QuickSort
		result.add(new Result(quickSort, input, GetAverageExecutionTime(this.quickSort, input, repeats)));

		// BucketSort
		result.add(new Result(bucketSort, input, GetAverageExecutionTime(this.bucketSort, input, repeats)));

		// RadixSort
		result.add(new Result(radixSort, input, GetAverageExecutionTime(this.radixSort, input, repeats)));

		// HeapSort
		result.add(new Result(heapSort, input, GetAverageExecutionTime(this.heapSort, input, repeats)));
		
		return result;

	}
	
	public class Result{
		private Double time;
		private ISortingAlgorithm algorithm;
		private int[] input;
		
		public Result(ISortingAlgorithm algorithm, int[] input, Double time ) {
			this.algorithm = algorithm;
			this.time = time;
			this.input = input;
		}

		public Double getTime() {
			return time;
		}

		public String getName() {
			return algorithm.GetName();
		}

		public int getInputSize() {
			return input.length;
		}
	}

}



