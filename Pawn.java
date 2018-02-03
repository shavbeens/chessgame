
/**
 * Write a description of class Pawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pawn extends ChessPiece
{
    public boolean firstMove;
    
    public Pawn(String player, ChessGame game, ChessLocation initial_location)
    {
        super(player, initial_location, game);
        if(player == game.getPlayer1()){
            super.id = 'P';
        }
        if(player == game.getPlayer2()){
            super.id = 'p';
        }
        firstMove = false;
    }
    
    public void moveTo(ChessLocation destination)
    {
        if(firstMove == false){
            if(destination.getcol() == super.getLocation().getcol()){
                if((destination.getrow() - super.getLocation().getrow()) <= 2){
                    if(super.checkLineOfSight(super.getLocation(), destination) == true){
                        super.moveTo(destination);
                        firstMove = true;
                    }
                }
            }
        }
        
        if(firstMove == true){
            if(destination.getcol() == super.getLocation().getcol()){
                if((destination.getrow() - super.getLocation().getrow()) <= 1){
                    if(super.checkLineOfSight(super.getLocation(), destination) == true){
                        super.moveTo(destination);
                    }
                }
            }
        }
    }
}
