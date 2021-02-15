// Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.

// Given the root to such a tree, write a function to evaluate it.

// For example, given the following tree:

//     *
//    / \
//   +    +
//  / \  / \
// 3  2  4  5
// You should return 45, as it is (3 + 2) * (4 + 5).


import java.util.function.BiFunction;


class EvaluateValueThroughArithmeticExpressionInBinaryTree {

    private Node create() {

        ValueNode node2 = new ValueNode(2);
        ValueNode node3 = new ValueNode(3);
        ValueNode node4 = new ValueNode(4);
        ValueNode node5 = new ValueNode(5);

        BiFunction<Double, Double, Double> add = (one, two) -> one + two;
        BiFunction<Double, Double, Double> multiply = (one, two) -> one * two;

        OperationNode addLeft = new OperationNode(add, node3, node2);
        OperationNode addRight = new OperationNode(add, node4, node5);

        return new OperationNode(multiply, addLeft, addRight);
    }

    public double calc(Node node) {

        if (node instanceof ValueNode) {

            return ((ValueNode)node).val;
        }

        double left = calc(((OperationNode)node).left);
        double right = calc(((OperationNode)node).right);

        return ((OperationNode)node).function.apply(left, right);
    }

    public interface Node {
    }

    public static class OperationNode implements Node {

        private final BiFunction<Double, Double, Double> function;
        private final Node left;
        private final Node right;

        public OperationNode(BiFunction<Double, Double, Double> function, Node left, Node right) {
            this.function = function;
            this.left = left;
            this.right = right;
        }
    }

    public static class ValueNode implements Node {

        private final double val;

        public ValueNode(double val) {
            this.val = val;
        }
    }

    public static void main(String... args) {

    	EvaluateValueThroughArithmeticExpressionInBinaryTree obj = new EvaluateValueThroughArithmeticExpressionInBinaryTree();

        System.out.println(obj.calc(obj.create()));
    }
}