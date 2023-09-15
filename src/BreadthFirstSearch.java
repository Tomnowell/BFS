package BFS;
import java.util.Iterator;
import java.util.Stack;


/**
 * @author tom
 *
 */
public class BreadthFirstSearch {

    /**
     * @param args
     */
    BFS.Problem problem;
    /* Keep track of nodes explored */
    Stack<Node> reached = new Stack<Node>();
    Node startNode;
    Frontier frontier = new Frontier();

    public BreadthFirstSearch(BFS.Problem problem) {
        this.problem = problem;
        this.startNode = new Node(null, this.problem.initialState, 1);

        System.out.println(startNode);
        frontier.add(startNode);

        Node finalState = this.search();

    }

    public Node search() {
        if (problem.isGoalState(startNode.getState())) {
            return this.startNode;
        }
        System.out.println(frontier.size());


        Node node = new Node();


        frontier.forEach((n) -> {
            System.out.println(n);
        });
		/*
		while (!this.reached.isEmpty()) {
			node = frontier.pop();
		}
		*/
        return node;
    }

    public static void main(String[] args){
        BFS.Problem problem = new BFS.Problem();
        BreadthFirstSearch bfs = new BreadthFirstSearch(problem);
    }


    public void expand(BFS.Problem problem, Node node) {
        State state = node.getState();
		/*forEach action in problem.actions(s)
		s0 problem.RESULT(s, action)
		cost node.PATH-COST + problem.ACTION-COST(s, action, s0)
		yield NODE(STATE=s0, PARENT=node, ACTION=action, PATH-COST=cost)

		return new Node(null, null, 0, 'Error');
		*/
    }
}