import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.awt.*;  
import java.applet.*; 
import javax.swing.ImageIcon;

//BackgroundImage=space.png
//Player1Ship=P1.jpg
//Player2Ship=P2.jpg

public class SpacePongMain extends Applet implements Runnable, KeyListener{
	
    private static final long serialVersionUID = 1L; // IDK what this does 
    final int WIDTH = 700, HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    ComputerPaddle p2;
    Ball b1;
    boolean gamestart;
    Graphics gfx;
    Image img;
    
    public void init(){
    	img = getImage(getDocumentBase(),"space.png");
        this.resize(WIDTH, HEIGHT);
        gamestart=false;
        this.addKeyListener(this);
        p1 = new HumanPaddle(1);
        b1 = new Ball();
        p2 = new ComputerPaddle(2,b1);
        img = createImage(WIDTH, HEIGHT);
        gfx = img.getGraphics();
        thread = new Thread(this);
        thread.start();
    }
    
	public void paint(Graphics g){
        

		//g.drawImage(img, 30,30, this);
		//Graphics2D g2 = (Graphics2D)g;
		
		gfx.setColor(Color.black);
        gfx.fillRect(0, 0, WIDTH, HEIGHT);
        if(b1.getX()<-10 || b1.getY() >710){
        	gfx.setColor(Color.red);
        	gfx.drawString("Game Over", 300, 250);
        } else{
        	p1.draw(gfx);
        	b1.draw(gfx);
        	p2.draw(gfx);
        if(!gamestart){
        	gfx.setColor(Color.white);
        	gfx.drawString("You Have Requested a Space War...", 270, 100);
        	gfx.drawString("Press Enter to Battle!", 300, 120);
        }
        g.drawImage(img, 0, 0, this);
        }
        
	}
    public void update(Graphics g){			//Having trouble getting images to show
        paint (g);
        
    }
	
    public void run() {
        for(;;){
        	if(gamestart){
        	p1.move();
        	b1.move();
        	p2.move();
        	b1.checkPaddleCollision(p1, p2);
        	}
            repaint();
            try {
                Thread.sleep(10);                   //All this stuff is automatically added when you right click the symbol in front of the line number
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }    
    }
    
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            p1.setUpAccel(true);
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN){
        	p1.setDownAccel(true);
        }
        else if(e.getKeyCode()==KeyEvent.VK_ENTER){
        	gamestart=true;
        }	        
    }

    
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
        	p1.setUpAccel(false); 
        }
        else if(extracted(e).getKeyCode()==KeyEvent.VK_DOWN){}
        	p1.setDownAccel(false);
    }

	private KeyEvent extracted(KeyEvent e) {
		return e;
	}

    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){   
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN){
        	
        }   
    }
}





