package game.Ataque;

import java.awt.image.BufferedImage;
import java.io.InputStream;
/**
 * Abstract class Poder - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Poder extends Ataque
{
    //private int x, y;
    private int ataque; 
    private Ataque superPoder;
    private InputStream power;
    private BufferedImage image;

    public Poder(Ataque superPoder) {
        this.superPoder = superPoder;
    }
    
    public Ataque getSuperPoder() {
        return this.superPoder;
    }
    
    public int atacar(){
        return this.superPoder.atacar() + super.getForca();
    }  
    /*
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
     
    public void setNext (Ataque proximo) {
        this.next = proximo;
    }
     
    public Ataque getNext () {
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
    }*/
    
}
