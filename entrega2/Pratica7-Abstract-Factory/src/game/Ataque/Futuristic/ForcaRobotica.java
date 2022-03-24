/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Ataque.Futuristic;

import game.Ataque.Ataque;
import game.Ataque.Poder;
import static game.Utilities.futuristicData;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class ForcaRobotica extends Poder
{
    private static ForcaRobotica instancia = null;
    
    public ForcaRobotica(Ataque superPoder) throws IOException {
        super(superPoder, futuristicData.ataqueImagesPath.get("supersoco"));
        super.setForca(10);
    }
    
    @Override
    public int atacar(){
        return super.atacar();
    }       
    
    public static synchronized ForcaRobotica getInstance(Ataque poder)
        throws IOException
    {
        if (instancia == null) {
            instancia = new ForcaRobotica(poder);
        }
        return instancia;
    }
}
