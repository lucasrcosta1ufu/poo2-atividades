package game.Ataque;

import static game.Utilities.ataqueImagesPath;
import java.io.IOException;


/**
 * Write a description of class Special here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Special extends Poder
{
    private final int forca = 10;
    
    public Special(Ataque poder) throws IOException
    {
        super(poder, ataqueImagesPath.get("special"));
        super.setForca(forca);
    }
    
    @Override
    public int atacar(){
        return super.atacar();
    }   
}
