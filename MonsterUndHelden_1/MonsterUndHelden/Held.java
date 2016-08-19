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
    int energie=30;
    
    public void act(){
        bewegen();
        // Steuerung mit den Tasten W, A, S und D
        if(Greenfoot.isKeyDown("D"))
            dreheRechts();
        else if(Greenfoot.isKeyDown("A"))   
            dreheLinks();
        else if(Greenfoot.isKeyDown("W"))
            pillAufnehmen();
        else if(Greenfoot.isKeyDown("S")){
            slimefleckErzeugen();
            bewegen();
        }
    }  
    
    public void pillAufnehmen(){
        Actor pill = getOneObjectAtOffset(0, 0, Pill.class);
        if(pill != null){
            energie = energie + ( 10 * Greenfoot.getRandomNumber(3));
            getWorld().removeObject(pill);
        }
    }
}
