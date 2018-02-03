
/**
 * Write a description of class ChessLocation here.
 * 
 * @author (Shaviyo Marasinghe) 
 * @version (Assignment 1: October 11th, 2016)
 */
public class ChessLocation
{
    private int row;
    private int col;
    /**
     * Accessor and mutator for the Location variables 
     */
    public ChessLocation(int row, int col)
    {
        if(row<=7){
            if(col<=7){
                this.row = row;
                this.col = col;
            }
        }
        else{
            System.out.print("Locaiton is out of bounds");
        }
    }
    
    public int getcol()
    {
        return col;
    }
    
    public int getrow()
    {
        return row;
    }
    
    public void setLocation(int r, int c){
        row = r;
        col = c;
    }
}
