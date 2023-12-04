import lang.stride.*;
import java.util.*;
import greenfoot.*;
import java.util.concurrent.TimeUnit;

/**
 * 
 */
public class PlayerLaser extends Actor
{
    public int lifetime = 5;
    
    public PlayerLaser(){
        
        getImage().scale(500,8); 
        
    }
    
    public void act()
    {
        
        lifetime --;
        
        if(lifetime <= 0){
            
            getWorld().removeObject(this);
            
        }
    }
}
