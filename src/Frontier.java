package BFS;

import java.util.LinkedList;

/**
 * @author tom
 *
 */
public class Frontier<Node> extends LinkedList<Node> {

    Frontier() {
        super();
    }

    // Establish a FIFO queue
    // LinkedList<Node> frontier = new LinkedList<Node>();

    public boolean isEmpty() {
        return this.peek() == null;
    }

    public Node pop() {
        // Return the top of the queue AND remove
        return this.poll();
    }

    public Node top() {
        // Return the top of the queue but do not remove
        return this.element();
    }
    // add is the same as the LinkedList
}
