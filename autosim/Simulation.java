import java.util.Scanner;

public class Simulation {
    
    public void simulate() {
        Fahrzeug f1 = new Fahrzeug();
        Scanner scan = new Scanner(System.in);
        int motorset = 0;
        int incfuel = 0;
        
        f1.printInfo();
        while (f1.lives()) {
            f1.printInfo();
            System.out.println("Motor an? (1/0)");
            motorset = scan.nextInt();
            System.out.println("Tanken? (1/0)");
            incfuel = scan.nextInt();
            if (motorset == 1){
                f1.motorstatus = true;
            } else if (motorset == 0){
                f1.motorstatus = false;
            }
            if (incfuel == 1){
                f1.increaseFuel = true;
            } else if (incfuel == 0){
                f1.increaseFuel = false;
            }
            f1.run();
        }
        f1.motorstatus = false;
        System.out.println("Ende der Simulation.");
        f1.printInfo();
    }
}
