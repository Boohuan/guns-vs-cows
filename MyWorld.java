import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {
        super(1200, 600, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player =  new Player();
        addObject(player, 295, 255);
        PlayerLaser playerLaser =  new PlayerLaser();
        addObject(playerLaser, 204, 156);
        playerLaser.setLocation(267, 165);
        removeObject(playerLaser);
        player.setLocation(504, 368);
        player.setLocation(595, 438);
        player.setLocation(603, 420);
    }
}
