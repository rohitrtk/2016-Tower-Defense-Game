import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Slow firing yet powerful tower
 *
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class BlackTower extends Tower
{
    public static final int cost = 1000;                   // The cost for the tower
    
     /**
     * Constructs a Tower
     * @param World world
     * @param int x position
     * @param int y position
     * @Override
     */
    public BlackTower(World world, int x, int y)
    {
        super(world, x, y);
        
        cooldownTime = 256;
        range = 350;                                                            // 'Default' range for tower, will be overriden
        world.addObject(this, x, y);                                  // Add this to object to the world
        isAbleToShoot = true;                                                   // This tower can shoot right now
        timer = 0;                 
        isDestroyed = false;
    }
    
    /**
     * Act - do whatever the FireTower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }       
}
