/**
 * @author tom
 *  Keep track of the state of each node
 */
public class State extends Object{
    /*  Instance Variables  *************************************************/
    boolean dirtLeft;
    boolean dirtRight;
    char position;

    /*  Constructors    *****************************************************/
    public State(boolean dirtLeft, boolean dirtRight, char position) {
        this.dirtLeft = dirtLeft;
        this.dirtRight = dirtRight;
        this.position = position;
    }

    /*  Getters *************************************************************/
    public boolean isDirtLeft() {
        return dirtLeft;
    }

    public boolean isDirtRight() {
        return dirtRight;
    }

    public char getPosition() {
        return position;
    }

    /*  Setters *************************************************************/
    public void setDirtLeft(boolean dirtLeft) {
        this.dirtLeft = dirtLeft;
    }

    public void setDirtRight(boolean dirtRight) {
        this.dirtRight = dirtRight;
    }

    public void setPosition(char position) {
        this.position = position;
    }

    /*  Overrides   *********************************************************/
    @Override
    public String toString(){
        return "L<>R " + this.dirtLeft + " <-> " + this.dirtRight + "   Position: " + this.position;
    }


    public boolean equals(State state){
        return this.dirtLeft == state.isDirtLeft() &&
                this.dirtRight == state.isDirtRight() &&
                this.position == state.getPosition();
    }
}