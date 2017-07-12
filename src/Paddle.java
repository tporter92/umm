import java.awt.Graphics;

//BackgroundImage=space.png
//Player1Ship=P1.jpg
//Player2Ship=P2.jpg

public interface Paddle {
    public void draw(Graphics g);
    public void move();
    public int getY();
}