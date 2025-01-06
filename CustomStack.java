/*
 * Custom Stack implementation for DFS
 * 
 * @variables:
    * top: The index of the top element in the stack
    * stack: An array to store the elements of the stack
    * capacity: The maximum capacity of the stack
 *
 * @methods:
    * CustomStack(int capacity): Constructor to initialize the stack with a given capacity
    * push(Vertex vertex): Method to push a vertex onto the stack
    * pop(): Method to pop a vertex from the stack
    * peek(): Method to peek the top element of the stack
    * isEmpty(): Method to check if the stack is empty
 */

class CustomStack {
    private int top;
    private Vertex[] stack;
    private int capacity;

    public CustomStack(int capacity) {
        this.capacity = capacity;
        this.stack = new Vertex[capacity];
        this.top = -1;
    }

    public void push(Vertex vertex) {
        if (top == capacity - 1) {
            System.out.println("Stack overflow");
            return;
        }
        stack[++top] = vertex;
    }

    public Vertex pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return null;
        }
        return stack[top--];
    }

    public Vertex peek() {
        if (isEmpty()) {
            return null;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
