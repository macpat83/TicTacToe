import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");
            char[][] TicTacToe = {
              {'_', '_', '_'},
              {'_', '_', '_'},
              {'_', '_', '_',},
            
            };

            printBoard(TicTacToe);
            
            System.out.print("\n");
            for (int i = 0; i < 9; i++) {
              if (i % 2 == 0){
                System.out.println("Turn X");
                int[] spot = askUser(TicTacToe);
                TicTacToe[spot[0]][spot[1]] = 'X';
                    printBoard(TicTacToe);

              } else if (i % 2 != 0) {
                System.out.println("Turn O");
                int[] spot = askUser(TicTacToe);
                TicTacToe[spot[0]][spot[1]] = 'O';
                printBoard(TicTacToe);

    
                
              }
              
                
              
              if (checkWin(TicTacToe) == 3) {
                System.out.println("\nX wins!!");
                break;
            } else if (checkWin(TicTacToe) == -3) {
                System.out.println("\nO wins!!");
                break;
            } else if (i == 8) {
                System.out.println("It's a tie!");
            }

        }

        scan.close();
    }
              
              
            

            
            //Task 1: Create an array with three rows of '_' characters.

            //Task 2: Call the function printBoard();

             
              /*
              {  Task 3: Loop through turns.

                  if (X) turn {
                     Task 4: call askUser(). 
                     Task 5: populate the board using askUser's return value.
                  } else {
                      Task 4: call askUser(). 
                      Task 5: populate the board using askUser's return value. Then, print it.

                  }

                Task 6 - Call the function.
                   if return value == 3 {
                     print: X wins and break the loop
                  } else if return value == -3 {
                     print: O wins and break the loop
                  }

              } 
              */

            


        public static void printBoard(char[][] board) {
          for (int i = 0; i < board.length; i++) {
            System.out.println("\n");
            System.out.print("\t");
            for (int j = 0; j < board[i].length; j++){
              System.out.print(board[i][j] + " ");



            }
          }

        }
    /** Task 2 - Write a function that prints the board.
     * Function name - printBoard()
     * @param board (char[][])
     * 
     * Inside the function:
     *   1. print a new line.
     *   2. print the board.
     *      • separate each row by two lines. 
     *      • each row precedes a tab of space
     *      • each character in the grid has one space from the other character
     */
    
     public static int[] askUser(char[][] board) {
        System.out.print("Pick a row and column number: ");
        int row = scan.nextInt();
        int column = scan.nextInt();

        while (board[row][column] != ('_')){
            System.out.print("Spot taken, try again: ");
            row = scan.nextInt();
            column = scan.nextInt();

          }
        
          int[] spot = {row, column};
          return spot; 
      }

   /** Task 4 - Write a function that lets the user choose a spot
     * Function name – askUser
     * @param board (char[][] board)
     * @return spot (int[])
     * 
     * Inside the function
     *   1. Asks the user: - pick a row and column number: 
     *   2. Check if the spot is taken. If so, let the user choose again.
     *   3. Return the row and column in an int[] array.
     * 
     */

    public static int checkWin(char[][] board) {
        
      //Check each of 3 rows
      int count = 0;

      for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[i].length; j++) {
              if (board[i][j] == 'X') {
                  count++; //count each X as +1
              } else if (board[i][j] == 'O') { 
                  count--; //count each O as -1. 
              }
          }
          if (count == 3 || count == -3) {
              return count;
          } else {
              count = 0;
          }

      }

      for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {

              if (board[j][i] == 'X') {
                  count++; //count each X as +1
              } else if (board[j][i] == 'O') { 
                  count--; //count each O as -1. 
              }
          }
          if (count == 3 || count == -3) {
              return count;
          } else {
              count = 0;
          }
      }

      for (int i = 0; i < 3; i++) {
          if (board[i][i] == 'X') {
              count++; //count each X as +1
          } else if (board[i][i] == 'O') { 
              count--; //count each O as -1. 
          }
      }

      if (count == 3 || count == -3) {
          return count;
      } else {
          count = 0;
      }

      for (int i = 0; i < 3; i++) {
          if (board[i][2-i] == 'X') {
              count++; //count each X as +1
          } else if (board[i][2-i] == 'O') { 
              count--; //count each O as -1. 
          }
      }

      return count;
  }

}

    /** Task 6 - Write a function that determines the winner
     * Function name - checkWin 
     * @param board (char[][])
     * @return count (int)
     * 
     * Inside the function:
     *   1. Make a count variable that starts at 0.
     *   2. Check every row for a straight X or straight O (Task 7).
     *   3. Check every column for a straight X or straight O (Task 8).
     *   4. Check the left diagonal for a straight X or straight O (Task 9).
     *   5. Check the right diagonal for a straight X or straight O (Task 10).
     */



