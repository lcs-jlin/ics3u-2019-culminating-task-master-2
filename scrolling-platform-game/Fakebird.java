import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BelowGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fakebird extends Decoration
{
    /**
     * Constructor
     * 
     * Called once when object is created.
     */
   Fakebird(int scrollableWorldX, int scrollableWorldY)
    {
        super(scrollableWorldX, scrollableWorldY);
    }    
    /**
     * Act - do whatever the GroundBelow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isTouching(MetalPlate.class))
        {
            turn(180);
        }
        move(-2);
    }    
}