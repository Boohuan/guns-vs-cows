import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class PlayerProjectile extends Actor
{
    /**
     * 
     */
    public PlayerProjectile()
    {
        
        getImage().scale(20, 15);      
    }

    /**
     * 
     */
    public void act()
    {
        
        move(10);
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
        
    }  
}
