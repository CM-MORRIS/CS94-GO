package application;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Will
 * This class is for finding neighbours of counters
 */
public class FindAdjacentPoints {
	/**
	 * value for x position
	 */
	private int xpos;
	
	/**
	 * value for y position
	 */
	private int ypos ;
	
	/**
	 * reference  to board
	 */
	private final BoardLogic board;
	
	/**
	 * Player class instance
	 * @param player 1
	 * @param player 2 
	 */
	Player player = new Player("Alex","Will");
	
	/**
	 * list where neighbours is stored
	 */
	private List<Integer> points = new ArrayList<Integer>();
	
	
	/**
	 * Initialises variables
	 * @param board
	 * @param x
	 * @param y
	 */
	public FindAdjacentPoints(BoardLogic board,int x , int y ) {
		xpos= x;
        ypos = y;
        this.board = board;
       
	}
	
	/**
	 * this method finds placed counters
	 * threes are removed at the outer array values have no board correspondence 
	 * therefore redundant 
	 * @param Xpos
	 * @param Ypos
	 * @return list of points
	 */
	public List<Integer> Find(int Xpos ,int Ypos){
		points = new ArrayList <Integer>();
		
		points.add(board.getBoardValue(xpos - 1, ypos));
        points.add(board.getBoardValue(xpos, ypos + 1));
        points.add(board.getBoardValue(xpos + 1, ypos));
        points.add(board.getBoardValue(xpos, ypos - 1));
       int i =0;
       while(i < points.size()) {
    	   if(points.get(i) == 3 ) {
    		   points.remove(i);
    	   }
    	   else
    		   i++;
       }
        return points;
}

	/**
	 * @return points
	 */
	public List<Integer> getPoints() {
		return points;
	}

	/**
	 * set points
	 * @param points
	 */
	public void setPoints(List<Integer> points) {
		this.points = points;
	}
	
}
