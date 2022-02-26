package game.Ataque;


/**
 * Write a description of class AtaqueForte here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AtaqueForte extends Ataque
{
    public AtaqueForte(){
        super.setForca(15);
    }
    
    public int atacar(){
        return super.getForca();
    }
}
