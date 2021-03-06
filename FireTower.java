import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Super long range tower but has a chance of 'outting' upon bullet launch
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class FireTower extends Tower
{
    public static final int cost = 700;                   // The cost for the tower
    
    /**
     * Constructs a Tower
     * @param World world
     * @param int x position
     * @param int y position
     * @Override
     */
    public FireTower(World world, int x, int y)
    {
        super(world, x, y);
        
        range = 300;                                                  // 'Default' range for tower, will be overriden
        world.addObject(this, x, y);                                  // Add this to object to the world
        isAbleToShoot = true;                                         // This tower can shoot right now
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
