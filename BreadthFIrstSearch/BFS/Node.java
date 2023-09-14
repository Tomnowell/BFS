/**
 * 
 */
package BFS; /**
/**
 * @author tom
 *
 */
public class Node {

	/*
	 * @param args
	 	state the state to which the node corresponds;
	parent: 	the node in the tree that generated this node
	action: 	the action that was applied to the parent’s state 
				to generate this node;
	pathCost: 	the total cost of the path from the initial state to 
				this node */

	State state;
	Node parent;
	String action;

	int pathCost;
	
	public Node(){
		this.setState(null);
		this.setParent(null);
		this.setAction(null);
		this.pathCost = 0;
	}
	public Node(State state, int pathCost) {
		
		/*
		 * Constructor for Node with no parent and no action
		 */
		this.setState(state);
		this.addPathCost(pathCost);
	}
	public Node(Node parent, State state, int pathCost) {
		
		/**
		 * Constructor for Node with parent no action
		 */
		this.setParent(parent);
		this.setState(state);
		this.addPathCost(pathCost);
	}
	
	public Node(Node parent, State state, String action, int pathCost) {

		/*
		 * Constructor for Node with parent no action
		 */
		this.setParent(parent);
		this.setState(state);
		this.setAction(action);
		this.addPathCost(pathCost);
	}
	public void setParent(Node node) {
		this.parent = node;
	}
	public void setState(State state) {
		this.state = state;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public void addPathCost(int cost) {
		this.pathCost += cost;
	}
	
	public State getState() {
		return this.state;
	}
	
		
		
		
		



}
