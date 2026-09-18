import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        GameLogic logic = new GameLogic();

        while (logic.checkWin() != true && logic.isDraw() != true) {
            logic.printBoard();
            System.out.print("Input the row (0,1,2) for the desire placement: ");
            int row = input.nextInt();
            System.out.print("Input the column(0,1,2) for the desire placement: ");
            int col = input.nextInt();

            if(logic.isCellEmpty(row, col)){
                logic.placeMark(row, col);
            }else{
                System.out.println("You have placed an invalid mark, so u lose a turn");
            }

            if(logic.checkWin()){
                logic.printBoard();
                System.out.println("Congratulations, " + logic.getCurrentPlayer() + " wins the game");
            }else{
                if(logic.isDraw()){
                    logic.printBoard();
                    System.out.println("Game is draw");
                }
            }

            logic.switchTurn();


        }

    }

}
