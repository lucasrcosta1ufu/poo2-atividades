package game.Ataque.Medieval;

import game.Ataque.Ataque;
import game.Ataque.Poder;
import static game.Utilities.medievalData;
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
        super(poder, medievalData.ataqueImagesPath.get("special"));
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
