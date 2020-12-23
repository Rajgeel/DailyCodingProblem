/*
A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.
*/


//Time complexity is O(n) and space complexity is O(1)
class UniValBinaryTree {

	int count = 0;
	Node root;
	
	static class Node {

		int data;
		Node left;
		Node right;

		Node(int data) {

			this.data = data;
			left = null;
			right = null;
		}

	}

	public boolean recur(Node node) {

		if(node == null) {
			return true;
		}

		boolean left = recur(node.left);
		boolean right = recur(node.right);

		if(left == false || right == false) {
			return false;
		}

		if(node.left != null && node.data != node.left.data) {
			return false;
		}

		if(node.right != null && node.data != node.right.data) {
			return false;
		}

		count++;

		return true;

	}

	public static void main(String... s) {

		UniValBinaryTree obj = new UniValBinaryTree();

		obj.root = new Node(0); 
		obj.root.left = new Node(1); 
		obj.root.right = new Node(0); 
		obj.root.right.left = new Node(1); 
		obj.root.right.right = new Node(0); 
		obj.root.right.left.left = new Node(1);
		obj.root.right.left.right= new Node(1);

		obj.recur(obj.root);

		System.out.print(obj.count);    

	}
}
