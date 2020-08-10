package com.devnakka.codingproblems.problem3;

import java.text.MessageFormat;

/**
 * This problem was asked by Google.
 * Given the root to a binary tree, implement serialize(root), which serializes the
 * tree into a string, and deserialize(s), which deserializes the string back into the
 * tree.
 */
public class Solution1 {

	static int rootPos = -1;

	public static void main(String[] args) {
		String serializeNode = serialize(new Node("1", new Node("2"), new Node("3")));

		System.out.println(serializeNode);
		Node generatedNode = deserialize(serializeNode.split(" "));
		System.out.println(generatedNode);
	}

	private static String serialize(Node root) {
		if (root == null) {
			return "#";
		}
		return MessageFormat.format("{0} {1} {2}",root.val, serialize(root.left), serialize(root.right));
	}

	private static Node deserialize(String[] treeNodes) {
		rootPos++;
		if (treeNodes[rootPos].equals("#")) {
			return null;
		}
		return new Node(treeNodes[rootPos], deserialize(treeNodes), deserialize(treeNodes));
	}

}
