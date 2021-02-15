// Implement a queue using two stacks. Recall that a queue is a FIFO (first-in, first-out) data structure with the following methods: 
// enqueue, which inserts an element into the queue, and dequeue, which removes it.


// Time Complexity of push operation is O(1) and pop operation is O(n) and space complexity is O(n).
import java.util.Stack; 

class ImplementQueueUsingTwoStacks {

	static class Queue { 

        Stack<Integer> stack1; 
        Stack<Integer> stack2; 
    } 
  
    void push(Stack<Integer> top_ref, int new_data) { 

        top_ref.push(new_data); 
    } 
  
    int pop(Stack<Integer> top_ref) {

        if (top_ref.isEmpty()) {

            System.out.println("Stack Underflow"); 
            System.exit(0); 
        } 

        return top_ref.pop(); 
    } 
  
    void enQueue(Queue q, int x) {

        push(q.stack1, x); 
    } 

    int deQueue(Queue q) { 
        int x; 

        if (q.stack1.isEmpty() && q.stack2.isEmpty()) { 

            System.out.println("Q is empty"); 
            System.exit(0); 
        } 

        if (q.stack2.isEmpty()) { 

            while (!q.stack1.isEmpty()) { 

                x = pop(q.stack1); 
                push(q.stack2, x); 
            } 
        } 

        x = pop(q.stack2); 

        return x; 
    } 

    public static void main(String args[]) {

    	ImplementQueueUsingTwoStacks obj = new ImplementQueueUsingTwoStacks();

        Queue q = new Queue(); 

        q.stack1 = new Stack<>(); 
        q.stack2 = new Stack<>(); 

        obj.enQueue(q, 1); 
        obj.enQueue(q, 2); 
        obj.enQueue(q, 3); 
  
        System.out.print(obj.deQueue(q) + " "); 
        System.out.print(obj.deQueue(q) + " "); 
        System.out.println(obj.deQueue(q) + " "); 
    } 
}