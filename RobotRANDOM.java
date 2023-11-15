import java.util.Random;
import java.util.ArrayList;
import java.util.List;
/**
 * The mother class of the specific robots.
 * This class represents a random-moving robot.
 * 
 * @author Groupe12-COOPOO - Clara
 * @version 25/10/23
 */
public class RobotRANDOM extends Robot {
    private int x = 5; // Initial X coordinate
    private int y = 5; // Initial Y coordinate
    static private Random randomGenerator;

    public RobotRANDOM(int x, int y) {
    super(x, y, 2, 2, "BLACK"); // Appel du constructeur de la classe mère
    super.changeHeadColor("BLACK"); // Définition de la couleur de la tête 
    this.x = x;
    this.y = y;
    randomGenerator = new Random(); // Initialisation du générateur de nombres aléatoires
}



    /**
     * Generates the next random step for the robot and updates its coordinates.
     */
    public void setNextStep() {
        int direction = randomGenerator.nextInt(4); // Generate a random direction

        switch (direction) {
            case 0:
                if (y > 0) this.y--; // Move up
                break;
            case 1:
                if (x < 10) this.x++; // Move right
                break;
            case 2:
                if (y < 10) this.y++; // Move down
                break;
            case 3:
                if (x > 0) this.x--; // Move left
                break;
        }

        super.setX(this.x); // Update X coordinate
        super.setY(this.y); // Update Y coordinate
        // Change the body and head color of the robot
        super.changeColor("BLACK");
        super.changeHeadColor("BLACK");
    }

    /**
     * Move the robot to its new coordinates and draw it.
     * 
    */
    public void avancer() {
        drawRobot(this.x, this.y); // 
    }

}