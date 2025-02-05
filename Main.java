import java.util.Scanner;

public class Main {

    public static void printBoard(String[][] board){
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("---------");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("---------");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    public static String swap(String turn){
        if(turn.equals("X")){
            return "O";
        }
        return "X";
    }

    public static boolean isFull(String[][] board){
        boolean full = true;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[r].length; c++){
                if(board[r][c].equals(" ")){
                    full = false;
                }
            }
        }
        return full;
    }

    public static boolean checkForWin(String[][] board){
        return checkRows(board) || checkCols(board) || checkDiag(board);
    }

    public static boolean checkRows(String[][] board){
        for(int r = 0; r < board.length; r++){
            if(board[r][0].equals(board[r][1]) && board[r][1].equals(board[r][2]) && !board[r][0].equals(" ")){
                return true;
            }
        }
        return false;
    }

    public static boolean checkCols(String[][] board){
        for(int c = 0; c < board[0].length; c++){
            if(board[0][c].equals(board[1][c]) && board[1][c].equals(board[2][c]) && !board[0][c].equals(" ")){
                return true;
            }
        }
        return false;
    }

    public static boolean checkDiag(String[][] board){
        if(board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals(" ")){
            return true;
        }
        if(board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2]) && !board[2][0].equals(" ")){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        String[][] board = {{" ", " ", " "},{" ", " ", " "},{" ", " ", " "}};
        Scanner kb = new Scanner(System.in);
        String playerTurn = "X";
        
        while(!isFull(board) && !checkForWin(board)){
            printBoard(board);
            System.out.println("\n" + playerTurn + "'s turn. Pick a row:");
            int row = kb.nextInt();
            System.out.println("Pick a column:");
            int col = kb.nextInt();
            if(row >= 0 && row <= 2 && col >= 0 && col <= 2 && board[row][col].equals(" ")){
                board[row][col] = playerTurn;
                playerTurn = swap(playerTurn);
            }
            else {
                System.out.println("Sorry that space is not available. Let's try again.");
            }
            if(checkForWin(board)){
                printBoard(board);
                playerTurn = swap(playerTurn);
                System.out.println(playerTurn + " won the game!");
            }
        }
    }

}