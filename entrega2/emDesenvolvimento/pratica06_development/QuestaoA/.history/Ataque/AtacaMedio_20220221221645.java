
/**
 * Write a description of class AtacaMedio here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AtacaMedio extends Ataca
{
    public AtacaMedio(){
        super.setForca(10);
    }
    
    public int atacar(){
        return super.getForca();
    }
}
