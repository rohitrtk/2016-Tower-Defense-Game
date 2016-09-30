import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This class will be used as a label to display the money the player has
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class Money extends GUI
{
    int mula;
    GreenfootImage image;                   // A greenfoot image to display text
    Color colour;                           // Colour object for the background
    
    public Money(World world, int x, int y, int mula)
    {
        super(world, x, y);
        
        this.mula = mula;
        colour = new Color(0f, 0f, 0f ,0f);         // Transparent colour!
        image = new GreenfootImage("$$$: " + mula, 30, Color.GREEN, colour); // Makes the image a string with a transparent background
        
        setImage(image);
        
        world.addObject(this, x, y);
    }
    
    /**
     * Act - do whatever the Money wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        image = new GreenfootImage("$$$: " + mula, 30, Color.GREEN, colour);
        
        setImage(image);
    }   
    
    /**
     * Sets the current money to the parameter
     * @param int mula
     * @return void
     */
    public void setMula(int mula)
    {
        this.mula = mula;
    }
    
    /**
     * Gets the current round 
     * @return int mula
     */
    public int getMula()
    {
        return mula;
    }  
}
