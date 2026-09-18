
import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame{
    JButton[][] buttons;
    GameLogic logic;
    JLabel status;

    public GameBoard(){
        setTitle("TIC TAC TOE");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.logic = new GameLogic();
        this.buttons = new JButton[3][3];



        status = new JLabel(logic.getCurrentPlayer() + "'s turn");
        add(status, BorderLayout.NORTH);

        buildButtonGrid();

        setVisible(true);
    }

    private void buildButtonGrid(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                JButton button = new JButton("");
                button.setFont(new Font("Arial", Font.BOLD, 40));
                button.setBackground(Color.decode("#B1E5E6"));
                buttons[i][j] = button;

                final int r = i;
                final int c = j;
                button.addActionListener(e -> handleClick(r, c));
                panel.add(button);
            }
        }

        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.addActionListener(e -> resetGame());

        add(playAgainButton, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
    }

    private void handleClick(int row, int col){
        if(!logic.isCellEmpty(row, col)){
            return;
        }

        char player = logic.getCurrentPlayer();
        logic.placeMark(row, col);
        buttons[row][col].setText(String.valueOf(player));
        status.setFont(new Font("Arial", Font.BOLD, 20));

        if(logic.checkWin()){
            status.setText(player + " wins!");
            disableAllButtons();


        }else if(logic.isDraw()){
            status.setText("Game is a draw!");
            disableAllButtons();

        }else{
            logic.switchTurn();
            status.setText(logic.getCurrentPlayer() + " 's turn");
        }
    }

    private void disableAllButtons(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                buttons[i][j].setEnabled(false);
            }
        }
    }

    private void resetGame(){
        logic.reset();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }

        status.setText(logic.getCurrentPlayer() + " 's turn");
    }
}
