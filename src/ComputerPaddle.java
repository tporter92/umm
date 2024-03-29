import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

//BackgroundImage=space.png
//Player1Ship=P1.jpg
//Player2Ship=P2.jpg

public class ComputerPaddle implements Paddle {
	double y, yVel;
    boolean upAccel, downAccel;
    int player, x;
    final double GRAVITY = 0.94;
    Ball b1;
    Graphics gfx;
    Image img;
    
    public ComputerPaddle(int player, Ball b){
        upAccel = false; downAccel = false;
        b1 = b;
        y=210; yVel = 0;
        if(player==1)
            x=20;
        else
            x=660;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, (int)y, 20, 80);
        
    }
    
    
    public void move() {
    	y=b1.getY()-40;
        if(y<0)
        	y=0;
        if(y>420)
        	y=420;
    }
    
    public int getY() {
        return (int)y;
    }

}