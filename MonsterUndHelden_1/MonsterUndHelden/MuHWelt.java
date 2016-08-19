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
    public MuHWelt()
    {
        super(14, 10, zellenGroesse);
        setBackground("images/Bodenplatte.png");
        setPaintOrder(Wesen.class, Pill.class, Wall.class);
        Greenfoot.setSpeed(20);
        
        // Welt einrichten
        // Kamproboter1 in linker, unterer Ecke
        Held held = new Held();
        addObject(held, 0,getHeight());
       
        verteilePillen();
    }
    
    private void verteilePillen(){
       addObject(new Pill(), 5,5);  
    }
    
       
  
}