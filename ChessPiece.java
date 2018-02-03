
/**
 * Write a description of class ChessPiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChessPiece
{
    private ChessGame game;
    private String owner;
    private ChessLocation location;
    protected char id;

    public ChessPiece(String owner, ChessLocation initialLocation, ChessGame game)
    {
        this.owner = owner;
        this.location = initialLocation;
        this.game = game;
        game.getBoard().placePieceAt(this, location);
    }

    /**
     * Moves the chess piece to the location in the parameter.
     */
    protected void moveTo(ChessLocation newLocation)
    {
        game.getBoard().removePiece(location);
        location = newLocation;
        game.getBoard().setBoard(this, location);
    }

    protected boolean checkLineOfSight(ChessLocation start, ChessLocation end)
    {
        //for horizontal movement in the same row
        if(start.getrow() == end.getrow()){
            //when the starting column is smaller than the ending column
            if(start.getcol()<end.getcol()){
                for(int i=(start.getcol()+1); i<=end.getcol();)
                {
                    if(ChessBoard.board[start.getrow()][i] != null){
                        return false;
                    }
                    i++;
                }
            }
            //when the ending column is smaller than the starting column
            if(start.getcol()>end.getcol()){
                for(int i=(start.getcol()-1); i>=end.getcol();)
                {
                    if(ChessBoard.board[start.getrow()][i] != null){
                        return false;
                    }
                    i--;
                }
            }
        }
        
        
        //for vertival movement in the same colomn
        if(start.getcol() == end.getcol()){
            //when the starting row is smaller than the ending row
            if(start.getrow()<end.getrow()){
                for(int i=(start.getrow()+1); i<=end.getrow();)
                {
                    if(ChessBoard.board[i][start.getcol()] != null)
                    {
                        return false;
                    }
                    i++;
                }
            }
            //when the ending row is smaller than the starting row
            if(start.getrow()>end.getrow()){
                for(int i=(start.getrow()-1); i>=end.getrow();)
                {
                    if(ChessBoard.board[i][start.getcol()] != null)
                    {
                        return false;
                    }
                    i--;
                }
            }
        }
        
        
        //for angular movement
        if((start.getcol() - end.getcol()) == (start.getrow() - end.getrow())){ //positive slope high row to high col ot... high row to low col
            if(start.getcol()<end.getcol()){
                int j = start.getcol()+1;
                for(int i=(start.getrow()-1); i>=end.getrow(); i--){
                    if(ChessBoard.board[i][j] != null)
                    {
                        return false;
                    }
                    j++;
                }
                
            }
            
            if(start.getcol()>end.getcol()){
                int j = start.getcol()-1;
                for(int i=(start.getrow()-1); i>=end.getrow(); i--){
                    if(ChessBoard.board[i][j] != null)
                    {
                        return false;
                    }
                    j--;
                }
            }
        }
        

        if((start.getcol() - end.getcol()) * -1 == (start.getrow() - end.getcol())){ //negative slope, low row to high col or... low row to low col
            if(start.getcol()<end.getcol()){
                int j = start.getcol()+1;
                for(int i=(start.getrow()+1); i<=end.getrow(); i++){
                    if(ChessBoard.board[i][j] != null)
                    {
                        return false;
                    }
                    j++;
                }
                
            }
            
            if(start.getcol()>end.getcol()){
                int j = start.getcol()-1;
                for(int i=(start.getrow()+1); i<=end.getrow(); i++){
                    if(ChessBoard.board[i][j] != null)
                    {
                        return false;
                    }
                    j--;
                }
            }
        }
        return true;
    }

    public void setLocation(ChessLocation newlocation)
    {
        location = newlocation;
    }

    protected ChessLocation getLocation()
    {
        return location;
    }

    protected void setID(char ID)
    {
        id = ID;
    }

    public char getID()
    {
        return id;
    }
    
    public String getOwner()
    {
        return owner;
    }
}
