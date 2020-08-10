package com.devnakka.codingproblems.problem4;

/**
 * This problem was asked by Stripe.
 * Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *
 * You can modify the input array in-place.
 */
public class Solution1 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 0, 1, 37, 6, -5, -1, 0, 2, 4})); // output 5
	}

	private static int solution(int[] inputArray) {
		if (inputArray == null || inputArray.length == 0)
			return 0;

		for (int i = 0; i < inputArray.length; i++) {
			while (inputArray[i] > 0 && inputArray[i] <= inputArray.length && inputArray[i] != (i+1)) {
				int v = inputArray[i];
				inputArray[i] = inputArray[v-1];
				inputArray[v-1] = v;
			}
		}

		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] != (i+1)) {
				return (i+1);
			}
		}
		return 0;
	}
}
