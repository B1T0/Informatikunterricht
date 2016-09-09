import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Die einzigen aktiven Akteure in der Monster und Heldenwelt MuHWelt sind Monster und Helden.
 * Die Welt besteht aus 14 * 10 Feldern.
 */

public class MuHWelt extends World
{
    private static int zellenGroesse = 50;
   
    /**
     * Erschaffe eine Welt mit 14 * 10 Zellen.
     */
    
    Held held = new Held();
    Monster intelliMonster = new Monster(true);
    Monster stupidMonster = new Monster(false);
    public MuHWelt()
    {
        super(14, 10, zellenGroesse);
        setBackground("images/Bodenplatte.png");
        setPaintOrder(Wesen.class, Pill.class, Wall.class);
        Greenfoot.setSpeed(20);
        
        // Welt einrichten
        // Kamproboter1 in linker, unterer Ecke
       
        addObject(held, 0,getHeight());
        addObject(intelliMonster, getWidth(),0);
        addObject(stupidMonster, getWidth(),getHeight()/2);
        
        createWalls();
        verteilePillen();
    }
    
    private void createWalls(){
        for (int k = 1; k < 13; k++){
            for (int i = 1; i < 9; i++){
                if(Greenfoot.getRandomNumber(4)==1)
                    addObject(new Wall(), k,i);
            }
        }
    }
  
    private void verteilePillen(){
       for (int x = 0; x < getWidth(); x++){
           for (int y = 0; y < getHeight(); y++){
               java.util.List objectsList = getObjectsAt(x,y,null);
               if (objectsList.isEmpty() && Greenfoot.getRandomNumber(4) == 1){
                   addObject(new Pill(), x,y);
               }
           }
       }
    }
    
    public int xHeld(){
        return held.getX();
    }
    
    public int yHeld(){
        return held.getY();
    }
}