import java.awt.*;

public class Fahrzeug
{
    // instance variables - replace the example below with your own
    public  boolean motorstatus = false;
    private int fuel = 10;
    public boolean increaseFuel = false;
    public int winsum = 0;
    
    public void run() {
        if (motorstatus) {
            race();
            decreaseFuel();
        }
        if (increaseFuel) {
            increaseFuel();
        }
    }
    
    public boolean lives() {
        return fuel > 0;
    }
    
    public void printInfo() {
        System.out.println("Geld: "+winsum);
        if (motorstatus) {
            System.out.println("Motor ist an.");
        } else {
            System.out.println("Motor ist aus.");
        }

    }
    
    private void decreaseFuel() {
        fuel = fuel - 1;
    }
    
    private void race() {
        if (Math.random() > 0.75) {
            winsum = winsum + 1;
        }
    }
    
    private void increaseFuel() {
        fuel = fuel + 1;
        winsum = winsum - 1;
    }
}
