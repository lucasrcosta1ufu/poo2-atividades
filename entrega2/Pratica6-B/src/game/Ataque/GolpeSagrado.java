package game.Ataque;

import static game.Utilities.ataqueImagesPath;
import java.io.IOException;


/**
 * Write a description of class SuperSoco here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GolpeSagrado extends Poder
{
    public GolpeSagrado(Ataque poder) throws IOException {
        super(poder, ataqueImagesPath.get("superchute"));
        super.setForca(5);
    }
    
    @Override
    public int atacar(){
        return super.atacar();
    }     
}
