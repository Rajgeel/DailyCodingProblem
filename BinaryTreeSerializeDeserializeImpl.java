class BinaryTreeSerializeDeserializeImpl {

	Node root;
	
	public static class Node {

		int val;
		Node left;
		Node right;

		Node(int val) {

			this.val = val;
			left = null;
			right = null;
		}
	}


	 public String serialize(Node node) {
        if (node == null) {
            return "null,";
        }
 
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append(",");
 
        sb.append(serialize(node.left));
        sb.append(serialize(node.right));
        return sb.toString();
    }

    public Node deserialize(String s) {

        String[] temp = s.split(",");
     
        return deserializeUtil(temp);
    }

    int index = 0;
    Node deserializeUtil(String[] data) {
        if (index > data.length || data[index].equals("null")) {
            index++;
            return null;
        }
 
        Node node = new Node(Integer.parseInt(data[index++]));
        node.left = deserializeUtil(data);
        node.right = deserializeUtil(data);
 
        return node;
    }




	void printString(String s) {

		int size = s.length();

		for(int i=0; i<size; i++) {

			System.out.print(s.charAt(i));
		}
	}

	void printNode(Node node) {

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);

		while(!q.isEmpty()) {

			Node temp = q.peek();
			q.remove();

			if(temp != null) {

				System.out.print(temp.val + " ");

				if(temp.left != null) {
					q.add(temp.left);
				}

				if(temp.right != null) {
					q.add(temp.right);
				}
			}
		}
	}

	public static void main(String... s) {

	BinaryTreeSerializeDeserializeImpl obj = new BinaryTreeSerializeDeserializeImpl();

	obj.root = new Node(1);
        obj.root.left = new Node(2);
        obj.root.left.left = new Node(3);
        obj.root.right = new Node(4);
        obj.root.right.left = new Node(5);
        obj.root.right.right = new Node(6);


        String ansSerialize = obj.serialize(obj.root);
        obj.printString(ansSerialize);

        System.out.println("\n");

        Node ansDeserialize = obj.deserialize(ansSerialize);
        obj.printNode(ansDeserialize);

	}
}
