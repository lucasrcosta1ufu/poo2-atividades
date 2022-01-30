
/**
 * Write a description of class SuperSoco here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SuperSoco extends Poder
{
    private int forca = 19;
    
    public SuperSoco(){
        super("./res/supersSoco.png");
    }
    
    public int atacar(){
        return forca;
    }       
}
