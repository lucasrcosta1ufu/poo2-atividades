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
    private static Special instancia = null;
    
    public Special(Ataque poder) throws IOException
    {
        super(poder, ataqueImagesPath.get("special"));
        super.setForca(10);
    }
    
    @Override
    public int atacar(){
        return super.atacar();
    }       
    
    public static synchronized Special getInstance(Ataque poder)
        throws IOException
    {
        if (instancia == null) {
            instancia = new Special(poder);
        }
        return instancia;
    }
}
