
/**
 * Write a description of class Bishop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bishop extends ChessPiece
{
    public Bishop(String player, ChessGame game, ChessLocation initial_location)
    {
        super(player, initial_location, game);
        if(player == game.getPlayer1()){
            super.id = 'B';
        }
        if(player == game.getPlayer2()){
            super.id = 'b';
        }
    }
    
    public void moveTo(ChessLocation destination){
        if(super.getLocation().getrow() - destination.getrow() == super.getLocation().getcol() - destination.getcol()){
            if(super.checkLineOfSight(super.getLocation(), destination) == true){
                super.moveTo(destination);
                return;
            }
        }
        else {
            System.out.println("\n\n\n" + "Your Move is Illegal");
        }
    }
}
