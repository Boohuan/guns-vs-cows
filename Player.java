import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Player extends Actor
{
    float time;
    float projectileResetTimer;
    float laserChargeTime;
    float runAnimTimer = 0;
    
    int projAngle;
    int playerHeight = 156;
    int playerWidth = 112;
    int laserSfxTimer = 0;
    int laserDroneSfxTimer = 0;
    
    boolean canMove = true;
    boolean isChargingLaser = false;
    boolean laserKeyPressed = false;
    boolean laserShootSfx = true;
    boolean musicPlaying = false;
    boolean shootingProjectile = false;
    
    
    public Player(){
        projectileResetTimer = 40;
        getImage().scale(playerWidth, playerHeight);
        
    }
          
    public void act()
    {   
        time++;
        laserChargeTime++;
        getProjectileInputs();
        getLaserInputs();
        playSfx();
        GreenfootSound music = new GreenfootSound("Music.mp3");
        if(!musicPlaying){
            music.setVolume(50);
            music.playLoop();
            musicPlaying = true;
        }
             if(canMove){
            movement();
            laserSfxTimer = 0; 
            laserDroneSfxTimer = 0;
            laserShootSfx = true;
        } 
    }
    
    public void getLaserInputs(){
        
        if(Greenfoot.isKeyDown("U") && !Greenfoot.isKeyDown("J")
            && !Greenfoot.isKeyDown("L") && !Greenfoot.isKeyDown("O") && !Greenfoot.isKeyDown("I")){
            Actor playerLaser = new PlayerLaser();
            getWorld().addObject(playerLaser, getX()-170, getY());     
        }
        if(Greenfoot.isKeyDown("O") && !Greenfoot.isKeyDown("J")
            && !Greenfoot.isKeyDown("L") &&!Greenfoot.isKeyDown("U") && !Greenfoot.isKeyDown("I")){
                
            Actor playerLaser = new PlayerLaser();
            getWorld().addObject(playerLaser, getX()+170, getY());    
            
        }
        if(Greenfoot.isKeyDown("I") && !Greenfoot.isKeyDown("O") && !Greenfoot.isKeyDown("J")
            && !Greenfoot.isKeyDown("L") &&!Greenfoot.isKeyDown("U")){                      
            laserChargeTime++;
            setImage("LaserCharge.png");
            getImage().scale(playerWidth, playerHeight);
            isChargingLaser = true;
            canMove = false;
            
            if(laserChargeTime>90){
                Actor playerUpLaser = new PlayerUplaser();
                getWorld().addObject(playerUpLaser, getX()+3,getY()-285);
                setImage("LaserShoot.png");
                getImage().scale(playerWidth, playerHeight);
                laserChargeTime = 90;
                }
  
        }
         else{
            laserChargeTime = 0;
            isChargingLaser = false;                    
            } 
         if (!Greenfoot.isKeyDown("L") && !Greenfoot.isKeyDown("J") && !Greenfoot.isKeyDown("I"))
        {
            canMove = true;
        }
    }
    
    public void playSfx(){
        GreenfootSound droneSound = new GreenfootSound("LaserShoot.mp3");
        if(Greenfoot.isKeyDown("I") &&!Greenfoot.isKeyDown("O") && !Greenfoot.isKeyDown("J")
            && !Greenfoot.isKeyDown("L") &&!Greenfoot.isKeyDown("U") && laserSfxTimer <= 0){
                
            Greenfoot.playSound("LaserCharge.mp3");
            laserSfxTimer = 90;
            
                                    
        }  
        if(!Greenfoot.isKeyDown("I")){
           
            laserDroneSfxTimer = 10;
                            
        }
        if(laserChargeTime>=90 && laserDroneSfxTimer <= 0){
            
            droneSound.play();
            laserDroneSfxTimer = 90;
            
        }
    }
    
    public void getProjectileInputs(){
        
        if (Greenfoot.isKeyDown("J") && time>projectileResetTimer && !Greenfoot.isKeyDown("I")) {
            
            getWorld().addObject(new PlayerProjectileLeft(), getX()-50, getY()-40);
            time = 0;
            
        }
        if (Greenfoot.isKeyDown("L") && time>projectileResetTimer && !Greenfoot.isKeyDown("I")) {
            
            getWorld().addObject(new PlayerProjectile(), getX()+50, getY()-40);
            time = 0;
            
        }
        if (Greenfoot.isKeyDown("L")){
            canMove = false;
            shootingProjectile = true;
            setImage("ProjectileRight.png");
            getImage().scale(playerWidth, playerHeight);
        }
        else if(!Greenfoot.isKeyDown("J") && !Greenfoot.isKeyDown("I")){
            canMove = true;
            shootingProjectile = false;
        }    
        if (Greenfoot.isKeyDown("J")){
            setImage("ProjectileLeft.png");
            getImage().scale(playerWidth, playerHeight);
            canMove = false;
            shootingProjectile = true;
        }
        else if(!Greenfoot.isKeyDown("L") && !Greenfoot.isKeyDown("I")) {
            canMove = true;
            shootingProjectile = false;
        }
    }
    
    public void movement(){
        
        if (Greenfoot.isKeyDown("A")) {
            move(-3);       
            runAnimTimer ++;
            if(runAnimTimer <= 8){
                
                setImage("Run1.png");
                getImage().scale(playerWidth, playerHeight);
                
            }
            else if(runAnimTimer > 16){
                
                setImage("Run2.png");
                getImage().scale(playerWidth, playerHeight);
                
            }
            if(runAnimTimer > 30){
                
                runAnimTimer = 0;
                
            }
            

        }
        if (Greenfoot.isKeyDown("D")) {
            move(3);
            runAnimTimer ++;
            if(runAnimTimer <= 8){
                
                setImage("Run3.png");
                getImage().scale(playerWidth, playerHeight);
                
            }
            else if(runAnimTimer > 16){
                
                setImage("Run4.png");
                getImage().scale(playerWidth, playerHeight);
                
            }
            if(runAnimTimer > 30){
                
                runAnimTimer = 0;
                
            }
        }
        if (!Greenfoot.isKeyDown("A") && !Greenfoot.isKeyDown("D") && !isChargingLaser)
        {
            setImage("Idle.png");
            getImage().scale(playerWidth, playerHeight);
        }
    }
}
