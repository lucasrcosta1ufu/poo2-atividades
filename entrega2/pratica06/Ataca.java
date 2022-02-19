
/**
 * Write a description of class Ataca here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Ataca
{
    private int forca;
    
    public void setForca(int forca) {
        this.forca = forca;
    }
    
    public int getForca() {
        return this.forca;
    }
    
    public int atacar(){
        return this.forca;
    }
}
