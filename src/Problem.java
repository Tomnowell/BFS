import java.util.ArrayList;
import java.util.List;

/**
 * @author tom
 *  Defines the problem space, actions and transition model
 */
public class Problem {
    ArrayList<State> states = new ArrayList<>();

    // State to keep initial state
    State initialState;

    // Keep track of solution cost
    static int totalCost = 0;
    public Problem() {
        this.defineAllStates();
        this.initialState = states.get(0);
        System.out.println("All possible states :");
        states.forEach(System.out::println);
    }
    // Define goal states
    public static boolean isGoalState(State state) {
        return !state.dirtLeft && !state.dirtRight;
    }
    // Define actions
    public static ArrayList<State> actions(State state) {
        ArrayList<State> actions = new ArrayList<>();
        if (state.position == 'L') {
            actions.add(goRight(state));
        }
        if (state.position == 'R') {
            actions.add(goLeft(state));
        }
        if (state.position == 'L' && state.isDirtLeft()) {
            actions.add(suck(state));
        }
        if (state.position == 'R' && state.isDirtRight()) {
            actions.add(suck(state));
        }
        return actions;

    }


    public ArrayList<State> getStates() {
        return this.states;
    }
    public static int costFunction(){
        return 1; // This can be changed to simulate different costs of actions
    }
    public State getInitialState() {
        return initialState;
    }

    /*
     *	Transition model should return a state depending on a passed state and action
     */
    public static State goRight(State state){
        if (state.getPosition() == 'L'){
            totalCost += costFunction(); // Add the cost of the action to total
            return new State(state.isDirtLeft(), state.isDirtRight(), 'R');
        }else{
            throw new IndexOutOfBoundsException(); // Already at Right
        }
    }

    public static State goLeft(State state){
        if (state.getPosition() == 'R'){
            totalCost += costFunction(); // Add the cost of the action to total
            return new State(state.isDirtLeft(), state.isDirtRight(), 'L');
        }else{
            throw new IndexOutOfBoundsException(); // Already at Left
        }
    }

    public static State suck(State state){
        if (state.getPosition() == 'L'){
            if (state.isDirtLeft()){
                totalCost += costFunction(); // Add the cost of the action to total
                return new State(false, state.isDirtRight(),'L');
            }else{
                throw new IndexOutOfBoundsException(); // Already clean
            }
        }else{
            if (state.isDirtRight()){
                totalCost += costFunction(); // Add the cost of the action to total
                return new State(state.isDirtLeft(), false,'R');
            }else{
                throw new IndexOutOfBoundsException();
            }

        }
    }
    private void defineAllStates(){
        // This is so messy!! I don't like it!
        this.states.add(new State(true, true, 'L'));
        this.states.add(new State(true, true, 'R'));
        this.states.add(new State(false, true, 'L'));
        this.states.add(new State(false, true, 'R'));
        this.states.add(new State(true, false, 'L'));
        this.states.add(new State(true, false, 'R'));
        this.states.add(new State(false, false, 'L'));
        this.states.add(new State(false, false, 'R'));
    }
}
