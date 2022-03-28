package game.Ataque.Futuristic;

import game.Ataque.Ataque;
import game.Ataque.Poder;
import static game.Utilities.futuristicData;
import java.io.IOException;


/**
 * Write a description of class SuperLazer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SuperLazer extends Poder
{
    private static SuperLazer instancia = null;
    
    public SuperLazer(Ataque poder) throws IOException
    {
        super(poder, futuristicData.ataqueImagesPath.get("special"));
        super.setForca(10);
    }
    
    @Override
    public int atacar(){
        return super.atacar();
    }       
    
    public static synchronized SuperLazer getInstance(Ataque poder)
        throws IOException
    {
        if (instancia == null) {
            instancia = new SuperLazer(poder);
        }
        return instancia;
    }
}
