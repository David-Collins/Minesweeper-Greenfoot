import greenfoot.*;

/**
 * Screen that shows if you win the game
 * 
 * WinScreen Class
 * 
 * @author David Collins
 */
public class winScreen extends World
{
    public winScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(540, 540, 1); 
    }
    /**
     * Just changes the world to win screen and has option to restart game
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("r"))
        {
                Minefield newer = new Minefield();
                Greenfoot.setWorld(newer);
        }
    }
}
