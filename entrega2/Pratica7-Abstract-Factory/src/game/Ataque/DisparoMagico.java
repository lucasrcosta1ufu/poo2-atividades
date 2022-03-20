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
public class DisparoMagico extends Poder
{
    private static DisparoMagico instancia = null;
    
    private int forca = 10;
    
    public DisparoMagico(Ataque poder) throws IOException {
        super(poder, ataqueImagesPath.get("special"));
        super.setForca(forca);
    }
    
    @Override
    public int atacar(){
        return super.atacar();
    }   
    
    public static synchronized DisparoMagico getInstance(Ataque poder)
        throws IOException
    {
        if (instancia == null) {
            instancia = new DisparoMagico(poder);
        }
        return instancia;
    }
}