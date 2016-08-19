import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.*;


/**
 * Diese Klasse ist die Oberklasse fuer die Monster "Franky", "Termi" und "Arni" Sowie die Helden "Johnny", "Arnold" und "Steven". 
 * Programme sollen nur in den Unterklassen 
 * implementiert werden, da diese Klasse fuer Java-Beginner sehr komplex ist.
 * Ein Monster kann sich felderweise in die vier Himmelsrichtungen im Szenario bewegen. 
 * Ueber Sensoren kann er Informationen ueber seine Umwelt erhalten.
 */

public abstract class Wesen extends Actor
{

    /**
     * Ein Objekt der Klasse Roboter wird exempliert bzw. instanziert.
     */
    public Wesen()
    {
    }
    
    
    /**
     * Der Roboter geht einen Schritt in die Pfeilrichtung.
     * Das macht er nur, wenn sich keine Wand vor ihm befindet oder
     * er nicht an der Grenze der Welt zur Grenze blickt.
     */
    
    public void bewegen(){
        int lRichtung = this.getRotation();
            
        if (this.kannBewegen()){   
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
                break;
            }
            
            Greenfoot.delay(1);
        }
    }

    
    /**
     * Das Wesen dreht sich um 90 Grad nach rechts (aus der Sicht des Wesens).
     */
    public void dreheRechts(){
            this.setRotation((getRotation()+90) % 360);
            Greenfoot.delay(1);
    }
    /**
     * Das Wesen dreht sich um 90 Grad nach links (aus der Sicht des Wesens).
     */
    public void dreheLinks(){
            this.setRotation((getRotation()-90) % 360);
            Greenfoot.delay(1);
    }
    
    
    /**
     * Das Wesen nimmt einen Akku auf. Dieser Akku muss sich auf seinem Feld befinden.
     */
    public void akkuAufnehmen(){
        Pill aktPill = (Pill)this.getOneObjectAtOffset(0, 0, Pill.class);
        if(aktPill != null){
                this.getWorld().removeObject(aktPill);
        }
    }
     
    
    
     /**
      * Das Wesen erzeugt einen Slimefleck auf dem aktuellen Feld
      */
    public void slimefleckErzeugen(){
        int x = getX();
        int y = getY();
        Slime slime = new Slime();
        // Slime an der Position des Wesens absondern
        getWorld().addObject(slime,x,y);
    }
    
    
    
     /**
     * Der Sensor ueberprueft, ob sich das Wesen bewegen kann.
     */     
    private boolean kannBewegen(){
        if (this.wandVorne()){
            return false;   
        }       
        if (this.getRotation() == 0 && this.getX() == this.getWorld().getWidth()-1){
            return false;   
        }                   
        if (this.getRotation() == 90 && this.getY() == this.getWorld().getHeight()-1){
            return false;   
        }        
        if (this.getRotation() == 180 && this.getX() == 0){
            return false;   
        }       
        if (this.getRotation() == 270 && this.getY() == 0){
            return false;   
        }         
        return true;
    }
    
     /**
     * Der Sensor ueberprueft, ob das Wesen nach rechts blickt.
     */  
    
    private boolean rechts(){
        if(this.getRotation()==0){
            return true;
        }
        else{
            return false;   
        }
    }
    
    private boolean links(){
        if(this.getRotation()==180){
            return true;
        }
        else {
            return false;
        }
    }
    
      /**
      * Der Sensor ueberprueft, ob auf dem Feld des Wesens ein Akku liegt.
      */  
    public boolean pillAufFeld (){
        if (this.getOneObjectAtOffset(0, 0, Pill.class)!= null){
           return true;     
        } 
        else{
            return false;   
        }
    }
    
   
    
    /**
      * Der Sensor ueberprueft, ob auf dem Feld des Wesens ein Slimefleck ist.
      */  
    public boolean slimefleckAufFeld (){
        if (this.getOneObjectAtOffset(0, 0, Slime.class)!= null){
           return true;     
        } 
        else{
            return false;   
        }
    }

   
    /**
     * Der Sensor ueberprueft, ob sich das Wesen an der Weltgrenze befindet und zur Grenze "blickt".
     */  
    protected boolean anGrenze(){
        if (this.getX()+1>=this.getWorld().getWidth() || this.getX()<=0){
			return true;
		}

        if (this.getY()+1>=this.getWorld().getHeight() || this.getY()<=0){
			return true;
		}
        
        return false;
    }
    
    
     /**
      * Der Sensor ueberprueft, ob sich in Laufrichtung des Wesens eine Wand befindet.
      */
     public boolean wandVorne(){
         int lRichtung = this.getRotation();
         
         if (lRichtung == 0 && this.getOneObjectAtOffset(1, 0, Wall.class)!= null){
            return true;     
         }
         
         if (lRichtung == 90 && this.getOneObjectAtOffset(0, 1, Wall.class)!= null){
            return true;     
         }
         
         if (lRichtung == 180 && this.getOneObjectAtOffset(-1, 0, Wall.class)!= null){
            return true;     
         }
         
         if (lRichtung == 270 && this.getOneObjectAtOffset(0, -1, Wall.class)!= null){
            return true;     
         }
         
         return false;
     } 

     /**
      * Der Sensor ueberprueft, ob sich rechts der Laufrichtung eine Wand befindet.
      */    
     private boolean wandRechts(){
         int lRichtung = this.getRotation();
         
         if (lRichtung == 0 && this.getOneObjectAtOffset(0, 1, Wall.class)!= null){
            return true;     
         }
         
         if (lRichtung == 90 && this.getOneObjectAtOffset(-1, 0, Wall.class)!= null){
            return true;     
         }
         
         if (lRichtung == 180 && this.getOneObjectAtOffset(0, -1, Wall.class)!= null){
            return true;     
         }
         
         if (lRichtung == 270 && this.getOneObjectAtOffset(1, 0, Wall.class)!= null){
            return true;     
         }
         
         return false;
     }

     
     /**
      * Der Sensor ueberprueft, ob sich linkss der Laufrichtung eine Wand befindet.
      */  
     private boolean wandLinks(){
         int lRichtung = this.getRotation();
         
         if (lRichtung == 0 && this.getOneObjectAtOffset(0, -1, Wall.class)!= null){
            return true;     
         }
         
         if (lRichtung == 90 && this.getOneObjectAtOffset(1, 0, Wall.class)!= null){
            return true;     
         }
         
         if (lRichtung == 180 && this.getOneObjectAtOffset(0, 1, Wall.class)!= null){
            return true;     
         }
         
         if (lRichtung == 270 && this.getOneObjectAtOffset(-1, 0, Wall.class)!= null){
            return true;     
         }
         
         return false;
     }
     
}