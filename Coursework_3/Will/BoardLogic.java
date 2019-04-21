package application;
/**
 * @author Will
 *
 */
public class BoardLogic  {
	
	/**
	 * board deceleration
	 */
	private int[][] board;
	
	/**
	 * width of board array
	 */
	private int width;
	
	/**
	 * height of board array
	 */
	private int height ;
     
	/**
	 * Player class instance
	 * @param player 1
	 * @param player 2 
	 */
	Player player = new Player("Will", "Alex");

	
	/**
	 * Constructor initialises below parameters
	 * @param h
	 * @param w
	 * @param board
	 */
	public BoardLogic(int h , int w) {
	this.height = h ;
	this.width = w;
	board = new int[width][height];
	}
	
	/**
	 * Get current value at that position
	 * @param Xpos
	 * @param Ypos
	 * @return board value at that position
	 */
	public int getBoardValue(int Xpos, int Ypos) {
		return board[Xpos][Ypos];
	}
	
	/**
	 * This method updates the board values in each cell
	 * @param Xpos
	 * @param Ypos
	 * @return updated board
	 */
	public int [][] updateBoard(int Xpos , int Ypos) {
		if(board[Xpos][Ypos] == 0 && player.whosTurn() == 1) {
			board[Xpos][Ypos] = 1;
		}
		else if((board[Xpos][Ypos] == 0) &&( player.whosTurn() == 2)) {
			board[Xpos][Ypos] = 2 ;
		}
		player.incrementTurnCounter();
		return board;
	}
	/**
	 * threes are used to mark the outer array columns 
	 * @return initialise board values at the start
	 */
	public int [][] initiliseStates(){
		for(int i =0 ; i < 11; ++i) {
			for(int j=0 ; j< 11 ; ++j) {
				if(i ==0 || i == 10 || j == 0 || j == 10 ) {
					board[j][i] = 3; 
				}
			}
	}
		return board;	
	}
	
	/**
	 * Gives representation of board array
	 * on click the up dated vales can be seen 
	 * when called in the main method 
	 */
	public void printArray() {
		for(int i =0 ; i < 11; ++i) {
			for(int j=0 ; j< 11 ; ++j) {
				System.out.print(board[j][i]);
			}
		System.out.println();
	 }
	}
}
