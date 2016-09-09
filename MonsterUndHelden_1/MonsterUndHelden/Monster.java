import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster here.
 * 
 * @author Olaf Sielemann
 * @version April 2015
 */
public class Monster extends Wesen{
    
    boolean intelligent;
    
    public Monster(boolean intelligence){
        if(intelligence){
            intelligent = true;
        } else {
            intelligent = false;
        }
    }
    
    /**
     * Act - do whatever the Monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        if(!isTouching(Held.class)){
            if(intelligent){
                turnToHeld();
            } else {
                turnRandom();
            }
            if(Greenfoot.getRandomNumber(3)<2)
                removeWall();
        }
    }    
    
    private void removeWall(){
        int lRichtung = this.getRotation();
        switch(lRichtung){
            case 0 :
                this.setLocation(getX() + 1, getY());
                break;
            case 90 :
                this.setLocation(getX(), getY()+1);
                break;
            case 180 :
                this.setLocation(getX()-1, getY());
                break;
            case 270 :
                this.setLocation(getX(), getY()-1);
        }
        removeTouching(Wall.class);
    }
    
    private void turnToHeld(){
        World world = getWorld();
        for (int x = 0; x < world.getWidth(); x++){
           for (int y = 0; y < world.getHeight(); y++){
               java.util.List objectsList = world.getObjectsAt(x,y,Held.class);
               if (!objectsList.isEmpty()){
                   turnTowards(x,y);
                   int rota = getRotation();
                   if(0 <= rota) setRotation(0);
                   if(45 <= rota) setRotation(90);
                   if(135 <= rota) setRotation(180);
                   if(225 <= rota) setRotation(270);
               }
           }
       }
    }
    
    private void turnRandom(){
        int randTurn = Greenfoot.getRandomNumber(9);
        if(randTurn < 6) setRotation(0);
        if(randTurn < 8) setRotation(90);
        if(randTurn < 10) setRotation(270);
    }
    
}
