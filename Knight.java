
/**
 * Write a description of class Knight here.
 * 
 * @author (Shaviyo Marasinghe) 
 * @version (Assignment 1: October 11th, 2016)
 */
public class Knight extends ChessPiece
{

    /**
     * Constructor for Knight, sets the location on ChessBoard to the initial location declared.
     */
    public Knight(String player, ChessGame game, ChessLocation initial_location)
    {
        super(player, initial_location, game);
        if(player == game.getPlayer1()){
            super.id = 'N';
        }
        if(player == game.getPlayer2()){
            super.id = 'n';
        }
    }
    
    public void moveTo(ChessLocation destination)
    {
        if((Math.abs(destination.getrow() - getLocation().getrow()) == 2)){
            if((Math.abs(destination.getcol() - getLocation().getcol()) == 1)){
                super.moveTo(destination);
                return;
            }
        }
        
        if((Math.abs(destination.getcol() - getLocation().getcol()) == 2)) {
            if(Math.abs(destination.getrow() - getLocation().getrow()) == 1) {
                super.moveTo(destination);
                return;
            }
        }
        else {
            System.out.println("\n\n\n" + "Your Move is Illegal");
        }
        
    }
}
