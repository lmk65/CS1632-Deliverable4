import static org.junit.Assert.*;

import org.junit.*;
import java.util.*;

public class SortingArraysTest {

	//Generates 100 arrays of various sizes (up to 500) containing integers between 0 and 500
		public static int[][] generateRandomArrays() {
			Random rand = new Random();
			int[][] randomArrays = new int[100][];

			for(int i = 0; i < 100; i++) {
				int arraySize = rand.nextInt(500);  
				randomArrays[i] = new int[arraySize];

				for(int j = 0; j < arraySize; j++) {
					randomArrays[i][j] =  rand.nextInt(500);
				}

			}

			return randomArrays;
		}

	//Given an array of any size, if I sort that array, the final sorted array should contain all elements found in the unsorted array
	@Test
	public void testComposition () {
		int[][] randomArrays = generateRandomArrays();
		
		for(int i = 0; i < randomArrays.length; i++) {	
			int[] testArray = randomArrays[i];
			int[] copiedArray = new int[testArray.length];
			
			System.arraycopy(testArray, 0, copiedArray, 0, testArray.length);
			
			Arrays.sort(testArray);
			
			for(int j = 0; j < copiedArray.length; j++) {
				if(Arrays.binarySearch(testArray, copiedArray[j]) < 0) {
					fail("testComposition");
				}
			}
		}
	}
	
	//Given an array of any size, if I sort that array, the final sorted array should be the same size as the unsorted array
	@Test
	public void testSize() {
		int[][] randomArrays = generateRandomArrays();
		
		for(int i = 0; i < randomArrays.length; i++) {
			int[] testArray = randomArrays[i];
			int[] copiedArray = new int[testArray.length];
	
			System.arraycopy(testArray, 0, copiedArray, 0, testArray.length);
			
			Arrays.sort(testArray);
	
			assertEquals(testArray.length, copiedArray.length);
		}
	}

	//Given an array of any size, if I sort that array, the element that follows the element before it should always be greater than or equal to it
	@Test
	public void testSort() {
		int[][] randomArrays = generateRandomArrays();
		
		for(int i = 0; i < randomArrays.length; i++) {
			int[] testArray = randomArrays[i];
			
			Arrays.sort(testArray);

			for (int j = 0; j < testArray.length-1; j++) {
				if (testArray[j] > testArray[j+1]) {
					fail("testSort");
				}
			}
		}
	}

	//Given an array of any size, sorting the sorted version of that array should yield no change (i.e. a sorted array that is sorted should be the same before and after)
	@Test
	public void testSortingSorted() {
		int[][] randomArrays = generateRandomArrays();
		
		// loop through all arrays
		for(int i = 0; i < randomArrays.length; i++) {
			int[] testArray = randomArrays[i];
			int[] sortedArray = new int[testArray.length];
			int[] sortedArraySorted = new int[testArray.length];
	
			Arrays.sort(testArray);
			
			System.arraycopy(testArray, 0, sortedArray, 0, testArray.length);
			
			System.arraycopy(sortedArray, 0, sortedArraySorted, 0, testArray.length);
			
			Arrays.sort(sortedArraySorted);
			
			
			assertArrayEquals(sortedArray, sortedArraySorted);
		}
	}

	//Given an array of any size, the sorting of that array should always yield the same result
	@Test
	public void testSameResult () {
		int[][] randomArrays = generateRandomArrays();
		
		for(int i = 0; i < randomArrays.length; i++) {
			int[] testArray = randomArrays[i];
			int[] copiedArray = new int[testArray.length];
			
			System.arraycopy(testArray, 0, copiedArray, 0, testArray.length);
			
			Arrays.sort(testArray);
			Arrays.sort(copiedArray);
			
			
			assertArrayEquals(testArray, copiedArray);
		}
	}
}

