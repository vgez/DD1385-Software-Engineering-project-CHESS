package Chess.View;

import Chess.Model.Boardgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewControl extends JFrame implements ActionListener {

    private Square[][] board;
    private JLabel mess;
    private Boardgame game;
    private Square currentSq, prevSq;
    private boolean state = false;
    private final static String l = "ABCDEFGH";

    public ViewControl(Boardgame game) {
        super("VALENS SCHACK");
        board = new Square[8][8];
        this.game = game;
        mess = new JLabel(game.getMessage(), SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.white);
        panel1.setPreferredSize(new Dimension(770, 650));
        panel2.setPreferredSize(new Dimension(370, 650));
        panel2.setPreferredSize(new Dimension(370, 650));
        panel2.setPreferredSize(new Dimension(370, 650));
        mess.setPreferredSize(new Dimension(370, 650));
        mess.setFont(new Font("Helvetica", Font.ITALIC, 14));
        mess.setForeground(Color.black);
        panel1.setLayout(new GridLayout(8, 8));
        panel2.add(mess);
        getContentPane().add(panel1, BorderLayout.WEST);
        getContentPane().add(panel2, BorderLayout.EAST);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = new Square(row, col);
                board[row][col].addActionListener(this);
                panel1.add(board[row][col]);
                if (game.getStatus(row, col) != null) {
                    setSquare(row, col);
                }
            }
        }
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setSquare(int row, int col) {
        board[row][col].setIcon(game.getStatus(row, col));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentSq = (Square) e.getSource();
        if ((game.getStatus(currentSq.row, currentSq.col) != null) && (game.matchTurn(currentSq.row, currentSq.col))) {
            if (!state) {
                prevSq = currentSq;
                prevSq.selectSquare();
                state = !state;
                mess.setText("SELECTED SQUARE: "+String.valueOf(l.charAt(prevSq.row))+""+(prevSq.col+1));
                return;
            }
        }
        if (prevSq == null) {
            return;
        }
        if (currentSq.row == prevSq.row && currentSq.col == prevSq.col) {
            resetDraw();
            mess.setText(null);
            return;
        }
        if ((game.getStatus(currentSq.row, currentSq.col) == null) || ((game.matchTurn(currentSq.row, currentSq.col)) != (game.matchTurn(prevSq.row, prevSq.col)))) {
            currentSq.selectSquare();
            if (game.move(prevSq.row, prevSq.col, currentSq.row, currentSq.col)) {
                board[prevSq.row][prevSq.col].removeIcon();
                board[currentSq.row][currentSq.col].removeIcon();
                setSquare(currentSq.row, currentSq.col);
                mess.setText(game.getMessage());
                resetDraw();
                return;
            }
            currentSq.deselectSquare();
            currentSq = null;
            mess.setText(game.getMessage());
        }
    }

    private void resetDraw() {
        prevSq.deselectSquare();
        currentSq.deselectSquare();
        currentSq = null;
        prevSq = null;
        state = !state;
    }
}
