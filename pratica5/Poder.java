import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Abstract class Poder - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Poder implements Ataca
{
    private int x, y;
    private int ataque; 
    private Ataca next;
    private InputStream power;
    private BufferedImage image;

    public Poder() {}
    
    public Poder(String path) {
        power = getClass().getResourceAsStream(path);
        try
        {
            this.image = ImageIO.read(power);
        }
        catch (java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }
        
    }
    
    public void setX (int x) {
        this.x = x;
    }
    
    public int getX () {
        return this.x;
    }
    
    public void setY (int y) {
        this.y = y;
    }
    
    public int getY () {
        return this.y;
    }
    
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    
    public int getAtaque () {
        return this.ataque;
    }
     
    public void setNext (Ataca proximo) {
        this.next = proximo;
    }
     
    public Ataca getNext () {
        return this.next;
    }
    
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    public BufferedImage getImage() {
        return this.image;
    }
    
    public void setRandomicPosition(int maxX, int maxY) {
        this.x = ThreadLocalRandom.current().nextInt(0, 800);
        this.y = ThreadLocalRandom.current().nextInt(120, maxY - 20); 
    }
}
