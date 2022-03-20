/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Ataque;

import static game.Utilities.ataqueImagesPath;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class MilLaminasCortantes extends Poder
{
    private static MilLaminasCortantes instancia = null;
    
    public MilLaminasCortantes(Ataque superPoder) throws IOException {
        super(superPoder, ataqueImagesPath.get("supersoco"));
        super.setForca(10);
    }
    
    @Override
    public int atacar(){
        return super.atacar();
    }       
    
    public static synchronized MilLaminasCortantes getInstance(Ataque poder)
        throws IOException
    {
        if (instancia == null) {
            instancia = new MilLaminasCortantes(poder);
        }
        return instancia;
    }
}