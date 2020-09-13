package com.devnakka.codingproblems.problem5;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * This problem was asked by Jane Street.
 * cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and
 * last element of that pair. For example, car(cons(3, 4)) returns 3, and
 * cdr(cons(3, 4)) returns 4.
 */

public class Solution1 {

	public static void main(String[] args) {
		System.out.println(car(cons(1,3))); // 1
		System.out.println(cdr(cons(1,3))); // 3
	}

	public static <T,U,R> Function<BiFunction<T,U,R>,R> cons(T a, U b) {
		Function<BiFunction<T,U,R>,R> pair = f -> f.apply(a,b);
		return pair;
	}

	public static <T,U> T car(Function<BiFunction<T,U,T>,T> cons) {
		return cons.apply((a,b) -> a);
	}

	public static <T,U> U cdr(Function<BiFunction<T,U,U>,U> cons) {
		return cons.apply((a,b) -> b);
	}

}
