import greenfoot.*;

/**
 * Flags for when you want to mark a possible bomb
 * 
 * Flag class
 * 
 * @author David Collins
 */
public class Flag extends Actor
{
    /**
     * If you right click on it, it removes itself from the board, allowing you to click on the tile/
     * bomb again
     */
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        Minefield field = (Minefield)(getWorld());
        if(Greenfoot.mouseClicked(this))
        {
            if(mouse.getButton() == 3)
            {
                field.removeObject(this);
            }
        }
    }    
}
