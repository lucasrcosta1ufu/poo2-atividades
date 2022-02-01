
/**
 * Write a description of class SuperSoco here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SuperSoco extends Poder
{
    private int forca = 5;
    
    public SuperSoco(Ataca poder) {
        super(poder);
        super.setForca(forca);
    }
    
    public int atacar(){
        return super.atacar();
    }     
}
