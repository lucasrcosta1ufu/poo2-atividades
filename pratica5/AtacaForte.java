
/**
 * Write a description of class AtacaForte here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AtacaForte extends Ataca
{
    public AtacaForte(){
        super.setForca(15);
    }
    
    public int atacar(){
        return super.getForca();
    }
}
