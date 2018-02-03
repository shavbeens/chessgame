
/**
 * Write a description of class Rook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rook extends ChessPiece
{
    public Rook(String player, ChessGame game, ChessLocation initial_location)
    {
        super(player, initial_location, game);
        if(player == game.getPlayer1()){
            super.id = 'R';
        }
        if(player == game.getPlayer2()){
            super.id = 'r';
        }
    }
    
    public void moveTo(ChessLocation destination)
    {
        if(destination.getrow() == super.getLocation().getrow()){
            if(super.checkLineOfSight(super.getLocation(), destination) == true){
                super.moveTo(destination);
                return;
            }
        }
        if(destination.getcol() == super.getLocation().getcol()){
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
