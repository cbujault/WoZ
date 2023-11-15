import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente une liste de robots et permet de gérer leurs mouvements et éviter les collisions.
 * 
 * @author Groupe12-COOPOO
 * @version 0.01
 */
public class RobotList {
    private static ArrayList<Robot> ListRobots;
    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 10;
    private CanvasRobot canvasrobot;
    private String name;
    private int x;
    private int y;

    /**
     * Constructs a new RobotList, initializing the list of robots.
     */
    public RobotList() {
        ListRobots = new ArrayList<Robot>();
    }

    
    /**
     * Ajouter automatiquement tous les robots
     */
    public void addAllRobot(){
        // Creation of RobotRANDOM
        RobotRANDOM robot1 = new RobotRANDOM (1, 1);
        ListRobots.add(robot1);
        robot1.setList(this);
        
        // If you wish to test the collission with more than one  
        // random robot, just remove the following side sections
        // Warning: if two robots have the same coordinates
        //a game overs is created.
        
        /**
        RobotRANDOM robot2 = new RobotRANDOM(5, 5);
        ListRobots.add(robot2);
        robot1.setList(this);
        */    
       
       /**
        RobotRANDOM robot3 = new RobotRANDOM(6, 8);
        ListRobots.add(robot3);
        robot1.setList(this);
        */ 
    }

    
   
    /**
     * Method to avoid collisions between robots.
     *
     * @param r Un robot.
     * @return True si une collision est évitée, sinon false.
     */
    private boolean robotCollision(Robot r) {
        boolean collision = false;
        int ox = r.getX();
        int oy = r.getY();
        for (Robot e : ListRobots) {
            if (e != r) {
                int vx = e.getX();
                int vy = e.getY();
                if (ox == vx && oy == vy) {
                    collision = true;
                    break;
                }
            }
        }
        return collision;
    }

    /**
     * Moves each robot in the list.
     *
     * @throws InterruptedException if interrupted during movement.
     */
    public void moveAll() throws InterruptedException {
        for (Robot theRobot : ListRobots) {
            theRobot.setNextStep();
            if (robotCollision(theRobot)) {
                break;
            } else {
                theRobot.avancer();
            }
        }
    }
   
    /**
     * Continuously executes the movement of each robot in the list, with a 1 second pause between each iteration.
     * This method is designed for indefinite execution of robot motion, and is likely to enter an infinite loop.
     * Collisions between robots are managed, and the motion is interrupted in the event of a collision.
     *
     * @throws InterruptedException If execution is interrupted during movement (for example, with a thread interrupt).
     */
    public void moveINFINIT() throws InterruptedException {
        while (true) {
            moveAll();
            TimeUnit.MILLISECONDS.sleep(1000);
        }
    }
    

    /**
     * Checks whether a given position is valid and avoids collisions.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @return True if the position is valid, otherwise false.
     */
    public static boolean checkthePosition(int x, int y) {
        if (x > MAX_POSITION || y > MAX_POSITION || x < MIN_POSITION || y < MIN_POSITION)
            return false;
        for (Robot robot : ListRobots) {
            if (robot.getX() == x && robot.getY() == y)
                return false;
        }
        return true;
    }
}
