
/**
 * Write a description of class SuperChute here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SuperChute extends Poder
{
    private int forca = 17;
    
    public SuperChute(Ataca poder) {
        super(poder,"./res/superChute.png");
        super.setForca(forca);
    }
    
    public int atacar(){
        return forca;
    }
}
