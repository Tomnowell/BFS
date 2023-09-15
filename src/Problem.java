package BFS;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tom
 *
 */
public class Problem {
    ArrayList<State> states = new ArrayList<>();
    // Define actions
    List<String> actions = List.of("goLeft", "goRight", "suck");
    // Set initial state dirtLeft = true, dirtRight = true and position is left
    State initialState = new State(true, true, 'L');
    // Keep track of solution cost
    int totalCost = 0;
    public Problem() {
        this.defineAllStates();
        //  states.forEach();

    }
    // Define goal states
    public static boolean isGoalState(State state) {
        return !state.dirtLeft && !state.dirtRight;
    }

    public ArrayList<State> getStates() {
        return this.states;
    }
    public List<String> getActions() {
        return this.actions;
    }
    public int costFunction(){
        return 1; // This can be changed to simulate different costs of actions
    }

    /*
     *	Transition model should return a state depending on a passed state and action
     */
    public State goRight(State state){
        if (state.getPosition() == 'L'){
            this.totalCost += this.costFunction(); // Add the cost of the action to total
            return new State(state.isDirtLeft(), state.isDirtRight(), 'R');
        }else{
            throw new IndexOutOfBoundsException(); // Already at Right
        }
    }

    public State goLeft(State state){
        if (state.getPosition() == 'R'){
            this.totalCost += this.costFunction(); // Add the cost of the action to total
            return new State(state.isDirtLeft(), state.isDirtRight(), 'L');
        }else{
            throw new IndexOutOfBoundsException(); // Already at Left
        }
    }

    public State suck(State state){
        if (state.getPosition() == 'L'){
            if (state.isDirtLeft()){
                this.totalCost += this.costFunction(); // Add the cost of the action to total
                return new State(false, state.isDirtRight(),'L');
            }else{
                throw new IndexOutOfBoundsException(); // Already clean
            }
        }else{
            if (state.isDirtRight()){
                this.totalCost += this.costFunction(); // Add the cost of the action to total
                return new State(state.isDirtLeft(), false,'R');
            }else{
                throw new IndexOutOfBoundsException();
            }

        }
    }
    private void defineAllStates(){
        this.states.add(this.initialState);
        char[] positions = {'L', 'R'};
        for (char position: positions){
            this.states.add(new State(true, false, position));
            this.states.add(new State(false, true, position));
            this.states.add(new State(true, true, position));
            this.states.add(new State(false, false, position));
        }
    }


}
