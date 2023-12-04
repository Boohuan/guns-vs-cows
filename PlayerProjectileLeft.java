import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class PlayerProjectileLeft extends Actor
{
    /**
     * Act - do whatever the PlayerProjectileLeft wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PlayerProjectileLeft(){
        
        getImage().scale(20, 15);
        setRotation(180);
    }
    
    public void act()
    {
        
        move(10);
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
        
    }
    
}
