import java.util.Arrays;

class NQueensRecursive {

    static int nQueensAnswers = 0; //static int that increments (in a later method) and will hold the number of nQueenSolutions based on a given N

    public static boolean canPlaceQueen(int[][] board, int row, int col) {  //Method that checks if there is a queen in the same column, diagonal(both directions) and returns true if you can place them and false if you cant

        for (int i = 0; i < row; i++) { // for loops that goes through a column of a 2d array and returns false if a queen ('1') is there

            if (board[i][col] == 1) { //if statement that returns false if a queen is present

                return false;

            }

        }

        int rowLen = row; //initialize variables to hold the row and column size (index + 1) that the associated piece is on
        int colLen = col;

        while (rowLen>=0 && colLen>=0){ //while loop that checks the diagonal of a 2d array(from index [n][n] towards [0][0] or 45 degree projection diagonal) and returns false if there is a queen

            if (board[rowLen][colLen] == 1) { //if statement that returns false if a queen is present

                return false;

            }

            rowLen--; //decrement row and column to go up the diagonal
            colLen--;

        }


        rowLen = row; //redeclare variables because they were altered by previous while loop
        colLen = col;

        while (rowLen>=0 && colLen< board.length) { //while loop that checks the diagonal of a 2d array(from index [0][0] towards [n][n] or 135 degree projection diagonal) and returns false if there is a queen

            if (board[rowLen][colLen] == 1) { //if statement that returns false if a queen is present

                return false;

            }

            rowLen--;//decrement row and increment column to go down the diagonal
            colLen++;

        }

        return true; //returns true if there is no queen, and you can place one
    }

    public static void printSolvedArray(int[][] board) { //method that prints out the solved Nqueen array and associated number with the solution

        nQueensAnswers++; //increment N queen answers

        System.out.println("Solution number: " + nQueensAnswers +  " to n queen is:"); //Print statement that is placed before solved array that shows the solution number

        for (int i = 0; i < board.length; i++) { //for loop and nested for loops print out the solved array

            for (int j = 0; j < board.length; j++) {

                System.out.print(board[i][j] + "  ");

            }

            System.out.println(); //seperates rows while printing

        }

        System.out.println(); //creates seperation for the next solution to be printed


    }

    public static boolean nQueen(int[][] board, int row)  { //method that uses recursion and backtracking to place the queens on the board

        if (row == board.length) { //base case for recursive algorithm that is reached when all queens are placed

            printSolvedArray(board);
            return true;

        }


        for (int i = 0; i < board.length; i++) { //for loop that runs through current row

            if (canPlaceQueen(board, row, i))  { //calls the canPlaceQueen method to check if a queen can be placed


                board[row][i] = 1; //if queen can be placed  at this index

             nQueen(board, row + 1);//use recursion to solve n queens for following rows


                board[row][i] = 0; //if no answer is found backtrack and remove the queen from this index
            }
        }
        return false; //returns false if there is no solution associated with the placement of the queen
    }

    public static void main(String[] args) {

        int boardDimension = 8; // holds value n dimension for nxn chessboard



        int [][] board = new int[boardDimension][boardDimension]; //declared and initialized the board and size of board based on dimensions

        for (int i = 0; i < boardDimension; i++) { //for loop and nested for loop initializes all value in the board to be 0( queens are represented by 1)

            for (int j = 0; j < boardDimension; j++) {

                board[i][j] = 0;

            }

        }

        long startTime = System.currentTimeMillis(); //stores the time before the nqueen algorithm is run

        nQueen(board, 0);

        long finishTime = System.currentTimeMillis(); //stores the after the nqueen algorithm is run

        System.out.println("Total time is milliseconds " + (finishTime-startTime)); //calculates the total time it takes to run the algorithm and displays it to the user
    }
}



