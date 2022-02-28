package game.Ataque;


/**
 * Write a description of class AtaqueMedio here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AtaqueMedio extends Ataque
{
    public AtaqueMedio(){
        super.setForca(10);
    }
    
    public int atacar(){
        return super.getForca();
    }
}
