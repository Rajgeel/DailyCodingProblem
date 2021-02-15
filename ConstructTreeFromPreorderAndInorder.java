// Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.

// For example, given the following preorder traversal:

// [a, b, d, e, c, f, g]

// And the following inorder traversal:

// [d, b, e, a, f, c, g]

// You should return the following tree:

//     a
//    / \
//   b   c
//  / \ / \
// d  e f  g



import java.util.ArrayList;


// Time complexity is O(n^2) and space complexity is O(1).
class ConstructTreeFromPreorderAndInorder {
	
	int trav = 0;

	class TreeNode {

    	char val;
    	TreeNode left;
    	TreeNode right;

    	TreeNode(char x) {
	    	val = x;
	        left=null;
	        right=null;
    	}
  	}

    public TreeNode buildTree(ArrayList<Character> A, ArrayList<Character> B) {

        if(A.size() == 0) {
            return null;
        }

        trav = 0;

        return constructBT(B, A, 0, B.size()-1);
    }
    
    public TreeNode constructBT(ArrayList<Character> A, ArrayList<Character> B, int s, int e) {

        if(s > e) {
            return null;
        }
        
        if(trav == B.size()) {
            return null;
        }
        
        TreeNode node = new TreeNode(B.get(trav++));

        if(s == e) {
            return node;
        }

        int indx = getIndex(A, s, e, node.val);
        
        node.left = constructBT(A, B, s, indx-1);
        node.right = constructBT(A, B, indx+1, e);
        
        return node;
    }
    
    public int getIndex(ArrayList<Character> A, int s, int e, int item) {

        for(int i=s; i<=e; i++) {

            if(A.get(i) == item) {
                return i;
            }
        }
        return -1;
    }

     void printInorder(TreeNode node) {

        if (node == null)
            return;

        printInorder(node.left);
 
        System.out.print(node.val + " ");
 
        printInorder(node.right);
    }

    public static void main(String[] args) {
    	
    	ConstructTreeFromPreorderAndInorder obj = new ConstructTreeFromPreorderAndInorder();

    	ArrayList<Character> inorder = new ArrayList<Character>();
    	inorder.add('d');
    	inorder.add('b');
    	inorder.add('e');
    	inorder.add('a');
    	inorder.add('f');
    	inorder.add('c');
    	inorder.add('g');

    	ArrayList<Character> preorder = new ArrayList<Character>();
    	preorder.add('a');
    	preorder.add('b');
    	preorder.add('d');
    	preorder.add('e');
    	preorder.add('c');
    	preorder.add('f');
    	preorder.add('g');

    	TreeNode root = obj.buildTree(preorder, inorder);
    	obj.printInorder(root);

    }
}