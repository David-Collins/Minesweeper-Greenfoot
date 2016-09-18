import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage
import java.util.*;
/**
 * The field that hold all the bombs, tiles, and flags, also generates that world for you
 * 
 * Minefield
 * 
 * @author David Collins
 */
public class Minefield extends World 
{
    private ArrayList<Location> bombs;
    private int countTiles;
    /**
     * Creates the minefield itself
     * First creates the locations of the bombs, and makes sure that there are no repeated spaces
     * Then runs through the whole board adding Tiles, and if the location is where a bomb should be, places a bomb there instead
     */
    public Minefield() 
    {
       super(9, 9, 60);        
       setBackground("cell.jpg");
       int count =0;
       boolean not = true;
       ArrayList<Location> bombs = new ArrayList<Location>();
       while(count < 12) 
       {
           int a = (int)(Math.random() * 9);
           int b = (int)(Math.random() * 9);
           Location loc = new Location(a,b);
           for(int i = 0; i< bombs.size(); i++) 
           {
               if(bombs.get(i).equals(loc))
               {
                   not = false;
               }
           }
           if(not)
           {
               bombs.add(loc);
               count++;
           }
           not = true;
       }
       boolean not2 = true;
       for(int r = 0; r < 9; r++)
       {
           for(int c = 0; c < 9; c++)
           {
               Location loc2 = new Location(r, c);
               for(int b = 0; b< bombs.size(); b++) 
               {
                   if(bombs.get(b).equals(loc2))
                   {
                       not2 = false;
                       Bomb t = new Bomb();
                       addObject(t, r, c);
                    }
               }
               if(not2)
               {
                   Tile t = new Tile();
                   addObject(t, r, c);
                   countTiles++;
               }
               not2 = true;
           }
       }
    }
    /**
     * Checks for the conditions to win the game
     * If they are true, then it will show the win screen
     * Will be called by each tile method to see if all the tiles are showing
     */
    public void checkWin()
    {
        boolean isDone = true;
        List<Tile> tils = getObjects(Tile.class);
        for(Tile t: tils)
        {
            if(t.isShown == false)
            {
                isDone = false;
            }
        }
        if(isDone)
        {
            Greenfoot.setWorld(new winScreen());
        }
    }    
}