// Given the root to a binary search tree, find the second largest node in the tree.



// Time complexity is O(logn) and space complexity is O(1).
class SecondLargestNodeInBST {

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


	void insertNode(int data){

		this.root = this.insertNodeUtil(this.root, data);
	}

	Node insertNodeUtil(Node node, int data) {

		if (node == null) { 

            this.root = new Node(data); 
            return this.root; 
        }

        if(data < node.data){

        	node.left = this.insertNodeUtil(node.left, data);
        }
        else{

        	node.right = this.insertNodeUtil(node.right, data);
        }


        return node;
	}




	int solution(Node node) {

		Node temp = node;
		Node prev = null;

		while(temp.right != null) {

			prev = temp;
			temp = temp.right;
		}

		if(temp.left != null) {

			return temp.left.data;
		}

		return prev.data;
	}
	
	public static void main(String... s) {

		SecondLargestNodeInBST obj = new SecondLargestNodeInBST();

		
		obj.insertNode(50); 
        obj.insertNode(30); 
        obj.insertNode(20); 
        obj.insertNode(40); 
        obj.insertNode(70); 
        obj.insertNode(60); 
        obj.insertNode(80); 

        System.out.println(obj.solution(obj.root));

	}
}