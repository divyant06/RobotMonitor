public class RobotMonitor
{
    // constant for the grid size (required by the GUI)
    public static final int MAX = 6;
    
    // attributes   
    private int row;
    private int col;
    private Move move;
    
    // invariant: Robot must stay within the 6x6 grid
    public boolean inv() 
    {
        return (row >= 1 && row <= MAX && col >= 1 && col <= MAX);           
    }
    
    // initialisation
    public RobotMonitor()
    {
        row = 1;
        col = 1;
        move = null; // initially no move is allocated
        
        if (!inv()) {
            throw new VDMException("Invariant broken during initialization");
        }
    }
   
    // operations (Getters)
    public int GetCol() { return col; }
    public int GetRow() { return row; }
    public Move GetMove() { return move; }
    
    // movement operations
    public void MoveRight() 
    {
        // CHECK precondition: cannot repeat right, cannot move off right edge
        if (move == Move.RIGHT || col >= MAX) {
            throw new VDMException("Precondition broken: Cannot Move RIGHT");
        }
        
        // IMPLEMENT body
        col = col + 1;
        move = Move.RIGHT;
        
        // CHECK invariant 
        if (!inv()) {
            throw new VDMException("Invariant broken after MoveRight");
        }
    }
    
    public void MoveLeft() 
    {
        if (move == Move.LEFT || col <= 1) {
            throw new VDMException("Precondition broken: Cannot Move LEFT");
        }
        col = col - 1;
        move = Move.LEFT;
        if (!inv()) { throw new VDMException("Invariant broken after MoveLeft"); }
    }
    
    public void MoveDown() 
    {
        if (move == Move.DOWN || row >= MAX) {
            throw new VDMException("Precondition broken: Cannot Move DOWN");
        }
        row = row + 1;
        move = Move.DOWN;
        if (!inv()) { throw new VDMException("Invariant broken after MoveDown"); }
    }
    
    public void MoveUp() 
    {
        if (move == Move.UP || row <= 1) {
            throw new VDMException("Precondition broken: Cannot Move UP");
        }
        row = row - 1;
        move = Move.UP;
        if (!inv()) { throw new VDMException("Invariant broken after MoveUp"); }
    }
    
    public void Exit()
    {
        // CHECK precondition: must be at 6,6 to exit
        if (row != MAX || col != MAX) {
            throw new VDMException("Precondition broken: Cannot EXIT. Not at door.");
        }
        // Action is "skip", so we do nothing to the state
    }
        
    // toString method added for text runner
    public String toString()
    {
        return "Row: " + row + ", Col: " + col + ", Last Move: " + (move == null ? "None" : move.toString());
    }
}