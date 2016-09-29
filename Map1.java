import greenfoot.*; 
import java.util.ArrayList;

/**
 * This class is where the actual game is housed, everything gameplay related
 * is based here.
 * 
 * @author Rohit Terry Kisto
 * @version 2016/9/30
 */
public class Map1 extends World
{    
    private Tile tiles[][];                             // 2D array of tiles, will be used to draw tiles on to the screen
    private static ArrayList<Waypoint> waypoints;       // Array list of waypoints, enemies will move towards waypoints
    private static int hp;                              // The players hp
    
    private int round;                                  // The current round the player is on
    private ArrayList<Enemy> enemies;                   // Array list of enemies currently in round
    
    private int enemNumber;                             // The max number of enemies in the round        
    private int timer;                                  // Timer for enemies spawning
    private boolean spawn;                              // Can the enemies spawn?
    
    Round roundGUI;
    PlayButton playButton;
    TowerButton towerButton;

    /**
     * This method constructs Map1 and initializes the world, the tiles on the world
     * the arraylist of waypoints and any enemies/towers
     */
    public Map1()
    {    
        // Create a new world with 780, 540 cells with a cell size of 1x1 pixels.
        // Cell width is 60 pixels each
        super(840, 540, 1); 
        
        mouse = Greenfoot.getMouseInfo();
        guiHandler();
        
        tiles = new Tile[10][14];                       // Sets width and height of tile map
        for(int i = 0;i < 10;i++)                       // Draws either a wall or dirt tile depending on its index number
        {
            for(int j = 0;j < tiles[i].length;j++)
            {
                if(((i == 0 || i == 1 || i == 2) && (j == 1)) || ((i == 2) && (j > 1 && j < 11)) ||
                (i == 3 || i == 4 || i == 5 || i == 5) && (j == 10) || (i == 6) && (j > 1 && j < 11) ||
                (i == 6 || i == 7 || i == 8 || i == 9) && (j == 1))
                {
                    tiles[i][j] = new Dirt(this, j * 60, i * 60);
                } else if(j < 11) {
                    tiles[i][j] = new Wall(this, j * 60, i * 60);
                }
            }
        }
        
        waypoints = new ArrayList<Waypoint>();          // Waypoint array list
        for(int i = 0;i < 6;i++)
        {
            switch(i)
            {
                case 0:
                    waypoints.add(i, new Waypoint(this, 1 * 60, -2 * 60));
                    break;
                case 1:
                    waypoints.add(i, new Waypoint(this, 1 * 60, 2 * 60));
                    break;
                case 2:
                    waypoints.add(i, new Waypoint(this, 10 * 60, 2 * 60));
                    break;
                case 3:
                    waypoints.add(i, new Waypoint(this, 10 * 60, 6 * 60));
                    break;
                case 4:
                    waypoints.add(i, new Waypoint(this, 1 * 60, 6 * 60));
                    break;    
                case 5:
                    waypoints.add(i, new Waypoint(this, 1 * 60, 9 * 60));
                    break;
            }
        }
        
        // Init other variables
        enemies = new ArrayList<Enemy>();
        enemNumber = 0;
        round = 0;
        hp = 100;
        timer = 0;
        spawn = true;
    }
    
    /**
     * This method is called when the Run button is pressed
     */
    public void act()
    {       
        spawnTower();
        spawnEnemy();
        roundGUI.setRound(round);
        MouseInfo mouse = Greenfoot.getMouseInfo();
    }
    
    /**
     * This method returns an arraylist of waypoints which will be used each enemy to determine where
     * they go
     * @return ArrayList<Waypoint> waypoints
     */
    public static ArrayList<Waypoint> getWaypoints()
    {
        return waypoints;
    }
    
    /**
     * This method sets the hp of the world, based on difficulty, the world will has an x amount of
     * hp
     * @param int hp
     * @return void
     */
    public static void setHp(int hp)
    {
        Map1.hp = hp;
    }
    
    /**
     * This method returns the hp of the world
     * @return int hp
     */
    public static int getHp()
    {
        return hp;
    }
    
    /**
     * This method handles all of the gui for the map
     * @return void
     */
    private void guiHandler()
    {
        Backdrop backdrop = new Backdrop(this, 12 * 60, 4 * 60);
        playButton = new PlayButton(this, 12 * 60 + 18, 8 * 60, false);
        roundGUI = new Round(this, 12 * 60, 20, round);
        towerButton = new WaterTowerButton(this, 12 * 60, 50);
    }

    /**
     * This method is responsible for spawning enenmies in the world
     * @return void
     */
    private void spawnEnemy()
    {
        if(spawn)
            {  
               if(enemNumber < (2 * round) + 3 && round != 0)
               {
                   enemies.add(enemNumber, new Rat2(this, waypoints.get(0).getX(), waypoints.get(0).getY()));
                   enemNumber++;
               } else if(!enemies.isEmpty()){
                   enemies.removeAll(enemies);
                   playButton.setIsPlaying(false);
               } else if(playButton.getIsPlaying())
               {
                   round++;
                   enemNumber = 0;
               }
               spawn = false;
               timer = 0;
            } else {
               timer++;
               if(timer % 60 == 0)
               {  
                   spawn = true;
               }
           }
    }
}