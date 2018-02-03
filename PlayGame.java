import java.util.Scanner;
/**
 * Write a description of class PlayGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayGame
{
    static ChessGame game; //new game decleration
    static Scanner input = new Scanner(System.in); //will take user inputs
    private static String pl1;
    private static String pl2;
    
    
    public static void main(String[] args)
    {
        //Game starts here, player 1 and player 2 will be names
        System.out.println("Chess game consisting ALL the pieces for Player 1, and Player 2."+"\n"+ "Enter QUIT to quit anytime, press any other key to start");
        String inp = input.next();
        if(inp.equals("QUIT")){
            System.out.println("Game over!!");
            System.exit(0);
        }
        //game is started
        game = new ChessGame();
        
        //player 1 
        System.out.println("Player 1, Enter name");
        inp = input.next();
        if(inp.equals("QUIT")){
            System.out.println("Game over!!");
            System.exit(0);
        }
        pl1 = inp;
        
        //player 2
        System.out.println("Player 2, Enter name");
        inp = input.next();
        if(inp.equals("QUIT")){
            System.out.println("Game over!! "+pl2+" has quit the game, the winner is "+pl1);
            System.exit(0);
        }
        pl2 = inp;
        
        //chessboard is printed
        game.getBoard().PrintBoard();
        
        
        //loop that will go round for the chessgame taking turns
        while(!inp.equals("QUIT")){
            
            
            //interface loop for plater 1
            System.out.println("\n\n" + "This is your board," +pl1+ " make a move" + "\n" 
            + "Enter the current location of the piece you wish to move: Row[]");
            inp = input.next();
            if(inp.equals("QUIT")){
                System.out.println("Game over!! "+pl1+" has quit the game, the winner is "+pl2);
                System.exit(0);
            }
            int row = Integer.parseInt(inp);
            
            System.out.println("Enter the current location of the piece you wish to move : Row["+row +"], Col[]");
            inp = input.next();
            if(inp.equals("QUIT")){
                System.out.println("Game over!! "+pl1+" has quit the game, the winner is "+pl2);
                System.exit(0);
            }
            int col = Integer.parseInt(inp);
            //location of current piece to be moved
            ChessLocation location = new ChessLocation(row, col);
            
            //will loop till player1 chooses a valid piece
            while(game.getBoard().getPieceAt(location).getOwner() == "P2"){
                System.out.println("That piece is not yours, choose a valid piece");
                System.out.println("Enter the current locaiton of the piece you wish to move : Row[]");
                inp = input.next();
                if(inp.equals("QUIT")){
                    System.out.println("Game over!! "+pl1+" has quit the game, the winner is "+pl2);
                    System.exit(0);
                }
                row = Integer.parseInt(inp);
                System.out.println("Enter the current location of the piece you wish to move : Row["+row+"], Col[]");
                inp = input.next();
                if(inp.equals("QUIT")){
                    System.out.println("Game over!! "+pl1+" has quit the game, the winner is "+pl2);
                    System.exit(0);
                }
                col = Integer.parseInt(inp);
                location.setLocation(row, col);
            }
            char id = game.getBoard().getPieceAt(location).id;
            System.out.println("You have chosen " +id);
            
            //location of where to be moved
            System.out.println("Enter the location you wish to move to: Row[]");
            inp = input.next();
            if(inp.equals("QUIT")){
                System.out.println("Game over!! "+pl1+" has quit the game, the winner is "+pl2);
                System.exit(0);
            }
            int destRow = Integer.parseInt(inp);
            System.out.println("Enter the location you wish to move to: Row["+destRow+"], Col[]");
            inp = input.next();
            if(inp.equals("QUIT")){
                System.out.println("Game over!! "+pl1+" has quit the game, the winner is "+pl2);
                System.exit(0);
            }
            int destCol = Integer.parseInt(inp);
            
            //destination is created
            ChessLocation destination = new ChessLocation(destRow, destCol);
            
            //if destination is empty, piece will be moved
            if(game.getBoard().isPieceAt(destRow, destCol) == false){
                game.getBoard().getPieceAt(location).moveTo(destination);
                game.getBoard().PrintBoard();
            }
            
            
            //if destination is occupied, test is done to see if enemy or player piece
            else if(game.getBoard().isPieceAt(destRow, destCol) == true){
                
                //if it's player, it will loop till a valid location is found
                while(game.getBoard().getPieceAt(destination).getOwner() == "P1"){
                    System.out.println("That space is occupied by one of your pieces, Try Again!");
                    System.out.println("Enter the location you wish to move to: Row[]");
                    inp = input.next();
                    if(inp.equals("QUIT")){
                        System.out.println("Game over!! "+pl1+" has quit the game, the winner is "+pl2);
                        System.exit(0);
                    }
                    destRow = Integer.parseInt(inp);
                    System.out.println("Enter the location you wish to move to: Row["+destRow+"], Col[]");
                    inp = input.next();
                    if(inp.equals("QUIT")){
                        System.out.println("Game over!! "+pl1+" has quit the game, the winner is "+pl2);
                        System.exit(0);
                    }
                    destCol = Integer.parseInt(inp);
                    destination.setLocation(destRow, destCol);
                }
                
                // when a valid empty spot is entered, it will move
                if(game.getBoard().isPieceAt(destRow, destCol) == false){
                    game.getBoard().getPieceAt(location).moveTo(destination);
                    game.getBoard().PrintBoard();
                }
                
                //if an enemy is there, it will be captured
                if(game.getBoard().getPieceAt(destination).getOwner() == "P2")
                {
                    if(game.getBoard().getPieceAt(destination).getID() == 'k'){
                        game.getBoard().removePiece(destination);
                        game.getBoard().getPieceAt(location).moveTo(destination);
                        game.getBoard().PrintBoard();
                        System.out.println("\n\n"+pl2+"'s king has been captured! Winner is "+pl1);
                        System.exit(0);
                    }
                }
            }
            
            
            
            
            //interface loop for player2
            System.out.println("\n\n" + "This is your board," +pl2+ " make a move" + "\n" 
            + "Enter the current location of the piece you wish to move: Row[]");
            inp = input.next();
            if(inp.equals("QUIT")){
                System.out.println("Game over!! "+pl2+" has quit the game, the winner is "+pl1);
                System.exit(0);
            }
            row = Integer.parseInt(inp);
            System.out.println("Enter the current location of the piece you wish to move : Row["+row +"], Col[]");
            inp = input.next();
            if(inp.equals("QUIT")){
                System.out.println("Game over!! "+pl2+" has quit the game, the winner is "+pl1);
                System.exit(0);
            }
            col = Integer.parseInt(inp);
            location.setLocation(row, col);
            while(game.getBoard().getPieceAt(location).getOwner() == "P1"){
                System.out.println("That piece is not yours, choose a valid piece");
                System.out.println("Enter the current locaiton of the piece you wish to move : Row[]");
                inp = input.next();
                if(inp.equals("QUIT")){
                    System.out.println("Game over!! "+pl2+" has quit the game, the winner is "+pl1);
                    System.exit(0);
                }
                row = Integer.parseInt(inp);
                System.out.println("Enter the current location of the piece you wish to move : Row["+row+"], Col[]");
                inp = input.next();
                if(inp.equals("QUIT")){
                    System.out.println("Game over!! "+pl2+" has quit the game, the winner is "+pl1);
                    System.exit(0);
                }
                col = Integer.parseInt(inp);
                location.setLocation(row, col);
            }
            id = game.getBoard().getPieceAt(location).id;
            System.out.println("You have chosen " +id);
            
            //looping to figure out place to move to
            System.out.println("Enter the location you wish to move to: Row[]");
            inp = input.next();
            if(inp.equals("QUIT")){
                System.out.println("Game over!! "+pl2+" has quit the game, the winner is "+pl1);
                System.exit(0);
            }
            destRow = Integer.parseInt(inp);
            System.out.println("Enter the location you wish to move to: Row["+destRow+"], Col[]");
            inp = input.next();
            if(inp.equals("QUIT")){
                System.out.println("Game over!! "+pl2+" has quit the game, the winner is "+pl1);
                System.exit(0);
            }
            destCol = Integer.parseInt(inp);
            destination = new ChessLocation(destRow, destCol);
            
            //if destination is empty, it will move
             if(game.getBoard().isPieceAt(destRow, destCol) == false){
                game.getBoard().getPieceAt(location).moveTo(destination);
                game.getBoard().PrintBoard();
            }
            
            //if destination is not empty, there will be a check to see if it's an enemy or player
            else if(game.getBoard().isPieceAt(destRow, destCol) == true){
                
                //if player piece, it loops till a valid piece is chosen
                while(game.getBoard().getPieceAt(destination).getOwner() == "P2"){
                    System.out.println("That space is occupied by one of your pieces, Try Again!");
                    System.out.println("Enter the location you wish to move to: Row[]");
                    inp = input.next();
                    if(inp.equals("QUIT")){
                        System.out.println("Game over!! "+pl2+" has quit the game, the winner is "+pl1);
                        System.exit(0);
                    }
                    destRow = Integer.parseInt(inp);
                    System.out.println("Enter the location you wish to move to: Row["+destRow+"], Col[]");
                    inp = input.next();
                    if(inp.equals("QUIT")){
                        System.out.println("Game over!! "+pl2+" has quit the game, the winner is "+pl1);
                        System.exit(0);
                    }
                    destCol = Integer.parseInt(inp);
                    destination.setLocation(destRow, destCol);
                }
                
                //if empty, moves
                if(game.getBoard().isPieceAt(destRow, destCol) == false){
                    game.getBoard().getPieceAt(location).moveTo(destination);
                    game.getBoard().PrintBoard();
                }
                
                //if enemy is there, it captures enemy piece
                if(game.getBoard().getPieceAt(destination).getOwner() == "P1")
                {
                    if(game.getBoard().getPieceAt(destination).getID() == 'K'){
                        game.getBoard().removePiece(destination);
                        game.getBoard().getPieceAt(location).moveTo(destination);
                        game.getBoard().PrintBoard();
                        System.out.println("\n\n"+pl1+"'s king has been captured! Winner is "+pl2);
                        System.exit(0);
                    }
                    else{
                        game.getBoard().removePiece(destination);
                        game.getBoard().getPieceAt(location).moveTo(destination);
                        game.getBoard().PrintBoard();
                    }
                }
            }
        }
    }
}
