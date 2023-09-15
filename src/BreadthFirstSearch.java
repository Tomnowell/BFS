import java.util.ArrayList;
import java.util.Stack;
/**
 * @author tom
 *  The base class and main function
 */
public class BreadthFirstSearch {
    Problem problem;
    /* Keep track of nodes explored */
    Stack<State> reached = new Stack<>();
    Node startNode;
    Frontier<Node> frontier = new Frontier<>();

    public BreadthFirstSearch(Problem problem) {
        this.problem = problem;
        this.startNode = new Node(null, problem.getInitialState(), 1);

        this.frontier.add(startNode);

        Node finalState = this.search();

        System.out.println("Reached a goal state: " + finalState);

    }

    public Node search() {
        if (Problem.isGoalState(startNode.getState())) {
            return this.startNode;
        }
        System.out.println("Beginning the search...");

        Node node = new Node();

        this.frontier.forEach(System.out::println);
		while (!this.frontier.isEmpty()) {
			node = this.frontier.pop();
            // expand
            ArrayList<Node> expanded = expand(node);
            for (Node testNode: expanded) {
                if (Problem.isGoalState((testNode.getState()))){
                    return testNode;
                }
            }
            frontier.addAll(expanded);
            // System.out.println(frontier);
		}
        return node;
    }

    public ArrayList<Node> expand(Node node) {
        ArrayList<Node> yield = new ArrayList<>();
        State state = node.getState();
        System.out.println("Expanding... current state: " + state);
        ArrayList<State> possibleStates = Problem.actions(state);

        possibleStates.forEach(possible -> {
            if (!reached.contains(possible)) {
                reached.add(possible);
                Node newNode = new Node(node, possible, 1);
                System.out.println("New node : " + newNode);
                yield.add(newNode);

            }
        });
        return yield;
    }

    public static void main(String[] args){
        Problem problem = new Problem();
        BreadthFirstSearch bfs = new BreadthFirstSearch(problem);
    }
}