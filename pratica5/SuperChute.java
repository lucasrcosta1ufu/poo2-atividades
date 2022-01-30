
/**
 * Write a description of class SuperChute here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SuperChute extends Poder
{
    private int forca = 17;
    
    public SuperChute(){
        super("./res/superChute.png");
    }
    
    public int atacar(){
        return forca;
    }
}
