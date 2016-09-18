import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Tile class. Pretty much everything on the minefield that isn't a bomb or flag. Clicking on it reveals how many bombs are nearby
 * 
 * Tile Class
 * 
 * @author David Collins
 */
public class Tile extends Actor
{
    World w;
    private int numOpened;
    public boolean isShown;
    public Tile()
    {
        super();
        setImage("tile.png");
        isShown = false;
    }
    /**
     * Action that takes place when each tile is clicked
     * 
     * If it is left click, it checks how many bombs are surrounding it, and if there are none, it run the floodFill method
     * 
     * If it is a right click, then it flags the tile, unallowing it to be clicked
     */
    public void act() 
    {
        boolean isFlagged = false;
        MouseInfo mouse = Greenfoot.getMouseInfo();
        Minefield field = (Minefield)(getWorld());
        
        if(Greenfoot.mouseClicked(this))
        {
            Flag f = new Flag();
            if(mouse.getButton() == 1 && !isFlagged)
            {
                floodFill(this);
                field.checkWin();
            }
            if(mouse.getButton() == 3 && !isFlagged && !isShown)
            {
                field.addObject(f, this.getX(), this.getY());
                isFlagged = true;
            }
        }
        
    }
    /**
     * If there is 1 or more bombs surrounding the tile, it runs this method to check how many bombs are surrounding the tile and sets the image accordingly
     */
    public void check(Tile t)
    {
        List<Object> bombs = t.getNeighbours(1, true, Bomb.class);
        t.isShown = true;
        switch (bombs.size()) 
                {
                    case 1: t.setImage("one.gif"); 
                             break;
                    case 2:  t.setImage("two.gif");
                             break;
                    case 3:  t.setImage("three.gif");
                             break;
                    case 4:  t.setImage("four.gif");
                             break;
                    case 5:  t.setImage("five.gif");
                             break;
                    case 6:  t.setImage("six.gif");
                             break;
                    case 7:  t.setImage("seven.gif");
                             break;
                    case 8:  t.setImage("eight.gif");
                             break;
                }
    }
    /**
     * This is the floodFill method
     * 
     * Assuming there are no surrounding bombs, it recursively checks all the tiles next to the tile clicked on to see if there is any bombs surrounding that
     * one, and if not, it calls the floodFill method on the spot, and this continues until it finds a tile that has one or bombs next to it.
     */
    public void floodFill(Tile t) 
    {
        List<Object> bombs = t.getNeighbours(1, true, Bomb.class);
        if(bombs.size() == 0)
        {
            t.isShown = true; 
            t.setImage("zero.gif");
            List<Object> tiles = t.getNeighbours(1, true, Tile.class);
            for(int i = 0; i < tiles.size(); i++)
            {
                Tile tile = (Tile)(tiles.get(i));
                if(!tile.isShown)
                {
                    t.floodFill(tile);
                }
            }
        }
        else
        {
            t.check(t);
        }
    } 
}
