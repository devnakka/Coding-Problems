package com.devnakka.codingproblems.problem1;

import java.util.HashSet;
import java.util.Set;

/**
 * This problem was recently asked by Google.
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */
public class Solution1 {

	public static void main(String[] args) {
		int[] numberArray = {10, 12, 15, 3, 7};
		int number = 19;
		System.out.println(solution(numberArray, number));
	}

	static boolean solution(int[] inputArray, int k) {
		if (inputArray == null || inputArray.length == 0 || k <= 0)
			return false;

		Set<Integer> scannedNumbers = new HashSet<>();

		for (int number: inputArray) {
			if (scannedNumbers.contains(k - number)) {
				return true;
			} else {
				scannedNumbers.add(number);
			}
		}
		return false;
	}
}
