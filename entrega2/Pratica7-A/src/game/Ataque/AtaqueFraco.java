package game.Ataque;


/**
 * Write a description of class AtaqueFraco here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AtaqueFraco extends Ataque
{
    public AtaqueFraco(){
        super.setForca(5);
    }
    
    public int atacar(){
        return super.getForca();
    }
}
