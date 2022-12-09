
public enum Direction { //A list of possible directions
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);
    private int value;

    private Direction(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
