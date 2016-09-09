import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Held here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Held extends Wesen
{
    /**
     * Act - do whatever the Held wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Held(){}
    
    int energie=0;
    boolean alive=true;
    
    public void act(){
        if(alive){
            bewegen();
            // Steuerung mit den Tasten W, A, S und D
            if(Greenfoot.isKeyDown("D"))
                dreheRechts();
            else if(Greenfoot.isKeyDown("A"))   
                dreheLinks();
            if(isTouching(Pill.class))
                pillAufnehmen();
            if(isTouching(Monster.class))
                alive = false;
        }
    }  
    
    public void pillAufnehmen(){
        Actor pill = getOneObjectAtOffset(0, 0, Pill.class);
        if(pill != null){
            energie = energie + ( 10 * Greenfoot.getRandomNumber(3));
            getWorld().removeObject(pill);
            energie = energie + 1;
        }
    }
}
