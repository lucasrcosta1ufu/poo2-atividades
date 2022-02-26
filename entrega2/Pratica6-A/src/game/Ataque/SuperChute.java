package game.Ataque;


/**
 * Write a description of class SuperChute here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SuperChute extends Poder
{
    private int forca = 7;
    
    public SuperChute(Ataque poder) {
        super(poder);
        super.setForca(forca);
    }
    
    public int atacar(){
        return super.atacar();
    }  
}
