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
       
        createWalls();
        verteilePillen();
    }
    
    private void createWalls(){
        for (int k = 1; k < 13; k++){
            if (k % 2 == 1) {
                for (int i = 1; i < 9; i++){
                    addObject(new Wall(), k,i);
                }
            }
        }
    }
  
    private void verteilePillen(){
       for (int x = 0; x < 15; x++){
           for (int y = 0; y < 11; y++){
               java.util.List objectsList = getObjectsAt(x,y,null);
               if (objectsList.isEmpty()){
                   addObject(new Pill(), x,y);
               }
           }
       }
    }
}