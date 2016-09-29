import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A tower the user can place down, this tower will shoot a bullet but may be more in accurate than the basic tower
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class WaterTowerButton extends TowerButton
{
    /**
     * Constructs a new tower button
     * @param World world
     * @param int x position
     * @param int y position
     */
    public WaterTowerButton(World world, int x, int y)
    {
        super(world, x, y);
    }
    
    /**
     * Act - do whatever the TowerButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {       
        
       MouseInfo mouse = Greenfoot.getMouseInfo();
      
       // If the mouse is doing something
       if(mouse != null)
       {
          // If the mouse is clicked on top of the button, spawn a new tower
          if(Greenfoot.mouseClicked(this))
          {
              // If the mouse is clicked on top of the button, spawn a new tower
              tempTower = new WaterTower(this.world, mouse.getX(), mouse.getY());
              towers.add(tempTower);
          }
          
          if(Greenfoot.mouseDragged(tempTower) && (towers != null))
          {
              // If the mouse is dragged on top of the temp tower that was just spawned
              //System.out.println(towers.size());
              towers.get(towers.size() - 1).setLocation(mouse.getX(), mouse.getY());
            }
       }
    }
}
