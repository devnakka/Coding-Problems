package com.devnakka.codingproblems.problem2;

import java.util.Arrays;

/**
 * This problem was asked by Uber.
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * Follow-up: what if you can't use division?
 */
public class Solution1 {
	public static void main(String[] args) {
		int[] inputArray = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(solution(inputArray)));
	}

	/**
	 * To solve this problem in O(N).
	 * 1. Create prefix array like [1, 2, 6, 24, 120]
	 * 2. Create suffix array like [120, 120, 60, 20, 5]
	 * 3. Then combine prefix and suffix by excluding current position value
	 * @param inputArray
	 * @return
	 */
	private static int[] solution(int[] inputArray) {

		int[] prefix = new int[inputArray.length];
		boolean prefixFlag = false;
		for (int i=0; i < inputArray.length; i++) {
			if(prefixFlag) {
				prefix[i] = prefix[i - 1] * inputArray[i];
			} else {
				prefixFlag = true;
				prefix[i] = inputArray[i];
			}
		}

		int[] suffix = new int[inputArray.length];
		boolean suffixFlag = false;
		for (int i= inputArray.length - 1 ; i >= 0; i--) {
			if(suffixFlag) {
				suffix[i] = suffix[i + 1] * inputArray[i];
			} else {
				suffixFlag = true;
				suffix[i] = inputArray[i];
			}
		}

		int[] result = new int[inputArray.length];
		for (int i=0; i < inputArray.length; i++) {

			if (i == 0) {
				result[i] = suffix[i + 1];
			} else if (i == inputArray.length - 1) {
				result[i] = prefix[i - 1];
			} else {
				result[i] = prefix[i - 1] * suffix[i + 1];
			}
		}
		return result;
	}

}
