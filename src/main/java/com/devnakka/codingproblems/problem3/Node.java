package com.devnakka.codingproblems.problem3;

public class Node {
	String val;
	Node left, right;

	public Node(String val) {
		this.val = val;
	}

	public Node(String val, Node left, Node right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node{" +
				"val='" + val + '\'' +
				", left=" + left +
				", right=" + right +
				'}';
	}
}
