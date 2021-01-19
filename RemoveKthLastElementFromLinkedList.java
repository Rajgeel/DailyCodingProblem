// Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.

// The list is very long, so making more than one pass is prohibitively expensive.

// Do this in constant space and in one pass.




import java.util.Scanner;



// Time complexity is O(n) and space complexity is O(1).
class RemoveKthLastElementFromLinkedList {


	Node root = null;
	Node head = null;

	static class Node {

		int data;
		Node next;

		Node(int data) {

			this.data = data;
			next = null;
		}
	}


	void insertNode(int data) {

		if(root == null) {

			root = new Node(data);
			head = root;

			return;
		}

		this.head.next = new Node(data);

		this.head = this.head.next;
	}


	int countNode(Node node) {

		Node temp = node;

		int count = 0;

		while(temp != null) {

			count++;
			temp = temp.next;
		}

		return count;
	}


	Node solution(Node node, int k) {

		int flag = countNode(node) - k -1;

		Node temp = node;

		while(flag > 0) {

			temp = temp.next;
			flag--;
		}

		temp.next = temp.next.next;

		return node;
	}


	void print(Node node) {

		Node temp = node;

		while(temp != null) {

			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	
	public static void main(String... s) {
		
		RemoveKthLastElementFromLinkedList obj = new RemoveKthLastElementFromLinkedList();
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		for(int i=0; i<size; i++) {

			obj.insertNode(sc.nextInt());
		}

		obj.print(obj.root);

		int k = sc.nextInt();

		obj.solution(obj.root, k);

		obj.print(obj.root);


	}
}