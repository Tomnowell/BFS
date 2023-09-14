package BFS; /**
 * 
 */

/**
 * @author tom
 *
 */
public class State {
	/*
	*	Instance Variables
	 */
	boolean dirtLeft;
	boolean dirtRight;
	char position;

	/*
	*	Constructors
	 */
	public State(boolean dirtLeft, boolean dirtRight, char position) {
		this.dirtLeft = dirtLeft;
		this.dirtRight = dirtRight;
		this.position = position;
	}

	/*
	*	Getters
	*/
	public boolean isDirtLeft() {
		return dirtLeft;
	}
	public boolean isDirtRight() {
		return dirtRight;
	}
	public char getPosition() {
		return position;
	}
	/*
	*	Setters
	 */
	public void setDirtLeft(boolean dirtLeft) {
		this.dirtLeft = dirtLeft;
	}

	public void setDirtRight(boolean dirtRight) {
		this.dirtRight = dirtRight;
	}

	public void setPosition(char position) {
		this.position = position;
	}

	// Do this in the Problem class transition model
	public State suck() {
		if (this.position == 'R') {
			return new State(this.dirtLeft, false, 'R');
		} else {
			return new State(false, this.dirtRight, 'L');
		}
	}
	
	/*	Implement the move action transition model return a new state
	*	based on the current state and the action performed.	
	*/
	public State goLeft() {
		return new State(this.dirtLeft, this.dirtRight, 'L');
	}
	
	public State goRight() {
		return new State(this.dirtLeft, this.dirtRight, 'R');
	}
	
		
		
	
	
}
