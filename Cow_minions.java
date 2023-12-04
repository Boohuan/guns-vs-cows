import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Cow_minions extends Actor
{
    GifImage Cow_minions;
    GreenfootImage myImage1;
    private boolean destroyed;
    private int health = 10;

    public Cow_minions() {
        Cow_minions = new GifImage("cow_enemy.gif");
        
    }
    public void act()
    {
        // Add your action code here.
        move(1);
        myImage1 = Cow_minions.getCurrentImage();
        myImage1.scale(110,110);
        setImage(myImage1);
        Cow_minions.getImages().size();
    }
}
