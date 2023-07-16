import java.util.*;
public class TicTacToe{
    public static void main(String[] args){
        char [][] board=new char[3][3];
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++){
                board[row][col]=' ';
            }
        }
        char player='X';
        boolean gameOver=false;
        Scanner sc=new Scanner(System.in);
        while(!gameOver && !boardFull(board)){
            printBoard(board);
            System.out.println("Player "+player+" Enter: ");
            int row=sc.nextInt();
            int col=sc.nextInt();

            if(board[row][col]==' '){
               board[row][col]=player;
               gameOver=hasWon(board,player);
               if(gameOver){
                System.out.println("Player "+player+" has won");
               }
               else{
                if(player=='X'){
                    player='O';
                }
                else{
                    player='X';
                }
               }
            }
            else{
                System.out.println("Invalid Move. Try again!");
            }
        }
        printBoard(board);
    }

    public static boolean hasWon(char [][] board,char player){
      for(int row=0;row<board.length;row++){
        if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
            return true;
        }
      }
      for(int col=0;col<board.length;col++){
        if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
            return true;
        }
      }
      if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
        return true;
      }
      if(board[2][0]==player && board[1][1]==player && board[0][2]==player){
        return true;
      }
    return false;
    }

    public static boolean boardFull(char [][] board){
        for(int i=0;i<board.length;i++){
          for(int j=0;j<board.length;j++){
            if(board[i][j]==' '){
              return false;
            }
          }
        }
        System.out.println("Board is full");
        return true;
    }

    public static void printBoard(char [][] board){
         for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
               System.out.print(board[i][j]+"|");
            }
            System.out.println();
         }
    }
}