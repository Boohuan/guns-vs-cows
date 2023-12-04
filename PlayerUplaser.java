import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class PlayerUplaser extends Actor
{
    int lifetime = 5;
    
    /**
     * 
     */
    public PlayerUplaser()
    {
        getImage().scale(8, 500);
    }

    /**
     * Act - do whatever the PlayerUplaser wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        lifetime --;
        
        if(lifetime <= 0){
            
            getWorld().removeObject(this);
            
        }
    }
}
