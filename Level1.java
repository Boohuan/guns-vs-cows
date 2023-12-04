import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Level1 extends World
{

    /**
     * Constructor for objects of class Level1.
     */
    public Level1()
    {
        super(640, 350, 1);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,560,271);
        Cow_minions cow_minions = new Cow_minions();
        addObject(cow_minions,93,275);
        cow_minions.setLocation(93,264);
    }
}
