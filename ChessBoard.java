
/**
 * Write a description of class ChessBoard here.
 * 
 * @author (Shaviyo Marasinghe) 
 * @version (Assignment 1: November 6th, 2016)
 */
public class ChessBoard
{
    static ChessPiece[][] board = new ChessPiece[8][8];

    /**
     * Constructs a blank chessboard
     */
    public void ChessBoard()
    {
        board = null;
    }
    
    public static ChessPiece getPieceAt(ChessLocation location)
    {
        return board[location.getrow()][location.getcol()];
    }
    
    /**
     * return true if a knight is locate at the specified row and column, or false if empty. 
     */
    public boolean isPieceAt(int row, int col)
    {
        if(board[row][col] == null){
            return false;
        }
        return true;
    }
    
    /**
     * When a Knight and a location is given, it places the knight at the given location. 
     * Also changes the location in the Knight to the location given. 
     */
    public static void placePieceAt(ChessPiece piece, ChessLocation location)
    {
        
        for(int i=0; i<8; i++){
            if(location.getrow() == i){
                for(int j=0; j<8; j++){
                    if(location.getcol() == j){
                        board[i][j] = piece;
                        piece.setLocation(location);
                    }
                }
            }
        }
    }
    
    /**
     * Removes the chess piece from the given location
     */
    public static void removePiece(ChessLocation location)
    {
        board[location.getrow()][location.getcol()] = null;
    }
    
    public static void setBoard(ChessPiece piece, ChessLocation destination)
    {
        board[destination.getrow()][destination.getcol()] = piece;
    }
    
    /**
     * Prints a board with Piece ID being the location of the piece. "-" act as blank spaces. 
     */
    public static void PrintBoard()
    {
        for (int i = 0; i<8; i++){
            System.out.println();
            for (int j=0; j<8; j++){
                if(board[i][j] == null){
                    System.out.print("- ");
                }
                if(board[i][j] != null){
                    System.out.print(board[i][j].id + " ");
                }
            }
        }
    }
}
