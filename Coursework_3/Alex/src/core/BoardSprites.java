package core;

import javax.swing.*;
import java.awt.*;

public class BoardSprites {

    public static final int size = GoBoard.SIZE;

    // Background sprite, for color
    private static final ImageIcon background = new ImageIcon(new ImageIcon("pictures/background.png").getImage().getScaledInstance(size, size, Image.SCALE_FAST));

    // All grid pictures
    public static final ImageIcon topL = new ImageIcon(new ImageIcon("pictures/topL.png").getImage().getScaledInstance(size,size, Image.SCALE_FAST));
    public static final ImageIcon top = new ImageIcon(new ImageIcon("pictures/top.png").getImage().getScaledInstance(size,size, Image.SCALE_FAST));
    public static final ImageIcon topR = new ImageIcon(new ImageIcon("pictures/topR.png").getImage().getScaledInstance(size,size, Image.SCALE_FAST));
    public static final ImageIcon left = new ImageIcon(new ImageIcon("pictures/left.png").getImage().getScaledInstance(size,size, Image.SCALE_FAST));
    public static final ImageIcon mid = new ImageIcon(new ImageIcon("pictures/mid.png").getImage().getScaledInstance(size,size, Image.SCALE_FAST));
    public static final ImageIcon right = new ImageIcon(new ImageIcon("pictures/right.png").getImage().getScaledInstance(size,size, Image.SCALE_FAST));
    public static final ImageIcon botL = new ImageIcon(new ImageIcon("pictures/botL.png").getImage().getScaledInstance(size,size, Image.SCALE_FAST));
    public static final ImageIcon bot = new ImageIcon(new ImageIcon("pictures/bot.png").getImage().getScaledInstance(size,size, Image.SCALE_FAST));
    public static final ImageIcon botR = new ImageIcon(new ImageIcon("pictures/botR.png").getImage().getScaledInstance(size,size, Image.SCALE_FAST));

    public static final ImageIcon midP1 = new ImageIcon(new ImageIcon("pictures/midP1.png").getImage().getScaledInstance(size,size, Image.SCALE_FAST));
    public static final ImageIcon midP2 = new ImageIcon(new ImageIcon("pictures/midP2.png").getImage().getScaledInstance(size,size, Image.SCALE_FAST));

    public static ImageIcon getGridIcon(GameBoard board, int x, int y) {
        int boardWidth = board.getWidth();
        int boardHeight = board.getHeight();

        if (x == boardWidth - 1) {
            if (y == 0) {
                return topL;
            } else if (y == boardHeight - 1) {
                return topR;
            } else {
                return top;
            }
        } else if (x == 0) {
            if (y == 0) {
                return botL;
            } else if (y == boardHeight - 1) {
                return botR;
            } else {
                return bot;
            }
        } else {
            if (y == 0) {
                return left;
            } else if (y == boardHeight - 1) {
                return right;
            } else {
                return mid;
                }
            }
        }
    }
