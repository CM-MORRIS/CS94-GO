package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GoBoard extends JFrame {
    public static final int SIZE = 50;
    static JFrame f;

    private static GameBoard board = new GameBoard(13, 13);
    private static GameLogic game = new GameLogic("Alex", "Will");

    private static JPanel jBoard;
    private static JButton[][] jIntersections;


    public static void main(String[] args) {
        f = new JFrame("panel");
        int boardWidth = board.getWidth();
        int boardHeight = board.getHeight();

        jBoard = new JPanel(new GridLayout(boardWidth, boardHeight));

        jIntersections = new JButton[boardWidth][boardHeight];

        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                String a = String.valueOf(i);
                String b = String.valueOf(j);
                jIntersections[i][j] = new JButton(BoardSprites.getGridIcon(board, i, j));
                jIntersections[i][j].setEnabled(true);
                jIntersections[i][j].setBorder(BorderFactory.createEmptyBorder());
                jIntersections[i][j].setContentAreaFilled(false);
                jIntersections[i][j].setPreferredSize(new java.awt.Dimension(SIZE, SIZE));

                int finalI = i;
                int finalJ = j;
                jIntersections[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if (game.whosTurn() == 1) {
                            board.setIntersectionState(finalI, finalJ, 1);
                            jIntersections[finalI][finalJ].setIcon(BoardSprites.midP1);
                            game.incrementTurnCounter();
                        } else {
                            board.setIntersectionState(finalI, finalJ, 2);
                            jIntersections[finalI][finalJ].setIcon(BoardSprites.midP2);
                            game.incrementTurnCounter();
                        }
                        if (board.getIntersectionState(finalI+1, finalJ) == 1) {
                            jIntersections[finalI+1][finalJ].setIcon(BoardSprites.getGridIcon(board,finalI+1, finalJ));
                        }
                    }
                });
                jBoard.add(jIntersections[i][j],i,j);
            }
        }
        f.add(jBoard);
        f.setSize(SIZE * boardWidth, SIZE * boardHeight);
        f.setVisible(true);

    }
}
