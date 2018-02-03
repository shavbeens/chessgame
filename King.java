
/**
 * Write a description of class King here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class King extends ChessPiece
{
    public King(String player, ChessGame game, ChessLocation initial_location)
    {
        super(player, initial_location, game);
        if(player == game.getPlayer1()){
            super.id = 'K';
        }
        if(player == game.getPlayer2()){
            super.id = 'k';
        }
    }
    
    public void moveTo(ChessLocation destination)
    {
        if(Math.abs(destination.getcol() - super.getLocation().getcol()) <= 1){
            if(Math.abs(destination.getrow() - super.getLocation().getcol()) <= 1){
                if(super.checkLineOfSight(super.getLocation(), destination) == true){
                    super.moveTo(destination);
                    return;
                }
            }
        }
        else {
            System.out.println("\n\n\n" + "Your Move is Illegal");
        }
    }
}
