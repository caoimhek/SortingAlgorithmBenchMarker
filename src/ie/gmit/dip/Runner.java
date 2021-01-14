package ie.gmit.dip;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Runner {

	private static List<BenchMarker.Result> BenchMarkRandom(BenchMarker bm, int arraySize) 
	{
		int[] randomInput = randomArray(arraySize);
		List<BenchMarker.Result> results = bm.Run(randomInput, 10);
		return results;
	}
	
	public static void main(String[] args) {

		BenchMarker bm = new BenchMarker();
		List<BenchMarker.Result> results = new ArrayList<BenchMarker.Result>(14);

		// 100
		results.addAll(BenchMarkRandom(bm, 100));

		// 250
		results.addAll(BenchMarkRandom(bm, 250));

		// 500
		results.addAll(BenchMarkRandom(bm, 500));

		// 750
		results.addAll(BenchMarkRandom(bm, 750));
		
		// 1000
		results.addAll(BenchMarkRandom(bm, 1000));

		// 1250
		results.addAll(BenchMarkRandom(bm, 1250));

		// 2500
		results.addAll(BenchMarkRandom(bm, 2500));
		
		// 3750
		results.addAll(BenchMarkRandom(bm, 3750));

		// 5000
		results.addAll(BenchMarkRandom(bm, 5000));

		// 6250
		results.addAll(BenchMarkRandom(bm, 6250));

		// 7500
		results.addAll(BenchMarkRandom(bm, 7500));

		// 8750
		results.addAll(BenchMarkRandom(bm, 8750));

		// 10000
		results.addAll(BenchMarkRandom(bm, 10000));
		
		for(BenchMarker.Result result : results) {
			System.out.println(result.getName() + " " + result.getInputSize() + " " + result.getTime());
		}
	}
	
	
	// Code to generate random input instances
	static int [] randomArray (int n) {
		int [] array = new int [n];
		for (int i = 0; i < n; i++)
		{
			array [i] = (int) (Math.random () * 100);
		}
		return array;
	}
}
