import greenfoot.*;

/**
 * This class will act as the grunt of the rat army
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/21
 */
public class Rat1 extends Enemy
{
    /**
     * Constructs a new Rat1
     */
    public Rat1(World world, int x, int y)
    {
        super(world, x, y);
    }
    
    /**
     * Act - do whatever the Rat1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
    
    /**
     * This method will remove the enemy from the scene
     * @return void
     */
    public void destroy()
    {
        super.destroy();
    }
    
    /**
     * This method sets the move speed of an enemy
     * @param int moveSpeed
     */
    protected void setMoveSpeed(int moveSpeed) 
    {
        super.setMoveSpeed(moveSpeed);
    }
    
    /**
     * This method returns the move speed of an enemy
     * @return int moveSpeed
     */
    protected int getMoveSpeed()
    {
        return super.getMoveSpeed();
    }
}
