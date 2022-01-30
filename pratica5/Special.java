
/**
 * Write a description of class Special here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Special extends Poder
{
    private int forca = 25;
    
    public Special(){
        super("./res/special.png");
    }
    
    public int atacar(){
        return forca;
    }
}
