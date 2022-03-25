public class NQueensIterativeEightFirstSolution {
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

    public static boolean nQueen(int[][] board, int row)  { //method that uses the iterative format combined with backtracking to place the queens on the board

        if (row == board.length) { //base case for recursive algorithm that is reached when all queens are placed

            printSolvedArray(board);
            return true;

        }

        //the for loops below run iteratively and each one runs through its respective ith row (e.g. the for loop with int i2 corresponds to row of index 2)
        //these loops go through the rows and determine if a queen can be placed on an index in the row and if it is unable to it will back track by resetting the index of the placed queen to zero
        //the for loops are nested within eachother to act similairly to the recursive found in NQueensRecursive
        //the for loops go from index i to i7 to get NQueen solutions for 8x8

        for (int i = 0; i < board.length; i++) {

            if (canPlaceQueen(board, row, i)) {

                board[row][i] = 1;

                for (int i1 = 0; i1 < board.length; i1++) {

                    if (canPlaceQueen(board, row+1, i1)) {

                        board[row+1][i1] = 1;

                        for (int i2 = 0; i2 < board.length; i2++) {

                            if (canPlaceQueen(board, row+2, i2)) {

                                board[row+2][i2] = 1;

                                for (int i3 = 0; i3 < board.length; i3++) {

                                    if (canPlaceQueen(board, row+3, i3)) {

                                        board[row+3][i3] = 1;

                                        for (int i4 = 0; i4 < board.length; i4++) {

                                            if (canPlaceQueen(board, row+4, i4)) {

                                                board[row+4][i4] = 1;

                                                for (int i5 = 0; i5 < board.length; i5++) {

                                                    if (canPlaceQueen(board, row+5, i5)) {

                                                        board[row+5][i5] = 1;

                                                        for (int i6 = 0; i6 < board.length; i6++) {

                                                            if (canPlaceQueen(board, row+6, i6)) {

                                                                board[row+6][i6] = 1;

                                                                for (int i7 = 0; i7 < board.length; i7++) {

                                                                    if (canPlaceQueen(board, row+7, i7)) {

                                                                        board[row+7][i7] = 1;


                                                                        printSolvedArray(board);


                                                                        board[row+7][i7] = 0;
                                                                        return true; // return statement placed to stop algorithm from getting more than the first solution
                                                                    }
                                                                }

                                                                board[row+6][i6] = 0;
                                                            }
                                                        }

                                                        board[row+5][i5] = 0;
                                                    }
                                                }

                                                board[row+4][i4] = 0;
                                            }
                                        }

                                        board[row+3][i3] = 0;
                                    }
                                }

                                board[row+2][i2] = 0;
                            }
                        }

                        board[row+1][i1] = 0;
                    }
                }

                board[row][i] = 0;
            }
        }
        return false; //returns false if there is no solution associated with the placement of the queen
    }

    public static void main(String[] args) {

        final int boardDimension = 8; // holds a constant value of 8 please do not change this value as it may cause an index Error or return false



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
