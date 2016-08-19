import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster here.
 * 
 * @author Olaf Sielemann
 * @version April 2015
 */
public class Monster extends Wesen{
    int energie=30;
    /**
     * Act - do whatever the Monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
		bewegen();
        // Steuerung mit den Tasten Q, W, E und S
        if(Greenfoot.isKeyDown("E"))
            dreheRechts();
        else if(Greenfoot.isKeyDown("Q"))   
            dreheLinks();
        else if(Greenfoot.isKeyDown("W"))
            pillAufnehmen();
        else if(Greenfoot.isKeyDown("S")){
            slimefleckErzeugen();
            bewegen();
        }
    }    
       
    /**
	 * Das Monster nimmt eine Pille auf, der auf dem aktuellen Feld liegt.
	 */
    public void pillAufnehmen(){
      Actor pill = getOneObjectAtOffset(0, 0, Pill.class);
      if(pill != null){
         energie = energie + ( 10 * Greenfoot.getRandomNumber(3));
		 getWorld().removeObject(pill);
		 
      }
    }
}
