package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeView {
    
    private final Scanner keyboard;
    int row = 0;
    int col =0;
    public static TicTacToeMove moves;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView() {
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);
        moves = new TicTacToeMove( row,col);   
    }  
    public TicTacToeMove getNextMove(boolean isXTurn) {
        
        /* Prompt the player to enter the row and the column of their next move.
           Return as a TicTacToeMove object. */
        
        // INSERT YOUR CODE HERE
        
        if(isXTurn == true){
            System.out.println("Player 1 (X) Move:");
            
        }
        else{         
            System.out.println("Player 2 (O) Move:");
        }
                System.out.println("Enter the row and column numbers, separated by a space:");
             String move = keyboard.nextLine();
            String[] parts = move.split(" ");
            int[] moveInt = new int[parts.length];
            for(int i = 0; i < parts.length; i++) {
                moveInt[i] = Integer.parseInt(parts[i]);
            }
            int r = moveInt[0];
            int c = moveInt[1];
            moves.row = r;
            moves.col = c;
            return moves;   
    }

    public void showInputError() {

        System.out.println("Entered location is invalid, already marked, or out of bounds.");

    }

    public void showResult(String r) {

        System.out.println(r + "!");

    }
    
    public void showBoard(String board) {
        
        System.out.println("\n\n" + board);
        
    }	
}