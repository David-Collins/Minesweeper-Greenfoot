import greenfoot.*;

/**
 * Screen that shows if you lose the game
 * 
 * LoseScreen Class
 * 
 * @author David Collins
 * 
 */
public class loseScreen extends World
{
    public loseScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(540, 540, 1); 
    }
    /**
     * Just changes the world to lose screen and has option to restart game
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
