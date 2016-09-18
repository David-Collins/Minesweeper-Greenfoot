import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bombs that are placed that you are trying to avoid clicking on
 * 
 * Bomb class
 * 
 * @author David Collins
 */
public class Bomb extends Actor
{
    private boolean lose;
    public Bomb()
    {
        super();
        setImage("tile.png");
    }
    /**
     * action that takes place when each tile is clicked
     * if it is left click, and it is not flagged, it will trigger the lose screen saying you lost
     * if it is a right click, then it flags the bomb, unallowing it to be clicked
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
                this.setImage("bomb.png"); 
                loseScreen lost = new loseScreen();
                Greenfoot.setWorld(lost);
                lose = true;
            }
            if(mouse.getButton() == 3 && !isFlagged)
            {
                field.addObject(f, this.getX(), this.getY());
                isFlagged = true;
            }
           
        }
    }
}
