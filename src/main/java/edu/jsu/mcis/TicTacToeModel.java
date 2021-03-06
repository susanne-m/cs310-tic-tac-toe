package edu.jsu.mcis;

public class TicTacToeModel {

    private Mark[][] board; /* Game board */
    public boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    private boolean MarkX;
    private boolean MarkO;
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private final String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private final String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        
        // INSERT YOUR CODE HERE
        for(int i = 0; i < width; i++){
            for(int j = 0; j < width; j++){
                
                board[i][j] = Mark.EMPTY ;
            }
                
        }
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        // INSERT YOUR CODE HERE
            if(isValidSquare(row,col) == true){
            if(isSquareMarked(row, col) != true){
                if(xTurn == true){
                    board[row][col] = Mark.X;
                    xTurn = !xTurn;
                    return true;
                }
                if(xTurn != true){
                    board[row][col] = Mark.O;
                    xTurn = !xTurn;
                    return true;
            }
            }
            else{
                return false;
            }
        }
            else{
          return false;
        }
         return true;   
    }
	
    public boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        // INSERT YOUR CODE HERE

        if ((row >= 0) && (row < width)) {
            if((col >= 0) && (col < width)) {

                    return true;
                }
            else{
                return false;
            }
            }
             
        else{
            return false;
        } 
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        MarkX= (board[row][col] == Mark.X);
        MarkO= (board[row][col] == Mark.O);
        // INSERT YOUR CODE HERE
          if ((row >= 0) && (row < width)) {
            if ((col >= 0) && (col < width)) {
                if(MarkX == true){
                    return true;
                }
                else if(MarkO == true){
                    return true;
                }
                
                }
            }
             
        return false;    
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        // INSERT YOUR CODE HERE

        return (board[row][col]);
            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        // INSERT YOUR CODE HERE

        if(isMarkWin(Mark.O)== true){
            
            return Result.O;
        }
        if(isMarkWin(Mark.X)== true){
            
            return Result.X;
        }
        if(isTie()== true){
            
            return Result.TIE;
        }

            return Result.NONE;
        
        
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        // INSERT YOUR CODE HERE

              if (mark.equals(board[0][0]) && mark.equals(board[0][1]) && mark.equals(board[0][2])){
                return true;}
            else if (mark.equals(board[1][0]) && mark.equals(board[1][1]) && mark.equals(board[1][2])){
                return true;}
            else if (mark.equals(board[2][0]) && mark.equals(board[2][1]) && mark.equals(board[2][2])){
                return true;}
            else if (mark.equals(board[0][0]) && mark.equals(board[1][0]) && mark.equals(board[2][0])){
                return true;}
            else if (mark.equals(board[0][1]) && mark.equals(board[1][1]) && mark.equals(board[2][1])){
                return true;}
            else if (mark.equals(board[0][2]) && mark.equals(board[1][2]) && mark.equals(board[2][2])){
                return true;}
            else if (mark.equals(board[0][0]) && mark.equals(board[1][1]) && mark.equals(board[2][2])){
                return true;}
        else if (mark.equals(board[0][2]) && mark.equals(board[1][1]) && mark.equals(board[2][0])){
             return true;}
        else{
        return false;
        }
}
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        // INSERT YOUR CODE HERE

        boolean isFull = true;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == Mark.EMPTY) {
                    isFull = false;
                }
            }
    }
        return false;
    }
    

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        if(isMarkWin(Mark.X)== true){
            return true;
        }
        if(isMarkWin(Mark.O)== true){
            return true;
        }
        if(isTie()== true){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder();
        
        /* Output the board contents as a string (see examples) */
        
        // INSERT YOUR CODE HERE
       output.append("  012 \n");
        for (int i = 0; i < width; i++) {
            output.append(i);
            output.append(" ");
            for (int j = 0; j < width; j++) {
                switch(board[i][j]){
                    case X:
                        output.append("X");
                        break;
                    case O:
                        output.append("O");
                        break;
                        
                    case EMPTY:
                        output.append("-");
                        break;
                }
                
                
            }
            output.append("\n");
        }
        
        return output.toString();
        
    }
  
}
