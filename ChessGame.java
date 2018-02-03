
/**
 * Write a description of class ChessGame here.
 * 
 * @author (Shaviyo Marasinghe) 
 * @version (Assignment 1: October 11th, 2016)
 */
public class ChessGame
{
    private ChessBoard board;
    private String player1 = "P1";
    private String player2 = "P2";
    /**
     * Constructor for objects of class ChessGame
     */
    public ChessGame()
    {
        board = new ChessBoard();
        int inc = 0;
        int Rinc = 0;
        
        ChessPiece Rook = new Rook(player1, this, new ChessLocation(Rinc, inc));
        ChessPiece Rook2 = new Rook(player1, this, new ChessLocation(Rinc, 7-inc));
        inc++;
        
        ChessPiece Knight = new Knight(player1, this, new ChessLocation(Rinc, inc));
        ChessPiece Knight2 = new Knight(player1, this, new ChessLocation(Rinc, 7-inc));
        inc++;
        
        ChessPiece Bishop = new Bishop(player1, this, new ChessLocation(Rinc, inc));
        ChessPiece Bishop2 = new Bishop(player1, this, new ChessLocation(Rinc, 7-inc));
        inc++;
        
        ChessPiece King = new King(player1, this, new ChessLocation(Rinc, inc));
        ChessPiece Queen = new Queen(player1, this, new ChessLocation(Rinc, 7-inc));
        Rinc++;
        for(int i=0; i<8; i++){
           ChessPiece Pawn = new Pawn(player1, this, new ChessLocation(Rinc, i));
        }
        
        inc = 0;
        Rinc = 7;
        ChessPiece rook = new Rook(player2, this, new ChessLocation(Rinc, inc));
        ChessPiece rook2 = new Rook(player2, this, new ChessLocation(Rinc, 7-inc));
        inc++;
        
        ChessPiece knight = new Knight(player2, this, new ChessLocation(Rinc, inc));
        ChessPiece knight2 = new Knight(player2, this, new ChessLocation(Rinc, 7-inc));
        inc++;
        
        ChessPiece bishop = new Bishop(player2, this, new ChessLocation(Rinc, inc));
        ChessPiece bishop2 = new Bishop(player2, this, new ChessLocation(Rinc, 7-inc));
        inc++;
        
        ChessPiece king = new King(player2, this, new ChessLocation(Rinc, inc));
        ChessPiece queen = new Queen(player2, this, new ChessLocation(Rinc, 7-inc));
        Rinc--;
        for(int i=0; i<8; i++){
            ChessPiece pawn = new Pawn(player2, this, new ChessLocation(Rinc, i));
        }
        
    }
    
    public ChessBoard getBoard()
    {
        return board;
    }
    
    public void setPlayer1(String name)
    {
        player1 = name;
    }
    
    public void setPlayer2(String name)
    {
        player2 = name;
    }
    
    public String getPlayer1()
    {
        return player1;
    }
    
    public String getPlayer2()
    {
        return player2;
    }
    
    public boolean canCapture(ChessPiece first, ChessPiece second)
    {
        if(first.getOwner() == second.getOwner()){
            return true;
        }
        return false;
    }
}
