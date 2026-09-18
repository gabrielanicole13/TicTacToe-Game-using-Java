import java.util.Arrays;

public class GameLogic {

    int row = 3;
    int col = 3;
    char[][] board = new char[row][col];
    char currentPlayer = 'X';

    public GameLogic(){
       reset();
    }


    public void placeMark(int r, int c){
        if(currentPlayer == 'X'){
            board[r][c] = 'X';
        }else{
            board[r][c] = 'O';
        }
    }

    public boolean isCellEmpty(int r, int c){
        if(board[r][c] == ' '){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkLine(char a, char b, char c){
        return a != ' ' && a == b && b == c;
    }

    public boolean checkWin(){
        for(int i = 0; i < 3; i++){
            if(checkLine(board[i][0], board[i][1], board[i][2])) return true;

            if(checkLine(board[0][i], board[1][i], board[2][i])) return true;
        }
        if(checkLine(board[0][0], board[1][1], board[2][2])) return true;
        if(checkLine(board[0][2], board[1][1], board[2][0])) return true;

        return false;
    }

    public boolean isDraw(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    public void switchTurn(){
        if(this.currentPlayer == 'X'){
            currentPlayer = 'O';
        }else{
            currentPlayer = 'X';
        }
    }

    public char getCurrentPlayer(){
        return currentPlayer;
    }

    public void printBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public void reset(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = ' ';
            }
        }

        this.currentPlayer = 'X';
    }

}
