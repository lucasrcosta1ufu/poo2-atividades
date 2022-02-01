
/**
 * Write a description of class AtacaFraco here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AtacaFraco extends Ataca
{
    public AtacaFraco(){
        super.setForca(5);
    }
    
    public int atacar(){
        return super.getForca();
    }
}
