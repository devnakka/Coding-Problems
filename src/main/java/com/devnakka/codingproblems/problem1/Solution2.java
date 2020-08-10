package com.devnakka.codingproblems.problem1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This problem was recently asked by Google.
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */
public class Solution2 {

	public static void main(String[] args) {
		int[] numberArray = {10, 12, 15, 3, 7};
		int k = 19;
		System.out.println(solution(numberArray, k));
	}

	private static boolean solution(int[] inputArray, int k) {
		if (inputArray == null || inputArray.length == 0 || k <= 0)
			return false;

		Arrays.sort(inputArray); // [3, 7, 10, 12 ,15]  -- O(N)

		for (int i = 0; i < inputArray.length; i++) {
			 int target = k - inputArray[i];

			 int targetIndex = binarySearch(inputArray, 0, inputArray.length - 1, target);

			 if (targetIndex == -1)
			 	continue;
			 else if (targetIndex != i)
			 	return true;
			 else if (targetIndex + 1 < inputArray.length && inputArray[targetIndex + 1] == target)
			 	return true;
			 else if (targetIndex - 1 >= 0 && inputArray[targetIndex - 1] == target)
			 	return true;
		}
		return false;
	}

	// Returns index of x if it is present in arr[l, r], else return -1
	private static int binarySearch(int arr[], int l, int r, int x)
	{
		if (r >= l) {
			int mid = l + (r - l) / 2;

			// If the element is present at the
			// middle itself
			if (arr[mid] == x)
				return mid;

			// If element is smaller than mid, then
			// it can only be present in left subarray
			if (arr[mid] > x)
				return binarySearch(arr, l, mid - 1, x);

			// Else the element can only be present
			// in right subarray
			return binarySearch(arr, mid + 1, r, x);
		}

		// We reach here when element is not present
		// in array
		return -1;
	}
}
