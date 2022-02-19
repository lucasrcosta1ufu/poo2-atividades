
/**
 * Write a description of class Special here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Special extends Poder
{
    private int forca = 10;
    
    public Special(Ataca poder) {
        super(poder);
        super.setForca(forca);
    }
    
    public int atacar(){
        return super.atacar();
    }   
}
