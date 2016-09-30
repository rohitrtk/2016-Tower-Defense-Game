import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Will be dropped when an enemy dies
 * 
 * @author Rohit Terry Kisto 
 * @version 2016/9/30
 */
public class LootDrop extends Bloodstain
{
    private final int[] lootWorths = new int[3];
    private final String[] paths = new String[3];
    
    public LootDrop(World world, int x, int y)
    {
        super(world, x, y);
        lootWorths[0] = 50;
        lootWorths[1] = 100;
        lootWorths[2] = 500;
        paths[0] = "50g.png";
        paths[1] =  "100g.png";
        paths[2] = "500g.png";
        
        double random = Math.ceil(Math.random() * 100);
        if(random == 0) 
        {
            setImage(paths[2]);
            Map1.setMoney(Map1.getMoney() + lootWorths[2]);
        } else if(random > 0 && random < 26) 
        {
            setImage(paths[1]);
            Map1.setMoney(Map1.getMoney() + lootWorths[1]);
        } else 
        {
            setImage(paths[0]);
            Map1.setMoney(Map1.getMoney() + lootWorths[0]);
        }
    }
    
    /**
     * Act - do whatever the Bloodstain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        timer++;
        if(timer > 100) destroy();
    }
    
    public void destroy()
    {
        super.destroy();
    }
}
